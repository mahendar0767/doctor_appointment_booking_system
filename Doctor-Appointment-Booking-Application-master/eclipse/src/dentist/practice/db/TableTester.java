package dentist.practice.db;

public class TableTester {

	
	public static void main(String[] args) throws Exception {
		PatientInfo myPatient  = new PatientInfo();
		myPatient.DropTable("Patient");
		myPatient.CreatePatientTable();
		myPatient.InsertPatientData("Mr", "Russell", "Westbrook", "1988-11-12", "123");
		myPatient.InsertPatientData("Mr", "Joel", "Embiid", "1994-04-16", "123");
		myPatient.PrintPatientData("Patient");
		
		Address myAddress = new Address();
		myAddress.DropTable("Address");
		myAddress.CreateAddressTable();
		int firstAddress = myAddress.InsertAddressData("The Diamond", "Sheffield","S3 7RD");
		int duplicateAddress = myAddress.InsertAddressData("The Diamond", "Sheffield","S3 7RD");
		int secondAddress = myAddress.InsertAddressData("Regent Court", "Sheffield","S1 4Dp");
		myAddress.PrintAddressData("Address");
	}
}
