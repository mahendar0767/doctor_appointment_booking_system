package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Staff {
	
    //Table design
	private static final String staffTable = "create table Staff ( "
			+ " id INT NOT NULL AUTO_INCREMENT, "
			+ " staffForename VARCHAR(20), "
			+ " staffSurname VARCHAR(20), "
			+ " job VARCHAR(20), "
			+ " PRIMARY KEY(id) "
			+ " )";
	
	// Drop table method, used to delete tables.
    public void DropTable (Connection conn, String TableName) throws Exception {
		 
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
    
 // Creates staff plan table, using above string
    public void CreateStaffTable(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
			
			stmt = conn.createStatement();
			stmt.executeUpdate(staffTable);
			System.out.println("Staff table created.");
		}
		catch (SQLException e) {
			System.out.println("Staff: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("Staff: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	}
    
    //Add the staff to the table
    public void PopulateStaffTable (Connection conn) throws Exception {
    	
		Statement stmt = null;
		
		try {
			 
			  stmt = conn.createStatement();
			 
			  stmt.executeUpdate("insert into Staff(staffForename, staffSurname, job) "
			  		+ "values('Dale','Cooper','Dentist')");
			  stmt.executeUpdate("insert into Staff(staffForename, staffSurname, job) "
				  		+ "values('Laura','Palmer','Hygienist')");
			  stmt.executeUpdate("insert into Staff(staffForename, staffSurname, job) "
				  		+ "values('Lucy','Brennan','Secretary')");
			  
		  } 
		  catch (SQLException e1) {
			  System.out.println("PopulateStaffTable: error: failed to create a connection object.");
			  e1.printStackTrace();
		  } 
		  catch (Exception e1) {
			  System.out.println("PopulateStaffTable: other error:");
			  e1.printStackTrace();
		  } 
		  finally {
			  if  (stmt != null) stmt.close();
		  }	
    }

}
