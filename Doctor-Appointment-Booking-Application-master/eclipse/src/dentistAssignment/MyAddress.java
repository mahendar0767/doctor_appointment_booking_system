package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MyAddress {
	
    
 // Drop table method, used to delete tables.
    public void DropTable (Connection conn, String TableName ) throws Exception {
		  
		  Statement stmt = null;
		  try {
			  stmt = conn.createStatement();
			  stmt.execute("SET FOREIGN_KEY_CHECKS=0");
			  stmt.executeUpdate("DROP TABLE IF EXISTS " +  TableName );
			  stmt.execute("SET FOREIGN_KEY_CHECKS=1");
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
			  if  (stmt != null) stmt.close();
		  }	
	  }
    
 // String used to create the address table
    private static final String addressTable = "create table Address ( "
		      + " id INT NOT NULL AUTO_INCREMENT, " 
		      + " houseNumber VARCHAR(30),  "
		      + " streetName VARCHAR(30), "  
		      + " districtName VARCHAR(30), "
		      + " city VARCHAR(30), "
		      + " postcode VARCHAR(30), "
		      + " PRIMARY KEY (id) "
		      + " )";
    
    // Creates address table, using above string
    public void CreateAddressTable(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
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
				if  (stmt != null) stmt.close();      
		}	
	}
    
    // Checks to see if address already exists in the table, given a firstLine and a postcode
    // If address already exists, returns the address id
    // If not, returns -1
    public int AddressDuplicateCheck (Connection conn, String houseNumber, String streetName, String districtName, String city, String postcode) throws Exception{
    	
    	Statement stmt = null;
		
    	int addressId = -1;
		ResultSet checker = null;
		
		stmt = conn.createStatement();
		try {
			// First identify if address exists, based upon house number and postcode
			checker = stmt.executeQuery("select id from Address where houseNumber = '"
					+ houseNumber + "' AND streetName = '" + streetName + "' AND districtName = '"
					+ districtName + "' AND city = '" + city + "' AND postcode = '" + postcode +"'"); 
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
				if  (stmt != null) stmt.close();
		}
		return addressId;	
	}
    
    //Adds an address to the table, returning its id.
    //If address already exists, it isn't duplicated.
    public int InsertAddressData (Connection conn, String houseNumber, String streetName, String districtName, String city, String postcode) throws Exception {
		Statement stmt = null;
		int addressID = -2; 
		try {
			addressID = AddressDuplicateCheck (conn, houseNumber, streetName, districtName, city, postcode);
			if ( addressID < 0 ) {
				stmt = conn.createStatement();
				stmt.executeUpdate("insert into Address( houseNumber, streetName, districtName, city, postcode) "
						+ "values('"+houseNumber+"','"+streetName+"','"+districtName+"','"+city+"','"+postcode+"')");
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
				if  (stmt != null) stmt.close();
		}
		addressID = AddressDuplicateCheck (conn, houseNumber, streetName, districtName, city, postcode);
		return addressID;		
	}
    
    //Prints to screen all addresses in table (only used for testing)
    public void PrintAddressData ( Connection conn, String TableName) throws Exception {
		  
		  Statement stmt = null;
		  try {
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
			  if  (stmt != null) stmt.close(); 
		  }	
  }
	
	

}
