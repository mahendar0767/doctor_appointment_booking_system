package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HealthcarePlan {
	
	
	
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
    
    private static final String healthcarePlanTable = "create table HealthcarePlan ("
			+ " name VARCHAR(30) NOT NULL,"
			+ " cost INT, "
			+ " checkUpCredits INT, "
			+ " hygieneCredits INT, "
			+ " repairCredits INT, "
			+ " PRIMARY KEY (name) "
			+ " )";
    
    // Creates healthcare plan table, using above string
    public void CreateHealthcarePlanTable(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
		
			stmt = conn.createStatement();
			stmt.executeUpdate(healthcarePlanTable);
			System.out.println("Healthcare plan Table created.");
		}
		catch (SQLException e) {
			System.out.println("CreateHealthcarePlan: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateHealthcarePlan: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	}
    
    //Populates table with the different health care plans
    public void PopulateHealthcareTable (Connection conn) throws Exception {
    	
		Statement stmt = null;
		
		try {
			  
			  stmt = conn.createStatement();
			 
			  stmt.executeUpdate("insert into HealthcarePlan(name, cost, checkUpCredits, hygieneCredits, repairCredits) "
			  		+ "values('NHS Free Plan','0','2','2','6')");
			  stmt.executeUpdate("insert into HealthcarePlan(name, cost, checkUpCredits, hygieneCredits, repairCredits) "
				  		+ "values('Maintenance','15','2','2','0')");
			  stmt.executeUpdate("insert into HealthcarePlan(name, cost, checkUpCredits, hygieneCredits, repairCredits) "
				  		+ "values('Oral','21','2','4','0')");
			  stmt.executeUpdate("insert into HealthcarePlan(name, cost, checkUpCredits, hygieneCredits, repairCredits) "
				  		+ "values('Dental Repair','36','2','2','2')");
			  stmt.executeUpdate("insert into HealthcarePlan(name, cost, checkUpCredits, hygieneCredits, repairCredits) "
				  		+ "values('None','0','0','0','0')");
		  } 
		  catch (SQLException e1) {
			  System.out.println("PopulateHealthcareTable: error: failed to create a connection object.");
			  e1.printStackTrace();
		  } 
		  catch (Exception e1) {
			  System.out.println("PopulateHealthcareTable: other error:");
			  e1.printStackTrace();
		  } 
		  finally {
			  if  (stmt != null) stmt.close();
		  }	
    }

}
