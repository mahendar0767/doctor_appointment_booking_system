package dentistAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainProgram {
	
	//connect to database
	//need to change passwords here to the group ones
	//the Connection 'conn' is passed into almost every method to enable interaction with the database
	private static Connection conn = null;
	public static Connection getConnection() throws Exception {
	    String driver = "org.gjt.mm.mysql.Driver";
	    String url = "jdbc:mysql://stusql.dcs.shef.ac.uk/team017";
	    String username = "team017";
	    String password = "ae10e470";
//        String driver = "org.gjt.mm.mysql.Driver";
//        String url = "jdbc:mysql://localhost/assignment";
//        String username = "root";
//        String password = "";
	    Class.forName(driver);
	    Connection conn = DriverManager.getConnection(url+"?useSSL=false", username, password);
	    return conn;
	  }
	
	public static void main(String[] args) throws Exception {
		
		
		try { 
			
		conn = getConnection();
		
		//Set up instances so methods can be called
		MyPatient testPatient = new MyPatient();
		MyAddress testAddress = new MyAddress();
		HealthcarePlan testHealthcare = new HealthcarePlan();
		Staff testStaff = new Staff();
		TreatmentType testTT = new TreatmentType();
		TreatmentCredits testCredits = new TreatmentCredits();
		Appointment testAppointment = new Appointment();
		
		
		//Drop all tables
		testStaff.DropTable(conn, "Staff");
		testAppointment.DropTable(conn, "Appointment");
		testHealthcare.DropTable(conn, "HealthcarePlan");
		testCredits.DropTable(conn, "TreatmentCredits");
		testAddress.DropTable(conn, "Address");
		testPatient.DropTable(conn, "Patient");
		testTT.DropTable(conn, "TreatmentType");
		
		
		//Create tables
		testAddress.CreateAddressTable(conn);
		testHealthcare.CreateHealthcarePlanTable(conn);
		testPatient.CreatePatientTable(conn);
		testStaff.CreateStaffTable(conn);
		testTT.CreateTreatmeantTypeTable(conn);
		testCredits.CreateTreatmentCreditsTable(conn);
		testAppointment.CreateAppointment(conn);
		
		
		//Populate tables that need it (i.e. list of staff, list of treatments, list of health care plans)
		testHealthcare.PopulateHealthcareTable(conn);
	    testStaff.PopulateStaffTable(conn);
	    testTT.PopulateTreatmentTypeTable(conn);
	    
	    System.out.println();
		
	    
	    //Part 4.2 Query 1
	    //Testing that creating and retrieving a patient works
	    testPatient.InsertPatientData(conn, "Mr", "Russell", "Westbrook", "121188", "123456", "32", "Leavygreave Road", "Crookesmoor", "Sheffield", "S3 7RD", "None");
		testPatient.PrintPatientData(conn);
		/*
		//Query 2
		//Show patient and current credits
		testPatient.PrintPatientData(conn);
		testPatient.showPatientCredits(conn, "Russell", "Westbrook");
		//Subscribe patient to different plan
		testPatient.changePlan(conn, "Russell", "Westbrook", "Dental Repair");
		testPatient.PrintPatientData(conn);
		//Finding a patient's treatment credits 
		testPatient.showPatientCredits(conn, "Russell", "Westbrook");
		
		*/
	    
		//Query 3
	   
		// add some appointments
		 testAppointment.InsertAppointment(conn, "2017-11-28", "10:20", "11:20", "Dentist", "Russell", "Westbrook");
		 testAppointment.InsertAppointment(conn, "2017-11-29", "10:20", "11:20", "Dentist", "Russell", "Westbrook");
		 testAppointment.InsertAppointment(conn, "2017-11-30", "10:20", "11:20", "Dentist", "Russell", "Westbrook");
		 //Check a staff member's appointments for a week
		 testAppointment.WeeksAppointments(conn, "2017-11-27", "2017-12-04", "Dentist");
		 System.out.println();
		 //Check a staff members appointments for a day
		 testAppointment.DaysAppointments(conn, "2017-11-29", "Dentist");
		 
		 //Query 4
		 testAppointment.InsertAppointment(conn, "2017-12-28", "10:20", "11:20", "Dentist", "Russell", "Westbrook");
		 testAppointment.InsertAppointment(conn, "2017-12-28", "10:30", "11:30", "Dentist", "Russell", "Westbrook");

		
		 //Query 5
		 //add 'blank' patient to database
		 testPatient.InsertPatientData(conn, "Blank", "Blank", "Blank", "Blank", "Blank", "0", "Blank", "Blank", "Blank", "Blank", "None");
		 //Book two days holiday for a staff member
		 testAppointment.BookHoliday(conn, "2017-11-28", "Hygienist");
		 testAppointment.BookHoliday(conn, "2017-11-29", "Hygienist");
		 //Show all appointments are not available for those days
		 testAppointment.WeeksAppointments(conn, "2017-11-27", "2017-11-30", "Hygienist");
		 
		
		
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
