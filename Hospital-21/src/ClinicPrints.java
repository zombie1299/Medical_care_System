import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;



public class ClinicPrints extends JFrame{

	private JButton TEP_RoomsButton,Neurologikh_RoomsButton,
	                Pathologikh_RoomsButton,Kardiologikh_RoomsButton;
	private JLabel ImagePanel;
	private JButton TClinicButton,NClinicButton,KClinicButton,PClinicButton;
	private JButton TEP_epexergasiaButton,Neurologikh_epexergasiaButton,Kardiologikh_epexergasiaButton,Pathologikh_epexergasiaButton;
	private JButton TEP_OKButton,Neurologikh_OKButton,Kardiologikh_OKButton,Pathologikh_OKButton;
	
	static Connection dbConnection = null ;
    static String     driverClassName = "com.mysql.jdbc.Driver" ;
    static String     url             = "jdbc:mysql://localhost/hospital";
    static String     user   = "root" ;
    static String     passwd = "" ; 
	
	public ClinicPrints(){
		
		ImagePanel= new JLabel();
		
		TClinicButton= new JButton("ΤΕΠ");
		NClinicButton= new JButton("Νευρολογική");
		KClinicButton= new JButton ("Καρδιολογική");
		PClinicButton= new JButton ("Παθολογική");

		TClinicButton.setSize(150, 50);
		NClinicButton.setSize(150, 50);
		KClinicButton.setSize(150, 50);
		PClinicButton.setSize(150, 50);
		
		TClinicButton.setLocation(30, 20);
		NClinicButton.setLocation(250, 20);
		KClinicButton.setLocation(30, 150);
		PClinicButton.setLocation(250, 150);
		
		TClinicButton.setBackground(Color.getHSBColor(100, 50, 700));
		NClinicButton.setBackground(Color.getHSBColor(100, 50, 700));
		KClinicButton.setBackground(Color.getHSBColor(100, 50, 700));
		PClinicButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		TClinicButton.setOpaque(true);
		NClinicButton.setOpaque(true);
		KClinicButton.setOpaque(true);
		PClinicButton.setOpaque(true);
		
		
		
		TClinicButton.addActionListener( new ClinicButtonListener());
		NClinicButton.addActionListener( new ClinicButtonListener());
		KClinicButton.addActionListener( new ClinicButtonListener());
		PClinicButton.addActionListener( new ClinicButtonListener());
		
		
		
		ImagePanel.add(TClinicButton);
		ImagePanel.add(NClinicButton);
		ImagePanel.add(KClinicButton);
		ImagePanel.add(PClinicButton);
		
		this.setBackground(Color.getHSBColor(120, 50, 250));

		
		this.setContentPane(ImagePanel);
		
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("ΚΛΙΝΙΚΕΣ");
		this.setResizable(false);
		
	}
	class ClinicButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == TClinicButton){
				new TEP_Rooms();
			}else if (e.getSource() == NClinicButton){
				new Neurologikh_Rooms();
			}else if (e.getSource() == KClinicButton){
				new Kardiologikh_Rooms();
			}else if (e.getSource() == PClinicButton){
				new Pathologikh_Rooms();
			}
		}

            class Pathologikh_Rooms extends JFrame {
			
			private JLabel Pathologikh_Label;
			
			
			public Pathologikh_Rooms(){
				ImageIcon PathologikhIcon = new ImageIcon("Pathologikh_Rooms.gif");
				Pathologikh_Label=new JLabel(PathologikhIcon);
				
				Pathologikh_RoomsButton=new JButton("ΔΩΜΑΤΙΑ");
				Pathologikh_RoomsButton.setSize(150, 50);
				Pathologikh_RoomsButton.setLocation(400, 100);
				Pathologikh_RoomsButton.addActionListener(new ButtonListener());
				Pathologikh_Label.add(Pathologikh_RoomsButton);
				
				Pathologikh_RoomsButton.setOpaque(true);
				Pathologikh_RoomsButton.setBackground(Color.getHSBColor(100, 50, 700));
				this.setResizable(false);
				
				this.setBackground(Color.getHSBColor(120, 50, 250));
				this.setContentPane(Pathologikh_Label);
				this.setResizable(false);
				this.setSize(630,700);
				this.setVisible(true);
				this.setTitle("Παθολογική");
			}
		}

            class Kardiologikh_Rooms extends JFrame {
			
			private JLabel Kardiologikh_Label;
			
			
			public Kardiologikh_Rooms(){
				ImageIcon KardiologikhIcon = new ImageIcon("Kardiologikh_Rooms.gif");
				Kardiologikh_Label=new JLabel(KardiologikhIcon);
				
				Kardiologikh_RoomsButton=new JButton("ΔΩΜΑΤΙΑ");
				Kardiologikh_RoomsButton.setSize(150, 50);
				Kardiologikh_RoomsButton.setLocation(400, 100);
				Kardiologikh_RoomsButton.addActionListener(new ButtonListener());
				Kardiologikh_Label.add(Kardiologikh_RoomsButton);
				
				Kardiologikh_RoomsButton.setOpaque(true);
				Kardiologikh_RoomsButton.setBackground(Color.getHSBColor(100, 50, 700));
				this.setResizable(false);
				
				this.setContentPane(Kardiologikh_Label);
				this.setBackground(Color.getHSBColor(120, 50, 250));
				this.setSize(630,700);
				this.setVisible(true);
				this.setTitle("Καρδιολογική");
			}
		}

		class Neurologikh_Rooms extends JFrame {
			
			private JLabel Neurologikh_Label;
			
			
			public Neurologikh_Rooms(){
				ImageIcon NeurologikhIcon = new ImageIcon("Neurologikh_Rooms.gif");
				Neurologikh_Label=new JLabel(NeurologikhIcon);
				
				Neurologikh_RoomsButton=new JButton("ΔΩΜΑΤΙΑ");
				Neurologikh_RoomsButton.setSize(150, 50);
				Neurologikh_RoomsButton.setLocation(400, 100);
				Neurologikh_RoomsButton.addActionListener(new ButtonListener());
				Neurologikh_Label.add(Neurologikh_RoomsButton);
				
				Neurologikh_RoomsButton.setOpaque(true);
				Neurologikh_RoomsButton.setBackground(Color.getHSBColor(100, 50, 700));
				this.setResizable(false);
				
				this.setContentPane(Neurologikh_Label);
				this.setBackground(Color.getHSBColor(120, 50, 250));
				this.setSize(630,700);
				this.setVisible(true);
				this.setTitle("Νευρολογική");
			}
		}

		class TEP_Rooms extends JFrame {
		
			private JLabel TEP_Label;
			
			
			public TEP_Rooms(){
				ImageIcon TEPIcon = new ImageIcon("TEP_Rooms.gif");
				TEP_Label=new JLabel(TEPIcon);
				
				
				
				TEP_RoomsButton=new JButton("ΔΩΜΑΤΙΑ");
				TEP_RoomsButton.setSize(150, 50);
				TEP_RoomsButton.setLocation(400, 100);
				TEP_RoomsButton.addActionListener(new ButtonListener());
				TEP_Label.add(TEP_RoomsButton);
				
				TEP_RoomsButton.setOpaque(true);
				TEP_RoomsButton.setBackground(Color.getHSBColor(100, 50, 700));
				this.setResizable(false);
				
				this.setContentPane(TEP_Label);
				this.setBackground(Color.getHSBColor(120, 50, 250));
				this.setSize(630,700);
				this.setVisible(true);
				this.setTitle("ΤΕΠ");
			}
		}
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == TEP_RoomsButton){
				new TEP_RoomsPlan();
			}else if (e.getSource() == Kardiologikh_RoomsButton){
				new Kardiologikh_RoomsPlan();
			}else if (e.getSource() == Neurologikh_RoomsButton){
				new Neurologikh_RoomsPlan();
			}else if (e.getSource() == Pathologikh_RoomsButton){
				new Pathologikh_RoomsPlan();
			}
		}
	}
	
	class TEP_RoomsPlan extends JFrame{
		
		private JPanel MainPanel;
    	private JTable RoomsPlanTable;
		private JLabel ButtonPanel;
		
		private ArrayList roomList = new ArrayList() ;
		
		
		
		public TEP_RoomsPlan(){
			
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT name FROM history WHERE room = 1";
			    ResultSet rs = stmt.executeQuery(sql);
				
			    while (rs.next()){
			    	
			        String name = rs.getString("name");
			        roomList.add(name) ;
			       			        			       
			        }
			    
			   
			    
			    if(roomList.size() == 0 )
		        {
		    	   String string = "" ;
		    	   
		    	   roomList.add(0,string) ;
		    	   roomList.add(1,string) ;
		    	   roomList.add(2,string) ;
		        }
			    else if(roomList.size() == 1 )
		        {
		    	   String string = "" ;
		    	   
		    	   
		    	   roomList.add(1,string) ;
		    	   roomList.add(2,string) ;
		        }
		       else if(roomList.size() == 2)
		       { 
		    	   String string = "" ;
		    	   
		    	   roomList.add(2,string) ;
		       }
		       else
		       {}
			    }
			
			
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}
			
		    
			
			String[] columnNamesVisit = {"Δωμάτια","Κλίνη 1","Κλίνη 2","Κλίνη 3"};
			Object[][] dataOfVisit = {
				     {"Δωμάτιο 1",roomList.get(0), roomList.get(1), roomList.get(2)},{"Δωμάτιο 2"," "," "," "},{"Δωμάτιο 3"," "," "," "}
				    ,{"Δωμάτιο 4"," "," "," "},{"Δωμάτιο 5"," "," "," "},{"Δωμάτιο 6"," "," "," "},{"Δωμάτιο 7"," "," "," "},{"Δωμάτιο 8"," "," "," "}
				    ,{"Δωμάτιο 9"," "," "," "},{"Δωμάτιο 10"," "," "," "},{"Δωμάτιο 11"," "," "," "},{"Δωμάτιο 12"," "," "," "},{"Δωμάτιο 13"," "," "," "}
				    ,{"Δωμάτιο 14"," "," "," "},{"Δωμάτιο 15"," "," "," "},{"Δωμάτιο 16"," "," "," "},{"Δωμάτιο 17"," "," "," "},{"Δωμάτιο 18"," "," "," "}
				    ,{"Δωμάτιο 19"," "," "," "},{"Δωμάτιο 20"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			RoomsPlanTable.setEnabled(false);
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();

	        JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			
			TEP_epexergasiaButton=new JButton("Επεξεργασία");
			TEP_epexergasiaButton.setSize(150, 40);
			TEP_epexergasiaButton.setLocation(460, 80);
			TEP_epexergasiaButton.addActionListener(new TEPButtonListener());
			ButtonPanel.add(TEP_epexergasiaButton);
			
			TEP_OKButton=new JButton("OK");
			TEP_OKButton.setSize(150, 40);
			TEP_OKButton.setLocation(10, 80);
			TEP_OKButton.addActionListener(new TEPButtonListener());
			ButtonPanel.add(TEP_OKButton);
			
			TEP_OKButton.setOpaque(true);
			TEP_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
			
			TEP_epexergasiaButton.setOpaque(true);
			TEP_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
			this.setResizable(false);
			
			MainPanel.add(tableSP);
			MainPanel.add(ButtonPanel);
			
			this.setContentPane(MainPanel);
			this.setResizable(false);
			this.setSize(630,750);
			this.setVisible(true);
			this.setTitle("Κλίνες ΤΕΠ");
		}
		class TEPButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == TEP_epexergasiaButton){
					RoomsPlanTable.setEnabled(true);
				}else if (e.getSource() == TEP_OKButton){
					dispose();
				}
			}
		}
	}

	  class Kardiologikh_RoomsPlan extends JFrame{
			
	    	private JPanel MainPanel;
	    	private JTable RoomsPlanTable;
			private JLabel ButtonPanel;
			
			public Kardiologikh_RoomsPlan(){
				
				String[] columnNamesVisit = {"Δωμάτια","Κλίνη 1","Κλίνη 2","Κλίνη 3"};
				Object[][] dataOfVisit = {
					    {"Δωμάτιο 21"," "," "," "},{"Δωμάτιο 22"," "," "," "},{"Δωμάτιο 23"," "," "," "}
					    ,{"Δωμάτιο 24"," "," "," "},{"Δωμάτιο 25"," "," "," "},{"Δωμάτιο 26"," "," "," "},{"Δωμάτιο 27"," "," "," "},{"Δωμάτιο 28"," "," "," "}
					    ,{"Δωμάτιο 29"," "," "," "},{"Δωμάτιο 30"," "," "," "},{"Δωμάτιο 31"," "," "," "},{"Δωμάτιο 32"," "," "," "},{"Δωμάτιο 33"," "," "," "}
					    ,{"Δωμάτιο 34"," "," "," "},{"Δωμάτιο 35"," "," "," "},{"Δωμάτιο 36"," "," "," "},{"Δωμάτιο 37"," "," "," "},{"Δωμάτιο 38"," "," "," "}
					    ,{"Δωμάτιο 39"," "," "," "},{"Δωμάτιο 40"," "," "," "}};
				
				RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
				
				MainPanel=new JPanel(new GridLayout(2,1));
				ButtonPanel=new JLabel();
				
				JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
				
				Kardiologikh_epexergasiaButton=new JButton("Επεξεργασία");
				Kardiologikh_epexergasiaButton.setSize(150, 40);
				Kardiologikh_epexergasiaButton.setLocation(460, 80);
				Kardiologikh_epexergasiaButton.addActionListener(new KardiologikhButtonListener());
				ButtonPanel.add(Kardiologikh_epexergasiaButton);
				
				Kardiologikh_OKButton=new JButton("OK");
				Kardiologikh_OKButton.setSize(150, 40);
				Kardiologikh_OKButton.setLocation(10, 80);
				Kardiologikh_OKButton.addActionListener(new KardiologikhButtonListener());
				ButtonPanel.add(Kardiologikh_OKButton);
				
				Kardiologikh_OKButton.setOpaque(true);
				Kardiologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
				
				Kardiologikh_epexergasiaButton.setOpaque(true);
				Kardiologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
				this.setResizable(false);
				
				MainPanel.add(tableSP);
				MainPanel.add(ButtonPanel);
				
				this.setContentPane(MainPanel);
				this.setResizable(false);
				this.setSize(630,750);
				this.setVisible(true);
				this.setTitle("Κλίνες Καρδιολογική");
			}
			class KardiologikhButtonListener implements ActionListener {

				public void actionPerformed(ActionEvent e) {
				
					if (e.getSource() == Kardiologikh_epexergasiaButton){
						RoomsPlanTable.setEnabled(true);
					}else if (e.getSource() == Kardiologikh_OKButton){
						dispose();
					}
				}
			}
		}

    class Neurologikh_RoomsPlan extends JFrame{
		
    	private JPanel MainPanel;
    	private JTable RoomsPlanTable;
		private JLabel ButtonPanel;
		
		public Neurologikh_RoomsPlan(){
			
			String[] columnNamesVisit = {"Δωμάτια","Κλίνη 1","Κλίνη 2","Κλίνη 3"};
			Object[][] dataOfVisit = {
				    {"Δωμάτιο 41"," "," "," "},{"Δωμάτιο 42"," "," "," "},{"Δωμάτιο 43"," "," "," "}
				    ,{"Δωμάτιο 44"," "," "," "},{"Δωμάτιο 45"," "," "," "},{"Δωμάτιο 46"," "," "," "},{"Δωμάτιο 47"," "," "," "},{"Δωμάτιο 48"," "," "," "}
				    ,{"Δωμάτιο 49"," "," "," "},{"Δωμάτιο 50"," "," "," "},{"Δωμάτιο 51"," "," "," "},{"Δωμάτιο 52"," "," "," "},{"Δωμάτιο 53"," "," "," "}
				    ,{"Δωμάτιο 54"," "," "," "},{"Δωμάτιο 55"," "," "," "},{"Δωμάτιο 56"," "," "," "},{"Δωμάτιο 57"," "," "," "},{"Δωμάτιο 58"," "," "," "}
				    ,{"Δωμάτιο 59"," "," "," "},{"Δωμάτιο 60"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			
			JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();
			
			Neurologikh_epexergasiaButton=new JButton("Επεξεργασία");
			Neurologikh_epexergasiaButton.setSize(150, 40);
			Neurologikh_epexergasiaButton.setLocation(460, 80);
			Neurologikh_epexergasiaButton.addActionListener(new NeurologikhButtonListener());
			ButtonPanel.add(Neurologikh_epexergasiaButton);
			
			Neurologikh_OKButton=new JButton("OK");
			Neurologikh_OKButton.setSize(150, 40);
			Neurologikh_OKButton.setLocation(10, 80);
			Neurologikh_OKButton.addActionListener(new NeurologikhButtonListener());
			ButtonPanel.add(Neurologikh_OKButton);
			MainPanel.add(tableSP);
			
			Neurologikh_OKButton.setOpaque(true);
			Neurologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
			
			Neurologikh_epexergasiaButton.setOpaque(true);
			Neurologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
			this.setResizable(false);
			
			
			MainPanel.add(ButtonPanel);
			RoomsPlanTable.setEnabled(false);
			this.setContentPane(MainPanel);
			this.setResizable(false);
			this.setSize(630,750);
			this.setVisible(true);
			this.setTitle("Κλίνες Νευρολογική");
			
			}class NeurologikhButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == Neurologikh_epexergasiaButton){
					RoomsPlanTable.setEnabled(true);
				}else if (e.getSource() == Neurologikh_OKButton){
					dispose();
				}
			}
		
		}
		
     
   }
 
