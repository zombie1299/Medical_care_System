public class Nurse extends Employee {

		final double wage = 800; //wage per month
		
		public Nurse(String NAME, String AFM, String BIRTHDATE, String PHONE,String BANKACCOUNT, String ADDRESS) {
			
			super(NAME, AFM, BIRTHDATE, PHONE, BANKACCOUNT, ADDRESS);
			
		}
		
		public double printWage() //per month
		 {
			 return wage;
		 }
}
