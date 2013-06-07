public abstract class Employee {

		//private double wage;
		
		private String name ;
		private String afm ;
		private String birthDate ;
		private String phone ;
		private String bankAccount ;
		private String address ;
		
		//kataskeuasths ths klashs Employee 
		public Employee(String NAME, String AFM, String BIRTHDATE, String PHONE, String BANKACCOUNT, String ADDRESS){
			name = NAME;
			afm = AFM;
			birthDate = BIRTHDATE;
			phone = PHONE;
			bankAccount = BANKACCOUNT;
			address = ADDRESS;
		}
		
		//ektupwsh twn stoixeiwn twn upallhlwn
		public void printEmployeeInfo(){
			System.out.println(name);
			System.out.println(afm);
			System.out.println(birthDate);
			System.out.println(phone);
			System.out.println(bankAccount);
			System.out.println(address);
		}

		
		
		
		
		
		
		
		
		
		
		
		abstract public double printWage() ;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAfm() {
			return afm;
		}

		public void setAfm(String afm) {
			this.afm = afm;
		}

		public String getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getBankAccount() {
			return bankAccount;
		}

		public void setBankAccount(String bankAccount) {
			this.bankAccount = bankAccount;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		

      
	
	 
}
