package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyPatient {

    
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
    
 // String used to create the patient table
 // Linked by a foreign key to address and healthcarePlan   
    private static final String patientTable = "create table Patient ( "
		      + " id INT NOT NULL AUTO_INCREMENT, " 
		      + " title VARCHAR(20),  "
		      + " forename VARCHAR(20), "  
		      + " surname VARCHAR(20), " 
		      + " dob VARCHAR(6), "
		      + " phone VARCHAR(20), "
		      + " addr_ID INT, "
		      + " healthcarePlan VARCHAR(30), "
		      + " PRIMARY KEY (id), "
		      + " FOREIGN KEY (addr_ID) REFERENCES Address(id), "
		      + " FOREIGN KEY (healthcarePlan) REFERENCES HealthcarePlan(name)"
		      + " )";
    
    //Creates patient table, using the above string 
    public void CreatePatientTable (Connection conn) throws Exception {
		  
		  Statement stmt = null;
		  try {
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
			  if  (stmt != null) stmt.close();
		  }	
    }
    
    //Adds patient's data to database
    public void InsertPatientData (Connection conn, String title, String forename, String surname, String dob, String phone, String houseNumber, String streetName, String districtName, String city, String postcode, String healthcarePlan) throws Exception {
		  
		  Statement stmt = null;
		  ResultSet credits = null;
		  ResultSet p_ID = null;
		  int a = 0;
		  int b = 0;
		  int c = 0;
		  int i = 0;
		  
		  //If the given address doesn't already exist on the system, a new address entry is added to the address table, and its ID returned.
		  //If the given address already exists, its ID is returned.
		  MyAddress possibleAddress = new MyAddress();
		  int addr_ID = possibleAddress.InsertAddressData(conn, houseNumber, streetName, districtName, city, postcode);
		  
		  try {
			  stmt = conn.createStatement();
			  
			  //finds the credits a patient is eligible for, given the health care plan they have signed up for
			 credits = stmt.executeQuery("SELECT checkUpCredits, hygieneCredits, repairCredits FROM HealthcarePlan WHERE name ='"+healthcarePlan+"'");
			 
			 //stores each credit amount
			 if (credits.next()){
				 a = credits.getInt(1);
				 b = credits.getInt(2);
				 c = credits.getInt(3);
			 } 
			 
			 //creates patient record
			  stmt.executeUpdate("insert into Patient( title, forename, surname, dob, phone, addr_ID, healthcarePlan) "
			  		+ "values('"+title+"','"+forename+"','"+surname+"','"+dob+"','"+phone+"','"+addr_ID+"','"+healthcarePlan+"')");	 
			  
			 //gets the patient id from the newly created record 
			 p_ID = stmt.executeQuery("SELECT id FROM Patient where forename ='"+forename+"' AND surname = '"+surname+"' AND dob ='"+dob+"' AND addr_ID ='"+addr_ID+"'");
			
			 //stores the patient id
			 if (p_ID.next()){
				i = p_ID.getInt("id");
			 }
			 
			//creates a new treatment credits entry for the patient
			 TreatmentCredits patientCredits = new TreatmentCredits();
			 patientCredits.InsertTreatmentCredits(conn, i, a, b, c); 
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
			  if  (stmt != null) stmt.close();
		  }	
	}
    
    //Given a patient, finds their current amount of credits
    public void showPatientCredits (Connection conn, String forename, String surname) throws Exception {
    	Statement stmt = null;
    	int x = 0;
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	
    	try{
    		stmt = conn.createStatement();
    		ResultSet findPatient = stmt.executeQuery("select id from Patient where forename = '"+forename+"' AND surname = '"+surname+"'");
    		if (findPatient.next()){
    			x = findPatient.getInt("id");
    		}
    		ResultSet patientCredits = stmt.executeQuery("select checkUpCredits, hygieneCredits, repairCredits from TreatmentCredits where patientID = "+x);
    		if (patientCredits.next()){
    			a = patientCredits.getInt("checkUpCredits");
    			b = patientCredits.getInt("hygieneCredits");
    			c = patientCredits.getInt("repairCredits");
    			
    			System.out.println("Patient: "+forename+" "+surname+" ");
    			System.out.println("Number of check-up credits: "+a);
    			System.out.println("Number of hygiene credits: "+b);
    			System.out.println("Number of repair credits: "+c);
    			
    		}
    		
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
			  if  (stmt != null) stmt.close();
		  }	
    	
    	
    }
    
    //Changes a patient's health care plan
    public void changePlan (Connection conn, String forename, String surname, String newPlan) throws Exception {
    	Statement stmt = null;
    	
    	int x = 0;
    	int a = 0;
    	int b = 0;
    	int c = 0;
    	
    	try{
    		stmt = conn.createStatement();
    		ResultSet findPatient = stmt.executeQuery("select id from Patient where forename = '"+forename+"' AND surname = '"+surname+"'");
    		if (findPatient.next()){
    			x = findPatient.getInt("id");
    		}
    		stmt.executeUpdate("update Patient set healthcarePlan ='"+newPlan+"' where id = "+x);
    		
    		//Finds the patients new treatment credits and updates their treatment credit record.
    		ResultSet newCredits = stmt.executeQuery("SELECT checkUpCredits, hygieneCredits, repairCredits FROM HealthcarePlan WHERE name ='"+newPlan+"'");
    		if (newCredits.next()){
    			a = newCredits.getInt("checkUpCredits");
    			b = newCredits.getInt("hygieneCredits");
    			c = newCredits.getInt("repairCredits");
    		}
    		
    	
    		stmt.executeUpdate("update TreatmentCredits set checkUpCredits = "+a+" where patientID = "+x);
    		stmt.executeUpdate("update TreatmentCredits set hygieneCredits = "+b+" where patientID = "+x);
    		stmt.executeUpdate("update TreatmentCredits set repairCredits = "+c+" where patientID = "+x);
    		
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
			  if  (stmt != null) stmt.close();
		  }	
    }
    //Prints patient database
    public void PrintPatientData (Connection conn) throws Exception {
		  
		  Statement stmt = null;
		  try {
			  
			  stmt = conn.createStatement();
			 ResultSet res = stmt.executeQuery("select * from Patient join Address on Patient.addr_ID = Address.id join HealthcarePlan on Patient.healthcarePlan = HealthcarePlan.name");
			  while (res.next()){
				  String id = res.getString("id");
				  String title = res.getString("title");
				  String forename = res.getString("forename");
				  String surname = res.getString("surname");
				  String dob = res.getString("dob");
				  String phone = res.getString("phone");
				  String houseNumber = res.getString("houseNumber");
				  String streetName = res.getString("streetName");
				  String districtName = res.getString("districtName");
				  String city = res.getString("city");
				  String postcode = res.getString("postcode");
				  String healthcarePlan = res.getString("name");
				  
				  System.out.println();
				  System.out.println("Patient information: "+title+" "+forename+" "+surname+" "+dob+" "+phone);
				  System.out.println("Patient address: "+houseNumber+" "+streetName+" "+districtName+" "+city+" "+postcode);
				  System.out.print("Patient health care plan: "+healthcarePlan);
				  System.out.println();
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
