import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Hospital 
{
	
		static Connection dbConnection = null ;
	    static String     driverClassName = "com.mysql.jdbc.Driver" ;
	    static String     url             = "jdbc:mysql://localhost/hospital";
	    static String     user   = "root" ;
	    static String     passwd = "" ; 
	
		private Tep tep;
		private Pathologic pathologic;
		private Neurologic neurologic;
		private Cardiologic cardiologic ;
		
		private ArrayList <Clinic>  hospitalClinics; 
		private ArrayList <Employee> employees ; 
		private ArrayList<Doctor> doctors;
		private ArrayList<Nurse> nurses;
		private ArrayList<Surgery> surgeryList;

		
		
		public Hospital() //start of constructor
		{
			
			
			tep = new Tep() ;
			pathologic = new Pathologic() ;
			neurologic = new Neurologic() ;
			cardiologic = new Cardiologic() ;
			
			hospitalClinics = new ArrayList<Clinic>() ;
			employees = new ArrayList<Employee>() ;
			doctors = new ArrayList<Doctor>() ;
			nurses = new ArrayList<Nurse>();
			surgeryList = new ArrayList<Surgery>();
			
			//creating tep rooms
			Room room1 = new Room() ;
			Room room2 = new Room() ;
			Room room3 = new Room() ;
			Room room4 = new Room() ;
			Room room5 = new Room() ;
			Room room6 = new Room() ;
			Room room7 = new Room() ;
			Room room8 = new Room() ;
			Room room9 = new Room() ;
			Room room10 = new Room() ;
			Room room11 = new Room() ;
			Room room12 = new Room() ;
			Room room13 = new Room() ;
			Room room14 = new Room() ;
			Room room15 = new Room() ;
			Room room16 = new Room() ;
			Room room17 = new Room() ;
			Room room18 = new Room() ;
			Room room19 = new Room() ;
			Room room20 = new Room() ;
			
			//adding tep room
			tep.addRoom(room1) ;
			tep.addRoom(room2) ;
			tep.addRoom(room3) ;
			tep.addRoom(room4) ;
			tep.addRoom(room5) ;
			tep.addRoom(room6) ;
			tep.addRoom(room7) ;
			tep.addRoom(room8) ;
			tep.addRoom(room9) ;
			tep.addRoom(room10) ;
			tep.addRoom(room11) ;
			tep.addRoom(room12) ;
			tep.addRoom(room13) ;
			tep.addRoom(room14) ;
			tep.addRoom(room15) ;
			tep.addRoom(room16) ;
			tep.addRoom(room17) ;
			tep.addRoom(room18) ;
			tep.addRoom(room19) ;
			tep.addRoom(room20) ;
			
			//creating tep surgeries
			Surgery surgery1 = new Surgery("1", true) ;
			Surgery surgery2 = new Surgery("1", true) ;
			Surgery surgery3= new Surgery("2", true) ;
			Surgery surgery4 = new Surgery("3", true) ;
			
			//adding tep surgeries
			tep.addSurgeries(surgery1) ;
			tep.addSurgeries(surgery2) ;
			tep.addSurgeries(surgery3) ;
			tep.addSurgeries(surgery4) ;
			
			
			//creatingc pathologic rooms
			Room room21 = new Room() ;
			Room room22 = new Room() ;
			Room room23 = new Room() ;
			Room room24 = new Room() ;
			Room room25 = new Room() ;
			Room room26 = new Room() ;
			Room room27 = new Room() ;
			Room room28 = new Room() ;
			Room room29 = new Room() ;
			Room room30 = new Room() ;
			Room room31 = new Room() ;
			Room room32 = new Room() ;
			Room room33 = new Room() ;
			Room room34 = new Room() ;
			Room room35 = new Room() ;
			Room room36 = new Room() ;
			Room room37 = new Room() ;
			Room room38 = new Room() ;
			Room room39 = new Room() ;
			Room room40 = new Room() ;
			
			//adding pathologic rooms
			pathologic.addRoom(room21) ;
			pathologic.addRoom(room22) ;
			pathologic.addRoom(room23) ;
			pathologic.addRoom(room24) ;
			pathologic.addRoom(room25) ;
			pathologic.addRoom(room26) ;
			pathologic.addRoom(room27) ;
			pathologic.addRoom(room28) ;
			pathologic.addRoom(room29) ;
			pathologic.addRoom(room30) ;
			pathologic.addRoom(room31) ;
			pathologic.addRoom(room32) ;
			pathologic.addRoom(room33) ;
			pathologic.addRoom(room34) ;
			pathologic.addRoom(room35) ;
			pathologic.addRoom(room36) ;
			pathologic.addRoom(room37) ;
			pathologic.addRoom(room38) ;
			pathologic.addRoom(room39) ;
			pathologic.addRoom(room40) ;
			
			//creatingc pathologic surgeries
			Surgery surgery5 = new Surgery("1", true) ;
			Surgery surgery6 = new Surgery("4", true) ;
			Surgery surgery7= new Surgery("3", true) ;
			
			
			//adding pathologic surgeries
			pathologic.addSurgeries(surgery5) ;
			pathologic.addSurgeries(surgery6) ;
			pathologic.addSurgeries(surgery7) ;
			
			//creating neurologic rooms
			Room room41 = new Room() ;
			Room room42 = new Room() ;
			Room room43 = new Room() ;
			Room room44 = new Room() ;
			Room room45 = new Room() ;
			Room room46 = new Room() ;
			Room room47 = new Room() ;
			Room room48 = new Room() ;
			Room room49 = new Room() ;
			Room room50 = new Room() ;
			Room room51 = new Room() ;
			Room room52 = new Room() ;
			Room room53 = new Room() ;
			Room room54 = new Room() ;
			Room room55 = new Room() ;
			Room room56 = new Room() ;
			Room room57 = new Room() ;
			Room room58 = new Room() ;
			Room room59 = new Room() ;
			Room room60 = new Room() ;
			
			//adding neurologic room
			neurologic.addRoom(room41) ;
			neurologic.addRoom(room42) ;
			neurologic.addRoom(room43) ;
			neurologic.addRoom(room44) ;
			neurologic.addRoom(room45) ;
			neurologic.addRoom(room46) ;
			neurologic.addRoom(room47) ;
			neurologic.addRoom(room48) ;
			neurologic.addRoom(room49) ;
			neurologic.addRoom(room50) ;
			neurologic.addRoom(room51) ;
			neurologic.addRoom(room52) ;
			neurologic.addRoom(room53) ;
			neurologic.addRoom(room54) ;
			neurologic.addRoom(room55) ;
			neurologic.addRoom(room56) ;
			neurologic.addRoom(room57) ;
			neurologic.addRoom(room58) ;
			neurologic.addRoom(room59) ;
			neurologic.addRoom(room60) ;
			
			//creating neurologic Surgeries 
			Surgery surgery8 = new Surgery("1", true) ;
			Surgery surgery9 = new Surgery("2", true) ;
			
			//adding neurologic Surgeries 
			neurologic.addSurgeries(surgery8) ;
			neurologic.addSurgeries(surgery9) ;
			
			//creating cardiologic rooms
			Room room61 = new Room() ;
			Room room62 = new Room() ;
			Room room63 = new Room() ;
			Room room64 = new Room() ;
			Room room65 = new Room() ;
			Room room66 = new Room() ;
			Room room67 = new Room() ;
			Room room68 = new Room() ;
			Room room69 = new Room() ;
			Room room70 = new Room() ;
			Room room71 = new Room() ;
			Room room72 = new Room() ;
			Room room73 = new Room() ;
			Room room74 = new Room() ;
			Room room75 = new Room() ;
			Room room76 = new Room() ;
			Room room77 = new Room() ;
			Room room78 = new Room() ;
			Room room79 = new Room() ;
			Room room80 = new Room() ;
			
			//adding cardiologic rooms
			cardiologic.addRoom(room61) ;
			cardiologic.addRoom(room62) ;
			cardiologic.addRoom(room63) ;
			cardiologic.addRoom(room64) ;
			cardiologic.addRoom(room65) ;
			cardiologic.addRoom(room66) ;
			cardiologic.addRoom(room67) ;
			cardiologic.addRoom(room68) ;
			cardiologic.addRoom(room69) ;
			cardiologic.addRoom(room70) ;
			cardiologic.addRoom(room71) ;
			cardiologic.addRoom(room72) ;
			cardiologic.addRoom(room73) ;
			cardiologic.addRoom(room74) ;
			cardiologic.addRoom(room75) ;
			cardiologic.addRoom(room76) ;
			cardiologic.addRoom(room77) ;
			cardiologic.addRoom(room78) ;
			cardiologic.addRoom(room79) ;
			cardiologic.addRoom(room80) ;
			
			
			//creating cardiologic Surgeries 
			Surgery surgery10 = new Surgery("2", true) ;
			Surgery surgery11 = new Surgery("4", true) ;
			Surgery surgery12 = new Surgery("3", true) ;
			Surgery surgery13 = new Surgery("4", true) ;
			
			////adding cardiologic Surgeries 
			cardiologic.addSurgeries(surgery10) ;
			cardiologic.addSurgeries(surgery11) ;
			cardiologic.addSurgeries(surgery12) ;
			cardiologic.addSurgeries(surgery13) ;
			
			//creating Doctors
			Doctor doctor1  = new Doctor("Papadimitriou Nikolaos","123456789","3/6/1972","6974273233","GR3456789123345689762357897","Tsimiski 15","Dentist");
			Doctor doctor2  = new Doctor("Samaras Dimitrios","132456789","24/1/1955","6972100200","GR1234567890123456789012345","Papafi 12","Cardiologist") ;
			Doctor doctor3  = new Doctor("Gewrgiou Athanasios","100200300","1/2/1970","6982123456","GR1357902468123456789123456","Papanastasiou 123","Cardiologist") ;
			Doctor doctor4  = new Doctor("Xatzhnikolaou Gewrgios","912345888","14/12/1960","6946677889","GR1234500000123450000012345","Kwnstadinou Karamanlh 49","Psychiatrist") ;
			Doctor doctor5  = new Doctor("Papadimitriou Nikolaos","123456789","12/3/1964","6984112233","GR1234567891011121314151617","Egnatia 25","Neurologist") ;
			Doctor doctor6  = new Doctor("Anufanths Miltiadhs","101112131","8/8/1972","6945697989","GR1234567890000001011121314","Mhtropolews 46","Neurologist") ;
			Doctor doctor7  = new Doctor("Demertzhs Apostolos","100222300","11/4/1977","6975805030","GR1002003004005001112223333","Leoforos Stratou 37","Neurologist") ;
			Doctor doctor8  = new Doctor("Zwgrafos Kwnstantinos","123450000","13/6/1959","6980364258","GR1234567891000001122334455","Boulgarh 19","Allergist") ;
			Doctor doctor9  = new Doctor("Athanasiadh Dhmhtra","567891234","22/11/1972","6981616231","GR7897894564560001234500000","Tsimiski 82","Pathologist") ;
			Doctor doctor10 = new Doctor("Gianakopoulos Theodwros","147258369","5/4/1974","6946121352","GR5465500000123450000078985","Vasilisis Olgas 99","Pathologist") ;
			Doctor doctor11 = new Doctor("Anagnwstou Maria","235641897","17/12/1973","6970123456","GR1456700000111220000025584","Mpotsari 126","Pathologist") ;
			Doctor doctor12 = new Doctor("Vasileiou Alexandros","120045068","3/10/1957","6945886116","GR1234500000112270000091978","Pasalidh 37","Pathologist") ;
			Doctor doctor13 = new Doctor("Mulwna Anastasia","23510109","8/1/1960","6976805631","GR1477400000588250000093639","Delfwn 78","Dermatologist") ;
			Doctor doctor14 = new Doctor("Giannoulhs Nikolaos","025865412","14/8/1963","6980456132","GR1597500000357350000051862","Kleanthous","Obstetrician") ;
			Doctor doctor15 = new Doctor("Dimitriou Eugenia","123005566","4/4/1959","6942600450","GR3232500000987540000012786","Euzwnwn 99","Neurologist") ;
			Doctor doctor16 = new Doctor("Xatzh Gewrgia","129865370","7/11/1966","6975612326","GR7890300000589140000058763","Labraki 31","Orthopedist") ;
			Doctor doctor17 = new Doctor("Fwtiadhs Axilleas","154608831","30/1/1967","6988546231","GR8912200000723110000052478","Svolou 12","Forensic Scientist") ;
			Doctor doctor18 = new Doctor("Sarri Iwanna","5711632299","19/7/1965","6946828623","GR5821300000542310000094257","Perdika 51","Hematologist Surgeon") ;
			Doctor doctor19 = new Doctor("Raptis Kwnstantinos","987654123","10/10/1970","6979154639","GR1144500000636670000087964","Tsimiski 13","Pediatrist") ;
			Doctor doctor20 = new Doctor("Palaiologos Dimitrios","121314151","9/9/1967","6942580635","GR2231000000258160000046312","Vasilisis Olgas 58","Plastic Surgeon") ;
			
			
			
			//adding Doctors to employees
			doctors.add(doctor1);
			doctors.add(doctor2);
			doctors.add(doctor3);
			doctors.add(doctor4);
			doctors.add(doctor5);
			doctors.add(doctor6);
			doctors.add(doctor7);
			doctors.add(doctor8);
			doctors.add(doctor9);
			doctors.add(doctor10);
			doctors.add(doctor11);
			doctors.add(doctor12);
			doctors.add(doctor13);
			doctors.add(doctor14);
			doctors.add(doctor15);
			doctors.add(doctor16);
			doctors.add(doctor17);
			doctors.add(doctor18);
			doctors.add(doctor19);
			doctors.add(doctor20);
			
			
			
			
			//creating nurses 
			Nurse nurse1  = new Nurse("Markou Dimitra","110568915","12/7/1973","6981589646","GR4965500000548970000032148","Giannitswn 15");
			Nurse nurse2  = new Nurse("Papagewrgiou Vasileios","4656891278","23/4/1970","6970258552","GR1201000000711230000058901","Egnatia 87");
			Nurse nurse3  = new Nurse("Papaiwannou Areti","180087956","30/12/1958","6946898222","GR1254600000258130000058121","Tsimiski 91");
			Nurse nurse4  = new Nurse("Malama Katerina","102232565","1/9/1970","6981577521","GR1478900000963250000045682","Vasileos Gewrgiou 37");
			Nurse nurse5  = new Nurse("Mantzarhs Iwannnhs","456826561","23/6/1965","6945102332","GR4971300000179540000016584","Pontou 46");
			Nurse nurse6  = new Nurse("Oikonomou Anna","180960750","4/11/1978","6972451367","GR5416100000155440000044888","Papafi 126");
			Nurse nurse7  = new Nurse("Papoutsis Xristos","415648789","6/7/1970","6980579465","GR1065400000154860000034189","Bosporou 71");
			Nurse nurse8  = new Nurse("Patrwni Aggeliki","465648972","21/1/1959","6977569823","GR5461200000541650000051387","Anatolikis Thrakis 58");
			Nurse nurse9  = new Nurse("Pliatsika Eleutheria","158236941","17/8/1975","6979643218","GR2164100000164870000016484","Mpotsari 32");
			Nurse nurse10 = new Nurse("Reppas Panagiwtis","256155250","24/8/1962","6942265870","GR63126700000215610000015631","Lampraki 14");
			Nurse nurse11 = new Nurse("Rousos Euaggelos","164646430","1/5/1980","6975643197","GR1034100000535420000031358","Lewforos Nikis 57");
			Nurse nurse12 = new Nurse("Tatsi Vasiliki","164689972","9/12/1965","6980643197","GR2334100000303150000013288","Analipsews 31");
			Nurse nurse13 = new Nurse("Spiliopoulos Andreas","165484942","25/3/1957","6946462476","GR6513600000164980000015581","Delfwn 7");
			Nurse nurse14 = new Nurse("Topali Eirini","168468742","4/7/1973","6981545620","GR5165400000541640000003154","Gewrgiou 24");
			Nurse nurse15 = new Nurse("Fileris Mixail","641687212","6/10/1956","6979044648","GR4165400000554420000031561","Kautatzoglou 7");
			Nurse nurse16 = new Nurse("Xalkia Fwteini","212466456","11/2/1968","6970648913","GR4646200000311580000015487","Kwnstantinoupolews 20");
			Nurse nurse17 = new Nurse("Xatzis Marios","534654421","3/1/1970","69715126813","GR5642300000543660000034433","Papanastasiou 36");
			Nurse nurse18 = new Nurse("Karapostolou Anastasios","416423132","9/8/1968","6942568913","GR1546500000205200000046426","Kassandrou 11");
			Nurse nurse19 = new Nurse("Mixa Eleni","156479350","11/4/1969","6978643600","GR1154500000487450000076723","Voulgari 31");
			Nurse nurse20 = new Nurse("Zisopoulos Argiris","516546785","26/10/1977","6975484648","GR5646400000498720000049889","Martiou 23");
			
			//adding nurses to employees
			nurses.add(nurse1);
			nurses.add(nurse2);
			nurses.add(nurse3);
			nurses.add(nurse4);
			nurses.add(nurse5);
			nurses.add(nurse6);
			nurses.add(nurse7);
			nurses.add(nurse8);
			nurses.add(nurse9);
			nurses.add(nurse10);
			nurses.add(nurse11);
			nurses.add(nurse12);
			nurses.add(nurse13);
			nurses.add(nurse14);
			nurses.add(nurse15);
			nurses.add(nurse16);
			nurses.add(nurse17);
			nurses.add(nurse18);
			nurses.add(nurse19);
			nurses.add(nurse20);
			
			
			//adding clinics
			hospitalClinics.add(tep);
			hospitalClinics.add(pathologic);
			hospitalClinics.add(neurologic);
			hospitalClinics.add(cardiologic);
			
			
			surgeryList.add(surgery1);
			surgeryList.add(surgery2);
			surgeryList.add(surgery3);
			surgeryList.add(surgery4);
			surgeryList.add(surgery5);
			surgeryList.add(surgery6);
			surgeryList.add(surgery7);
			surgeryList.add(surgery8);
			surgeryList.add(surgery9);
			surgeryList.add(surgery10);
			surgeryList.add(surgery11);
			surgeryList.add(surgery12);
			surgeryList.add(surgery13);
			
		}//end of constructor
		
		
		public ArrayList<Doctor> getDoctors(){
			
			return doctors;
		}
		
		public ArrayList<Nurse> getNurses(){
			
			return nurses;
		}
		
		public ArrayList<Surgery> getSurgeries(){
			
			return surgeryList;
		}


		
		//1o statistiko
				public String countTepTableSize()
				{
					String countTEP="";
					try {
					    Class.forName(driverClassName);
					    Connection con = DriverManager.getConnection (url,user,passwd);
					    Statement stmt = con.createStatement();
					    String sql= "SELECT COUNT(*) FROM history WHERE clinic = 'TEP'";
					    ResultSet rs = stmt.executeQuery(sql);
					    countTEP=rs.toString();
					    }
						catch (SQLException e) {
								    e.printStackTrace();
						}
						catch (Exception e) {
								    e.printStackTrace();
					}
					return countTEP;
				}
		
		//2o
				public String countTepTableSizePerClinic(String myClinic) 
				{
					String countPerClinic="";
					try {
					    Class.forName(driverClassName);
					    Connection con = DriverManager.getConnection (url,user,passwd);
					    Statement stmt = con.createStatement();
					    String sql="";
						if (myClinic=="TEP"){
					     sql= "SELECT COUNT(*) FROM history WHERE clinic = 'TEP' LIMIT 20";
						}
						else if(myClinic=="Cardiologic"){
						  sql= "SELECT COUNT(*) FROM history WHERE clinic = 'KARDIOLOGIKH' LIMIT 20";	
						}
						else if(myClinic=="Neurologic"){
							 sql= "SELECT COUNT(*) FROM history WHERE clinic = 'NEUROLOGIKH' LIMIT 20";
						}
						else if(myClinic=="Pathologic"){
							sql= "SELECT COUNT(*) FROM history WHERE clinic = 'PATHOLOGIKH' LIMIT 20";
						}
						else 
							System.out.println("Pick a clinic");
						ResultSet rs = stmt.executeQuery(sql);
						countPerClinic=rs.toString();
					    }
						catch (SQLException e) {
								    e.printStackTrace();
						}
						catch (Exception e) {
								    e.printStackTrace();
					}
				    return countPerClinic;
				}
		
		
		//3o
				public String countTepStatisticPerAge()
				{
					String tepPerAge="";
					  try {
					    Class.forName(driverClassName);
					    Connection con = DriverManager.getConnection (url,user,passwd);
					    Statement stmt = con.createStatement();
						String sql= "SELECT AVG(hlikia) FROM history WHERE clinic = 'TEP' LIMIT 20";
						ResultSet rs = stmt.executeQuery(sql);
						tepPerAge=rs.toString();	
					}
					catch (SQLException e) {
							    e.printStackTrace();
					}
					catch (Exception e) {
							    e.printStackTrace();
				}
					  return tepPerAge;
				}
		
		//4o
				public String countSurgeryStatistic()
				{
					String countSurgeries="";
					try {
				    Class.forName(driverClassName);
				    Connection con = DriverManager.getConnection (url,user,passwd);
				    Statement stmt = con.createStatement();
				    //PWS GRAFEI SURGERY
					String sql= "SELECT SURGERY FROM history  LIMIT 20";
					ResultSet rs = stmt.executeQuery(sql);
					countSurgeries=rs.toString();	
				}
				catch (SQLException e) {
						    e.printStackTrace();
				}
				catch (Exception e) {
						    e.printStackTrace();
			}
				  return countSurgeries;
				}
		
		public void printEmployees()
		{
			for(Employee e:employees){
				e.printEmployeeInfo();
			}
		}
		
		
		public double CalculateProfits(){
			return 0 ;
		}
		
		 public double calculateCosts(){
			 return 0 ;
		 }
		 
		 public double printFinancialData(){
			 return 0 ;
		 }

		 public ArrayList<Employee> giveEmployeesArrayList()
		 {
			 return employees ;
		 }
		 
}
		