package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TreatmentType {
	
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
    private static final String treatmentTypeTable = "create table TreatmentType ("
			+ " id INT NOT NULL AUTO_INCREMENT, "
			+ " name VARCHAR(30), "
			+ " cost INT(5), "
			+ " staffID INT(1), "
			+ " length INT(3), "
			+ " PRIMARY KEY (id), "
			+ " FOREIGN KEY (staffID) REFERENCES Staff(id) "
			+ " )";
	
    // Creates treatment type table, using above string
    public void CreateTreatmeantTypeTable(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(treatmentTypeTable);
			System.out.println("Treatment Type Table created.");
		}
		catch (SQLException e) {
			System.out.println("CreateTreatmentType: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateTreatmentType: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	}
    
    //Add the different types of treatment to the table
    public void PopulateTreatmentTypeTable (Connection conn) throws Exception {
    	
		Statement stmt = null;
		
		try {
			  stmt = conn.createStatement();
			 
			  stmt.executeUpdate("insert into TreatmentType(name, cost, staffID, length) "
			  		+ "values('Check-up','45','1', '20')");
			  stmt.executeUpdate("insert into TreatmentType(name, cost, staffID, length) "
				  		+ "values('Hygiene','45','2', '20')");
			  stmt.executeUpdate("insert into TreatmentType(name, cost, staffID, length) "
				  		+ "values('Silver amalgam filling','90','1', '60')");
			  stmt.executeUpdate("insert into TreatmentType(name, cost, staffID, length) "
				  		+ "values('White composite resin filling','150','1', '60')");
			  stmt.executeUpdate("insert into TreatmentType(name, cost, staffID, length) "
				  		+ "values('Gold crown fitting','500','1', '60')");
			  
		  } 
		  catch (SQLException e1) {
			  System.out.println("PopulateTreatmentTypeTable: error: failed to create a connection object.");
			  e1.printStackTrace();
		  } 
		  catch (Exception e1) {
			  System.out.println("PopulateTreatmentTypeTable: other error:");
			  e1.printStackTrace();
		  } 
		  finally {
			  if  (stmt != null) stmt.close();
		  }	
    }

}