class Pathologikh_RoomsPlan extends JFrame{
		
    	private JPanel MainPanel;
    	private JTable RoomsPlanTable;
		private JLabel ButtonPanel;
		
		public Pathologikh_RoomsPlan(){
			
			String[] columnNamesVisit = {"Δωμάτια","Κλίνη 1","Κλίνη 2","Κλίνη 3"};
			Object[][] dataOfVisit = {
				    {"Δωμάτιο 61"," "," "," "},{"Δωμάτιο 62"," "," "," "},{"Δωμάτιο 63"," "," "," "}
				    ,{"Δωμάτιο 64"," "," "," "},{"Δωμάτιο 65"," "," "," "},{"Δωμάτιο 66"," "," "," "},{"Δωμάτιο 67"," "," "," "},{"Δωμάτιο 68"," "," "," "}
				    ,{"Δωμάτιο 69"," "," "," "},{"Δωμάτιο 70"," "," "," "},{"Δωμάτιο 71"," "," "," "},{"Δωμάτιο 72"," "," "," "},{"Δωμάτιο 73"," "," "," "}
				    ,{"Δωμάτιο 74"," "," "," "},{"Δωμάτιο 75"," "," "," "},{"Δωμάτιο 76"," "," "," "},{"Δωμάτιο 77"," "," "," "},{"Δωμάτιο 78"," "," "," "}
				    ,{"Δωμάτιο 79"," "," "," "},{"Δωμάτιο 80"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();
			
			JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			Pathologikh_epexergasiaButton=new JButton("Επεξεργασία");
			Pathologikh_epexergasiaButton.setSize(150, 40);
			Pathologikh_epexergasiaButton.setLocation(460, 80);
			Pathologikh_epexergasiaButton.addActionListener(new PathologikhButtonListener());
			ButtonPanel.add(Pathologikh_epexergasiaButton);
			
			Pathologikh_OKButton=new JButton("OK");
			Pathologikh_OKButton.setSize(150, 40);
			Pathologikh_OKButton.setLocation(10, 80);
			Pathologikh_OKButton.addActionListener(new PathologikhButtonListener());
			ButtonPanel.add(Pathologikh_OKButton);
			
			Pathologikh_OKButton.setOpaque(true);
			Pathologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
			
			
			Pathologikh_epexergasiaButton.setOpaque(true);
			Pathologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
			this.setResizable(false);
			
			MainPanel.add(tableSP);
			MainPanel.add(ButtonPanel);
			RoomsPlanTable.setEnabled(false);

			this.setContentPane(MainPanel);
			this.setResizable(false);
			this.setSize(630,750);
			this.setVisible(true);
			this.setTitle("Κλίνες Παθολογική");
		}
		class PathologikhButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == Pathologikh_epexergasiaButton){
				RoomsPlanTable.setEnabled(true);
			}else if (e.getSource() == Pathologikh_OKButton){
				dispose();
			}
		}
	  }
    }
    class epexergasiaButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == TEP_epexergasiaButton){
			
			}else if (e.getSource() == Kardiologikh_epexergasiaButton){
			
			}else if (e.getSource() == Pathologikh_epexergasiaButton){
				
			}else if (e.getSource() == Neurologikh_epexergasiaButton){
			
			}
		}
	}
	class ChoosePatientPanel extends JFrame{
		
		private JLabel PatientPanel;
		private JButton DataButton,VisitButton,SergeryButton,RefererrsButton,DishargeNoteButton;
		
		public ChoosePatientPanel(){
			
			DataButton=new JButton("Στοιχεία");
			VisitButton=new JButton("Επισκέψεις");
			SergeryButton=new JButton("Επεμβάσεις");
			RefererrsButton=new JButton("Παραπεμπτικά");
			DishargeNoteButton=new JButton("Εξητίριο");
			PatientPanel=new JLabel();
			
			
			DataButton.setSize(150, 40);
			VisitButton.setSize(150, 40);
			SergeryButton.setSize(150, 40);
			RefererrsButton.setSize(150, 40);
			DishargeNoteButton.setSize(150, 40);
			
			DataButton.setLocation(40,20);
			VisitButton.setLocation(40, 80);
			SergeryButton.setLocation(40, 140);
			RefererrsButton.setLocation(40, 200);
			DishargeNoteButton.setLocation(40,260);
			
			PatientPanel.add(DataButton);
			PatientPanel.add(VisitButton);
			PatientPanel.add(SergeryButton);
			PatientPanel.add(RefererrsButton);
			PatientPanel.add(DishargeNoteButton);
			
			
			
			this.setContentPane(PatientPanel);
			this.setBackground(Color.getHSBColor(120, 50, 250));
			this.setSize(250,400);
			this.setVisible(true);
			this.setTitle("Στοιχεία Ασθενή");
		}
	}
}
