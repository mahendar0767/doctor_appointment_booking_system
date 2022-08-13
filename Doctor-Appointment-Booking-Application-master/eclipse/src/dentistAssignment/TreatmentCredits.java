package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Stores the number of treatment credits a patient currently has
public class TreatmentCredits {
	
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
    
    //Table design
    private static final String treatmentCreditsTable = "create table TreatmentCredits ("
			+ " id INT NOT NULL AUTO_INCREMENT,"
			+ " patientID INT, "
			+ " checkUpCredits INT, "
			+ " hygieneCredits INT, "
			+ " repairCredits INT, "
			+ " PRIMARY KEY (id),  "
			+ " FOREIGN KEY (patientID) REFERENCES Patient(id)"
			+ " )";
    
 // Creates treatment credits table, using above string
    public void CreateTreatmentCreditsTable(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(treatmentCreditsTable);
			System.out.println("Treatment credits Table created.");
		}
		catch (SQLException e) {
			System.out.println("CreateTreatmentCreditsTable: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateTreatmentCreditsTable: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	}
    
    //Adds a patient and their credits to the table
    public void InsertTreatmentCredits (Connection conn, int patientID, int checkUpCredits, int hygieneCredits, int repairCredits) throws Exception{
    	
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into TreatmentCredits( patientID, checkUpCredits, hygieneCredits, repairCredits) "
						+ "values('"+patientID+"','"+checkUpCredits+"','"+hygieneCredits+"','"+repairCredits+"')");
			
		}
		catch (SQLException e) {
				System.out.println("InsertTreatmentCredits: error: failed to create a connection object.");
				e.printStackTrace();
		} 
		catch (Exception e) {
				System.out.println("InsertTreatmentCredits: other error:");
				e.printStackTrace();
		} 
		finally {	
				if  (stmt != null) stmt.close();
		}
    }
    

}
