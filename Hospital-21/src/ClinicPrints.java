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
		
		TClinicButton= new JButton("���");
		NClinicButton= new JButton("�����������");
		KClinicButton= new JButton ("������������");
		PClinicButton= new JButton ("����������");

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
		this.setTitle("��������");
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
				
				Pathologikh_RoomsButton=new JButton("�������");
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
				this.setTitle("����������");
			}
		}

            class Kardiologikh_Rooms extends JFrame {
			
			private JLabel Kardiologikh_Label;
			
			
			public Kardiologikh_Rooms(){
				ImageIcon KardiologikhIcon = new ImageIcon("Kardiologikh_Rooms.gif");
				Kardiologikh_Label=new JLabel(KardiologikhIcon);
				
				Kardiologikh_RoomsButton=new JButton("�������");
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
				this.setTitle("������������");
			}
		}

		class Neurologikh_Rooms extends JFrame {
			
			private JLabel Neurologikh_Label;
			
			
			public Neurologikh_Rooms(){
				ImageIcon NeurologikhIcon = new ImageIcon("Neurologikh_Rooms.gif");
				Neurologikh_Label=new JLabel(NeurologikhIcon);
				
				Neurologikh_RoomsButton=new JButton("�������");
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
				this.setTitle("�����������");
			}
		}

		class TEP_Rooms extends JFrame {
		
			private JLabel TEP_Label;
			
			
			public TEP_Rooms(){
				ImageIcon TEPIcon = new ImageIcon("TEP_Rooms.gif");
				TEP_Label=new JLabel(TEPIcon);
				
				
				
				TEP_RoomsButton=new JButton("�������");
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
				this.setTitle("���");
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
			
		    
			
			String[] columnNamesVisit = {"�������","����� 1","����� 2","����� 3"};
			Object[][] dataOfVisit = {
				     {"������� 1",roomList.get(0), roomList.get(1), roomList.get(2)},{"������� 2"," "," "," "},{"������� 3"," "," "," "}
				    ,{"������� 4"," "," "," "},{"������� 5"," "," "," "},{"������� 6"," "," "," "},{"������� 7"," "," "," "},{"������� 8"," "," "," "}
				    ,{"������� 9"," "," "," "},{"������� 10"," "," "," "},{"������� 11"," "," "," "},{"������� 12"," "," "," "},{"������� 13"," "," "," "}
				    ,{"������� 14"," "," "," "},{"������� 15"," "," "," "},{"������� 16"," "," "," "},{"������� 17"," "," "," "},{"������� 18"," "," "," "}
				    ,{"������� 19"," "," "," "},{"������� 20"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			RoomsPlanTable.setEnabled(false);
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();

	        JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			
			TEP_epexergasiaButton=new JButton("�����������");
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
			this.setTitle("������ ���");
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
				
				String[] columnNamesVisit = {"�������","����� 1","����� 2","����� 3"};
				Object[][] dataOfVisit = {
					    {"������� 21"," "," "," "},{"������� 22"," "," "," "},{"������� 23"," "," "," "}
					    ,{"������� 24"," "," "," "},{"������� 25"," "," "," "},{"������� 26"," "," "," "},{"������� 27"," "," "," "},{"������� 28"," "," "," "}
					    ,{"������� 29"," "," "," "},{"������� 30"," "," "," "},{"������� 31"," "," "," "},{"������� 32"," "," "," "},{"������� 33"," "," "," "}
					    ,{"������� 34"," "," "," "},{"������� 35"," "," "," "},{"������� 36"," "," "," "},{"������� 37"," "," "," "},{"������� 38"," "," "," "}
					    ,{"������� 39"," "," "," "},{"������� 40"," "," "," "}};
				
				RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
				
				MainPanel=new JPanel(new GridLayout(2,1));
				ButtonPanel=new JLabel();
				
				JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
				
				Kardiologikh_epexergasiaButton=new JButton("�����������");
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
				this.setTitle("������ ������������");
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
			
			String[] columnNamesVisit = {"�������","����� 1","����� 2","����� 3"};
			Object[][] dataOfVisit = {
				    {"������� 41"," "," "," "},{"������� 42"," "," "," "},{"������� 43"," "," "," "}
				    ,{"������� 44"," "," "," "},{"������� 45"," "," "," "},{"������� 46"," "," "," "},{"������� 47"," "," "," "},{"������� 48"," "," "," "}
				    ,{"������� 49"," "," "," "},{"������� 50"," "," "," "},{"������� 51"," "," "," "},{"������� 52"," "," "," "},{"������� 53"," "," "," "}
				    ,{"������� 54"," "," "," "},{"������� 55"," "," "," "},{"������� 56"," "," "," "},{"������� 57"," "," "," "},{"������� 58"," "," "," "}
				    ,{"������� 59"," "," "," "},{"������� 60"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			
			JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();
			
			Neurologikh_epexergasiaButton=new JButton("�����������");
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
			this.setTitle("������ �����������");
			
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
			
			String[] columnNamesVisit = {"�������","����� 1","����� 2","����� 3"};
			Object[][] dataOfVisit = {
				    {"������� 61"," "," "," "},{"������� 62"," "," "," "},{"������� 63"," "," "," "}
				    ,{"������� 64"," "," "," "},{"������� 65"," "," "," "},{"������� 66"," "," "," "},{"������� 67"," "," "," "},{"������� 68"," "," "," "}
				    ,{"������� 69"," "," "," "},{"������� 70"," "," "," "},{"������� 71"," "," "," "},{"������� 72"," "," "," "},{"������� 73"," "," "," "}
				    ,{"������� 74"," "," "," "},{"������� 75"," "," "," "},{"������� 76"," "," "," "},{"������� 77"," "," "," "},{"������� 78"," "," "," "}
				    ,{"������� 79"," "," "," "},{"������� 80"," "," "," "}};
			
			RoomsPlanTable = new JTable(dataOfVisit, columnNamesVisit);
			
			MainPanel=new JPanel(new GridLayout(2,1));
			ButtonPanel=new JLabel();
			
			JScrollPane tableSP = new JScrollPane(RoomsPlanTable);
			
			Pathologikh_epexergasiaButton=new JButton("�����������");
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
			this.setTitle("������ ����������");
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
			
			DataButton=new JButton("��������");
			VisitButton=new JButton("����������");
			SergeryButton=new JButton("����������");
			RefererrsButton=new JButton("������������");
			DishargeNoteButton=new JButton("��������");
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
			this.setTitle("�������� ������");
		}
	}
}
