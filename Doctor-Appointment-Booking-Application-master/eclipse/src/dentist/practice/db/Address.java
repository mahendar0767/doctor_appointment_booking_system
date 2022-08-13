package dentist.practice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {
	
    // Method used to connect to mysql server. Url, username & password will need to be changed to the group ones 
    public static Connection getConnection() throws Exception {
        String driver = "org.gjt.mm.mysql.Driver";
        String url = "jdbc:mysql://localhost/assignment";
        String username = "root";
        String password = "";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url+"?useSSL=false", username, password);
        return conn;
      }
    
 // Drop table method, used to delete tables.
    public void DropTable (String TableName ) throws Exception {
		  Connection conn = null;
		  Statement stmt = null;
		  try {
			  conn = getConnection();
			  stmt = conn.createStatement();
			  stmt.executeUpdate("DROP TABLE IF EXISTS " +  TableName );
		  } 
		  catch (SQLException e) {
			  System.out.println("DropTable: error: failed to create a connection object.");
			  e.printStackTrace();
		  } 
		  catch (Exception e) {
			  System.out.println("DropTable: other error:");
			  e.printStackTrace();
		  } 
		  finally {
			  if  (conn != null) conn.close();
		  }	
	  }
    
 // String used to create the address table
    private static final String addressTable = "create table Address ( "
		      + " id INT NOT NULL AUTO_INCREMENT, " 
		      + " firstLine VARCHAR(30),  "
		      + " city VARCHAR(30), "  
		      + " postcode VARCHAR(30), " 
		      + " PRIMARY KEY (id) )";
    
    // Creates address table, using above string
    public void CreateAddressTable() throws Exception {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(addressTable);
			System.out.println("Address Table created.");
		}
		catch (SQLException e) {
			System.out.println("CreateAdress: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAdress: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (conn != null) conn.close();      
		}	
	}
    
    // Checks to see if address already exists in the table, given a firstLine and a postcode
    // If address already exists, returns the address id
    // If not, returns -1
    public int AddressDuplicateCheck (String firstLine, String postcode) throws Exception{
    	Connection conn = null;
    	Statement stmt = null;
		
    	int addressId = -1;
		ResultSet checker = null;
		conn = getConnection();
		stmt = conn.createStatement();
		try {
			// First identify if address exists, based upon house number and postcode
			checker = stmt.executeQuery("SELECT id FROM Address WHERE firstLine = '"
					+ firstLine + "' AND postCode = '" + postcode + "'" ); 
			if (checker.next()) { // if Address exists, get the id
				addressId = checker.getInt("id");
			}
		}
		catch (SQLException e) {
				System.out.println("InsertAddressData: error: failed to create a connection object.");
				e.printStackTrace();
		} 
		catch (Exception e) {
				System.out.println("InsertAddressData: other error:");
				e.printStackTrace();
		} 
		finally {
				if  (conn != null) conn.close();
		}
		return addressId;	
	}
    
    //Adds an address to the table, returning its id.
    //If address already exists, it isn't duplicated.
    public int InsertAddressData (String firstLine, String city, String postcode) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		int addressID = -2; 
		try {
			conn = getConnection();
			addressID = AddressDuplicateCheck (firstLine, postcode);
			if ( addressID < 0 ) {
				stmt = conn.createStatement();
				stmt.executeUpdate("insert into Address( firstLine, city, postcode) "
						+ "values('"+firstLine+"','"+city+"','"+postcode+"')");
			}
		}
		catch (SQLException e) {
				System.out.println("InsertAddressData: error: failed to create a connection object.");
				e.printStackTrace();
		} 
		catch (Exception e) {
				System.out.println("InsertAddressData: other error:");
				e.printStackTrace();
		} 
		finally {	
				if  (conn != null) conn.close();
		}
		addressID = AddressDuplicateCheck (firstLine, postcode);
		return addressID;		
	}
    
    //Prints to screen all addresses in table
    public void PrintAddressData ( String TableName) throws Exception {
		  Connection conn = null;
		  Statement stmt = null;
		  try {
			  conn = getConnection();
			  stmt = conn.createStatement();
			 ResultSet res = stmt.executeQuery("select * from "+ TableName);
			  while (res.next()){
				  String id = res.getString(1);
				  String firstLine = res.getString(2);
				  String city = res.getString(3);
				  String postcode = res.getString(4);
				  System.out.println(id+" "+firstLine+" "+city+" "+postcode);
			  }
			  
		  }
		  catch (SQLException e) {
			  System.out.println("InsertPatientData: error: failed to create a connection object.");
			  e.printStackTrace();
		  } 
		  catch (Exception e) {
			  System.out.println("InsertPatientData: other error:");
			  e.printStackTrace();
		  } 
		  finally {
			  if  (conn != null) conn.close(); 
		  }	
  }
}
