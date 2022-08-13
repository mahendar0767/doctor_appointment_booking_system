package dentist.practice.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientInfo {
	
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
    
 // String used to create the patient table
    private static final String patientTable = "create table Patient ( "
		      + " id INT NOT NULL AUTO_INCREMENT, " 
		      + " title VARCHAR(20),  "
		      + " firstName VARCHAR(20), "  
		      + " surName VARCHAR(20), " 
		      + " dob DATE , "
		      + " phone VARCHAR(20) ,"
		      + " PRIMARY KEY (id) )";
    
    //Creates patient table, using the above string 
    public void CreatePatientTable () throws Exception {
		  Connection conn = null;
		  Statement stmt = null;
		  try {
			  conn = getConnection();
			  stmt = conn.createStatement();
			  stmt.executeUpdate(patientTable);
			  System.out.println("Patient Table created.");
		  } 
		  catch (SQLException e) {
			  System.out.println("CreatePatient: error: failed to create a connection object.");
			  e.printStackTrace();
		  } 
		  catch (Exception e) {
			  System.out.println("CreatePatient: other error:");
			  e.printStackTrace();
		  } 
		  finally {
			  if  (conn != null) conn.close();
		  }	
    }
    
    
    public void InsertPatientData (String title, String firstName, String surName, String dob, String phone) throws Exception {
		  Connection conn = null;
		  Statement stmt = null;
		  try {
			  conn = getConnection();
			  stmt = conn.createStatement();
			  stmt.executeUpdate("insert into Patient( title, firstName, surName, dob, phone) "
			  		+ "values('"+title+"','"+firstName+"','"+surName+"','"+dob+"','"+phone+"')");	  
		  } 
		  catch (SQLException e1) {
			  System.out.println("InsertPatientData: error: failed to create a connection object.");
			  e1.printStackTrace();
		  } 
		  catch (Exception e1) {
			  System.out.println("InsertPatientData: other error:");
			  e1.printStackTrace();
		  } 
		  finally {
			  if  (conn != null) conn.close();
		  }	
	}
    
    public void PrintPatientData ( String TableName) throws Exception {
		  Connection conn = null;
		  Statement stmt = null;
		  try {
			  conn = getConnection();
			  stmt = conn.createStatement();
			 ResultSet res = stmt.executeQuery("select * from "+ TableName);
			  while (res.next()){
				  String id = res.getString(1);
				  String title = res.getString(2);
				  String firstName = res.getString(3);
				  String surname = res.getString(4);
				  String dob = res.getString(5);
				  String phone = res.getString(6);
				  System.out.println(id+" "+title+" "+firstName+" "+surname+" "+dob+" "+phone);
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


