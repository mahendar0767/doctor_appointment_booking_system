package dentistAssignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Appointment {
	
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
    
    private static final String appointmentTable = "create table Appointment("
    		+ " id INT NOT NULL AUTO_INCREMENT, "
    		+ " startTime DATETIME, "
    		+ " endTime DATETIME,"
    		+ " staffID INT, "
    		+ " patientID INT, "
    		+ " PRIMARY KEY (id), "
    		+ " FOREIGN KEY (staffID) REFERENCES Staff(id), "
    		+ " FOREIGN KEY (patientID) REFERENCES Patient(id) "
    		+ " )";
    
 // Creates appointment type table, using above string
    public void CreateAppointment(Connection conn) throws Exception {
		
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(appointmentTable);
			System.out.println("Appointment Table created.");
		}
		catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	}
    //Checks to see if a new appointment will clash with an appointment already on the system. Returns true if there is a clash.
    public boolean DuplicateAppointment (Connection conn, int year, int month, int day, int startHour, int startMinute, int endHour, int endMinute, int possStaff) throws Exception{
    	Statement stmt = null;
    	ResultSet appts = null;
    	
    	try {
    		stmt = conn.createStatement();
    		appts = stmt.executeQuery("SELECT * from Appointment "
    				+ "WHERE startTime <='"+year+"-"+month+"-"+day+" "+startHour+":"+startMinute+":00'"
    				+ "AND endTime >= '"+year+"-"+month+"-"+day+" "+startHour+":"+startMinute+":00'"
    				+ "AND staffID ="+possStaff);
    		if (appts.next()){
    			return true;
    		}
    		appts = stmt.executeQuery("SELECT * from Appointment "
    				+ "WHERE startTime <='"+year+"-"+month+"-"+day+" "+endHour+":"+endMinute+":00'"
    				+ "AND endTime >= '"+year+"-"+month+"-"+day+" "+endHour+":"+endMinute+":00'"
    				+ "AND staffID ="+possStaff);
    		if (appts.next()){
    			return true;
    		}
    		
    	}
    	catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}
    	return false;
    	
    }
    
    //Given a date and staff member, 'books' that day as holiday by inserting a blank patient into every appointment slot.
    public void BookHoliday (Connection conn, String holidayDate, String staffMember) throws Exception{
    	
    	Statement stmt = null;
    	ResultSet staffIDFinder = null;
    	int staffID = 0;
    	ResultSet patientIDFinder = null;
    	int patientID = 0;
    	
    	//Split given date string into integers
    	int year = Integer.parseInt(holidayDate.substring(0, 4));
    	int month = Integer.parseInt(holidayDate.substring(5, 7));
    	int day = Integer.parseInt(holidayDate.substring(8, 10));
    	
    	try {
			stmt = conn.createStatement();
			staffIDFinder = stmt.executeQuery("SELECT id from Staff where job ='"+staffMember+"'");
			if (staffIDFinder.next()){
				staffID = staffIDFinder.getInt("id");
			}
			
			patientIDFinder = stmt.executeQuery("SELECT id from Patient where forename ='Blank'");
			if (patientIDFinder.next()){
				patientID = patientIDFinder.getInt("id");
			}
			
			stmt.executeUpdate("INSERT into Appointment (startTime, endTime, staffID, patientID) "
					+ "VALUES('"+year+"-"+month+"-"+day+" 09:00:00','"+year+"-"+month+"-"+day+" 17:00:00',"+staffID+", "+patientID+")" );
		}
		catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}

    }
    
    //Given a date, start time, end time, staff member and patient, books an appointment at that time and date.
    public void InsertAppointment (Connection conn, String apptDate, String startTime, String endTime, String staffMember, String forename, String surname) throws Exception {
    	
    	Statement stmt = null;
    	ResultSet staffIDFinder = null;
    	int staffID = 0;
    	ResultSet patientIDFinder = null;
    	int patientID = 0;
    	
    	//Get the date in separate integers from the given string apptDate
    	int year = Integer.parseInt(apptDate.substring(0, 4));
    	int month = Integer.parseInt(apptDate.substring(5, 7));
    	int day = Integer.parseInt(apptDate.substring(8, 10));
    	
    	//Get the start and end hours and minutes of the appointment from the given strings startTime and endTime
    	int startHour = Integer.parseInt(startTime.substring(0, 2));
    	int startMinute = Integer.parseInt(startTime.substring(3, 5));
    	int endHour = Integer.parseInt(endTime.substring(0, 2));
    	int endMinute = Integer.parseInt(endTime.substring(3, 5));
    	
    	try {
			stmt = conn.createStatement();
			staffIDFinder = stmt.executeQuery("SELECT id from Staff where job ='"+staffMember+"'");
			if (staffIDFinder.next()){
				staffID = staffIDFinder.getInt("id");
			}
			patientIDFinder = stmt.executeQuery("SELECT id from Patient where forename ='"+forename+"' AND surname ='"+surname+"'");
			if (patientIDFinder.next()){
				patientID = patientIDFinder.getInt("id");
			}
			//Check if the appointment will clash with any others. If not, insert into the table.
			if (!DuplicateAppointment(conn,year, month, day, startHour, startMinute, endHour, endMinute, staffID)) {
			stmt.executeUpdate("INSERT into Appointment (startTime, endTime, staffID, patientID) "
					+ "VALUES('"+year+"-"+month+"-"+day+" "+startHour+":"+startMinute+":00','"+year+"-"+month+"-"+day+" "+endHour+":"+endMinute+":00',"+staffID+", "+patientID+")" );
			System.out.println("Appointment booked.");
			}
			else
				System.out.println("Appointment could not be booked due to a clash.");
		}
		catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
  
    }
    
    //Given a staff member and a start and end date, prints to screen all appointments between those dates.
    public void WeeksAppointments (Connection conn, String weekStart, String weekEnd, String staffMember) throws Exception{
    	Statement stmt = null;
    	
    	ResultSet appts = null;
    	ResultSet staffIDFinder = null;
    	ResultSet patientNameFinder = null;
    	String patientName = "";
    	int staffID = 0;
    	
    	
    	//Splits given start date string into integers
    	int startYear = Integer.parseInt(weekStart.substring(0, 4));
    	int startMonth = Integer.parseInt(weekStart.substring(5, 7));
    	int startDay = Integer.parseInt(weekStart.substring(8, 10));
    	
    	//Splits given end date string into integers
    	int endYear = Integer.parseInt(weekEnd.substring(0, 4));
    	int endMonth = Integer.parseInt(weekEnd.substring(5, 7));
    	int endDay = Integer.parseInt(weekEnd.substring(8, 10));
    	
    	try {
			stmt = conn.createStatement();
			staffIDFinder = stmt.executeQuery("SELECT id from Staff where job ='"+staffMember+"'");
			if (staffIDFinder.next()){
				staffID = staffIDFinder.getInt("id");
				
			}
			//Selects all apointments between start and end date for a given staff member
			appts = stmt.executeQuery("SELECT * from Appointment"
					+ " WHERE startTime >='"+startYear+"-"+startMonth+"-"+startDay+"  09:00:00'"
					+ " AND startTime <='"+endYear+"-"+endMonth+"-"+endDay+" 17:00:00'"
					+ " AND staffID = "+staffID);
			
			System.out.println();
			
			//Finds the date, times, and patient for each appointment.
			System.out.println("Weekly appointments for staff member: "+ staffMember);
			while (appts.next()){
				
				String day = appts.getString("startTime").substring(8,10);
				String month = appts.getString("startTime").substring(5,7);
				String apptStart = appts.getString("startTime").substring(11,16);
				String apptEnd = appts.getString("endTime").substring(11,16);
				int apptPatient = appts.getInt("patientID");
				stmt = conn.createStatement();
				patientNameFinder = stmt.executeQuery("SELECT forename, surname from Patient where id ="+apptPatient);
				if(patientNameFinder.next()){
					patientName = patientNameFinder.getString("forename")+" "+patientNameFinder.getString("surname") ;
				}

				System.out.println();
				System.out.println("Date: "+day+"/"+month+" Start time = "+apptStart+" End time = "+apptEnd+" Patient: "+patientName);

			}
		}
		catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
	
    }
    
    //Given a day and a staff member, prints to screen all of the day's appointments.
    public void DaysAppointments (Connection conn, String day, String staffMember) throws Exception{
    	Statement stmt = null;
    	ResultSet appts = null;
    	ResultSet staffIDFinder = null;
    	int staffID = 0;
    	ResultSet patientNameFinder = null;
    	String patientName = "";
    	
    	//Splits the given day string into integers
    	int year = Integer.parseInt(day.substring(0, 4));
    	int month = Integer.parseInt(day.substring(5, 7));
    	int apptDay = Integer.parseInt(day.substring(8, 10));
    	
    	try {
			stmt = conn.createStatement();
			staffIDFinder = stmt.executeQuery("SELECT id from Staff where job ='"+staffMember+"'");
			if (staffIDFinder.next()){
				staffID = staffIDFinder.getInt("id");
				
			}
			//Finds all appointments 
			appts = stmt.executeQuery("SELECT * from Appointment"
					+ " WHERE startTime >='"+year+"-"+month+"-"+apptDay+"  09:00:00'"
					+ " AND startTime <='"+year+"-"+month+"-"+apptDay+" 17:00:00'"
					+ " AND staffID = "+staffID);
			
			System.out.println();
			System.out.println("Daily appointments for staff member: "+staffMember);
			while (appts.next()){
				
				String startTime = appts.getString("startTime").substring(11,16);
				String endTime = appts.getString("endTime").substring(11,16);
				int apptPatient = appts.getInt("patientID");
				stmt = conn.createStatement();
				patientNameFinder = stmt.executeQuery("SELECT forename, surname from Patient where id ="+apptPatient);
				if(patientNameFinder.next()){
					patientName = patientNameFinder.getString("forename")+" "+patientNameFinder.getString("surname") ;
				}
				
				
				
				System.out.println();
				System.out.println("Start time: " +startTime+" End time: "+endTime+" Patient: "+patientName);
				
				
			}
		}
		catch (SQLException e) {
			System.out.println("CreateAppointment: error: failed to create a connection object.");
			e.printStackTrace();
		} 
		catch (Exception e) {
			System.out.println("CreateAppointment: other error:");
			e.printStackTrace();
		} 
		finally {
				if  (stmt != null) stmt.close();      
		}	
    	
    	
    	
    }
    
    

}
