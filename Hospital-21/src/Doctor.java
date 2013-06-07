import java.util.ArrayList;

public class Doctor extends Employee {

	    private double wage = 2000 ;
		private String specialty;

		 

		public Doctor(String NAME, String AFM, String BIRTHDATE, String PHONE, String BANKACCOUNT, String ADDRESS,String specialty)
		 {
			 super(NAME, AFM, BIRTHDATE, PHONE, BANKACCOUNT, ADDRESS);
			 this.specialty = specialty ;
		 }
		 
		 public void printEmployeeInfo(){
			 super.printEmployeeInfo();
			 System.out.println(specialty);
		 }
		 
		  public void setWage(double wage) //per month
		 {
			 this.wage = wage;
		 }
		 
		 public double printWage() //per month
		 {
			 return wage;
		 }
		 
		 
		 
		 public String getSpecialty() {
			return specialty;
		}

		public void setSpecialty(String specialty) {
			this.specialty = specialty;
		}

	
}
