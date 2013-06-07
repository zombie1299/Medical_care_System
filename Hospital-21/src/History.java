import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class History extends JFrame{

	private JLabel ImagePanel;
	private JButton TEPButton,KardiologikhButton,NeurologikhButton,PathologikhButton;
	private JButton TEP_epexergasiaButton,Neurologikh_epexergasiaButton,Kardiologikh_epexergasiaButton,Pathologikh_epexergasiaButton;
	private JButton TEP_OKButton,Neurologikh_OKButton,Kardiologikh_OKButton,Pathologikh_OKButton;
	
	static Connection dbConnection = null ;
    static String     driverClassName = "com.mysql.jdbc.Driver" ;
    static String     url             = "jdbc:mysql://localhost/hospital";
    static String     user   = "root" ;
    static String     passwd = "" ; 
		
	public History(){
		
		ImagePanel= new JLabel();
		ImagePanel.setBackground(Color.getHSBColor(100, 50, 600));
		ImagePanel.setOpaque(true);
		
		TEPButton= new JButton("ΤΕΠ");
		KardiologikhButton= new JButton("Καρδιολογική");
		NeurologikhButton= new JButton ("Νευρολογική");
		PathologikhButton= new JButton ("Παθολογική");

		TEPButton.setSize(150, 50);
		KardiologikhButton.setSize(150, 50);
		NeurologikhButton.setSize(150, 50);
		PathologikhButton.setSize(150, 50);
		
		TEPButton.setLocation(30, 20);
		KardiologikhButton.setLocation(250, 20);
		NeurologikhButton.setLocation(30, 150);
		PathologikhButton.setLocation(250, 150);
		
		TEPButton.setOpaque(true);
		KardiologikhButton.setOpaque(true);
		NeurologikhButton.setOpaque(true);
		PathologikhButton.setOpaque(true);
		
		TEPButton.setBackground(Color.getHSBColor(100, 50, 700));
		KardiologikhButton.setBackground(Color.getHSBColor(100, 50, 700));
		NeurologikhButton.setBackground(Color.getHSBColor(100, 50, 700));
		PathologikhButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		TEPButton.addActionListener( new ButtonListener());
		KardiologikhButton.addActionListener( new ButtonListener());
		NeurologikhButton.addActionListener( new ButtonListener());
		PathologikhButton.addActionListener( new ButtonListener());
		
		
		ImagePanel.add(TEPButton);
		ImagePanel.add(KardiologikhButton);
		ImagePanel.add(NeurologikhButton);
		ImagePanel.add(PathologikhButton);
		ImagePanel.setBackground(Color.getHSBColor(120, 50, 250));
		
		this.setContentPane(ImagePanel);
		this.setResizable(false);
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("Ιστορικό");
		
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
		
			if (e.getSource() == TEPButton){
				new TEP_History();
			}else if (e.getSource() == KardiologikhButton){
				new Kardiologikh_History();
			}else if (e.getSource() == NeurologikhButton){
				new Neurologikh_History();
			}else if (e.getSource() == PathologikhButton){
				new Pathologikh_History();
			}
			dispose();
		}
		
		class TEP_History extends JFrame{
			
			private JTable TepHistoryTable;
			
			public TEP_History(){
												
				try {
				    Class.forName(driverClassName);
				    Connection con = DriverManager.getConnection (url,user,passwd);
				    Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM history WHERE clinic = 'TEP' LIMIT 20";
				    ResultSet rs = stmt.executeQuery(sql);
				 				 
				    DefaultTableModel model = new DefaultTableModel(); 
				    
				    model.addColumn("Κωδικός Ασθενή");
				    model.addColumn("Όνομα");
				    model.addColumn("ΑΜΚΑ");
				    model.addColumn("Ημερ.Γεν.");
				    /*
				    model.addColumn("Φύλο");
				    model.addColumn("Ασφάλιση");
				    model.addColumn("Τηλέφωνο");
				    model.addColumn("’τομο Επικοινωνίας");
				    model.addColumn("Ομάδα Αίματος");
				    model.addColumn("Δωμάτιο");
				    model.addColumn("Κλινική");
				    model.addColumn("Διάγνωση Εισόδου");
				    model.addColumn("Διάγνωση Εξόδου");
				    model.addColumn("Σχόλια");
				    */
				    
				    Object titles[] = new Object[]{"Κωδικός Ασθενή","Όνομα","AMKA","Ημερ.Γεν."};
				    model.addRow(titles);
				    				    
				    while (rs.next()){
				    	String patient_id = rs.getString("patient_id");
				        String name = rs.getString("name");
				        String amka = rs.getString("amka");
				        String birth = rs.getString("birth");
				        /*
				        String sex = rs.getString("sex");
				        String insurance = rs.getString("insurance");
				        String phone = rs.getString("phone");
				        String contact_person = rs.getString("contact_person");
				        String blood_type = rs.getString("blood_type");
				        String room = rs.getString("room");
				        String clinic = rs.getString("clinic");
				        String entry_diagnosis = rs.getString("entry_diagnosis");
				        String exit_diagnosis = rs.getString("exit_diagnosis");
				        String comments = rs.getString("comments");
				        */
				        
				        model.addRow(new Object[]{patient_id,name,amka,birth});					
						TepHistoryTable = new JTable(model);
						TepHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						TepHistoryTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
					
				    }
				}
				catch (SQLException e) {
				    e.printStackTrace();
				}
				catch (Exception e) {
				    e.printStackTrace();
				}
												
				TEP_epexergasiaButton=new JButton("Επεξεργασία");
				TEP_epexergasiaButton.setSize(150, 40);
				TEP_epexergasiaButton.setLocation(300, 480);
				TEP_epexergasiaButton.addActionListener(new epexergasiaButtonListener());
				TepHistoryTable.add(TEP_epexergasiaButton);
				TEP_OKButton=new JButton("OK");
				TEP_OKButton.setSize(150, 40);
				TEP_OKButton.setLocation(500, 480);
				
				TEP_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
				TEP_epexergasiaButton.setOpaque(true);
				TEP_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
				TEP_OKButton.setOpaque(true);
				
				TEPButtonListener tbl = new TEPButtonListener();
				TEP_OKButton.addActionListener(tbl);
				TEP_OKButton.addMouseListener(new TEPmouseEvent());
				TepHistoryTable.add(TEP_OKButton);
				
				this.setContentPane(TepHistoryTable);
				this.setResizable(false);
				this.setSize(1270,570);
				this.setVisible(true);
				this.setTitle("Ιστορικό ΤΕΠ");
			}
			
			class TEPButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					if (e.getSource() == TEP_epexergasiaButton){
					    dispose();
					}
					else if (e.getSource() == TEP_OKButton){
						new HistoryPatientCard();
						dispose();
					}
				}
			}
          class TEPmouseEvent implements MouseListener {
				
				public void mousePressed(MouseEvent e) {
					
				}
				public void mouseReleased(MouseEvent e) {
					int[] selection = TepHistoryTable.getSelectedRows();
		           	
					for (int i = 0; i < selection.length; i++) {
						 String tmp = TepHistoryTable.getValueAt(selection[i], 0).toString();
						 
						 if(tmp!="Κωδικός Ασθενή"){
							 Search.selected_patient_id = Integer.parseInt(tmp);
						 }
					 }
				}
				public void mouseEntered(MouseEvent e) {}
	            public void mouseExited(MouseEvent e) {}
	            public void mouseClicked(MouseEvent e) {
	            	
	            }
	            
		   }
			
		}
		class Neurologikh_History extends JFrame{
			
			private JTable NeurologikhHistoryTable;
			
			public Neurologikh_History(){
				
				try {
				    Class.forName(driverClassName);
				    Connection con = DriverManager.getConnection (url,user,passwd);
				    Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM history WHERE clinic = 'NEUROLOGIKH' LIMIT 20";
				    ResultSet rs = stmt.executeQuery(sql);
				 				 
				    DefaultTableModel model = new DefaultTableModel(); 
				    
				    model.addColumn("Κωδικός Ασθενή");
				    model.addColumn("Όνομα");
				    model.addColumn("ΑΜΚΑ");
				    model.addColumn("Ημερ.Γεν.");
				    /*model.addColumn("Φύλο");
				    model.addColumn("Ασφάλιση");
				    model.addColumn("Τηλέφωνο");
				    model.addColumn("’τομο Επικοινωνίας");
				    model.addColumn("Ομάδα Αίματος");
				    model.addColumn("Δωμάτιο");
				    model.addColumn("Κλινική");
				    model.addColumn("Διάγνωση Εισόδου");
				    model.addColumn("Διάγνωση Εξόδου");
				    model.addColumn("Σχόλια");*/
				    model.addRow(new Object[]{"Κωδικός Ασθενή","Όνομα","ΑΜΚΑ","Ημ.Γενν."});
				    				    
				    while (rs.next()){
				    	
				    	String patient_id = rs.getString("patient_id");
				        String name = rs.getString("name");
				        String amka = rs.getString("amka");
				        String birth = rs.getString("birth");
				        /*
				        String sex = rs.getString("sex");
				        String insurance = rs.getString("insurance");
				        String phone = rs.getString("phone");
				        String contact_person = rs.getString("contact_person");
				        String blood_type = rs.getString("blood_type");
				        String room = rs.getString("room");
				        String clinic = rs.getString("clinic");
				        String entry_diagnosis = rs.getString("entry_diagnosis");
				        String exit_diagnosis = rs.getString("exit_diagnosis");
				        String comments = rs.getString("comments");*/
				        
				        model.addRow(new Object[]{patient_id,name,amka,birth});					
				        NeurologikhHistoryTable = new JTable(model);
				        NeurologikhHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    }
				}
				catch (SQLException e) {
				    e.printStackTrace();
				}
				catch (Exception e) {
				    e.printStackTrace();
				}
								
				Neurologikh_epexergasiaButton=new JButton("Επεξεργασία");
				Neurologikh_epexergasiaButton.setSize(150, 40);
				Neurologikh_epexergasiaButton.setLocation(300, 480);
				Neurologikh_epexergasiaButton.addActionListener(new epexergasiaButtonListener());
				NeurologikhHistoryTable.add(Neurologikh_epexergasiaButton);
				Neurologikh_OKButton=new JButton("OK");
				Neurologikh_OKButton.setSize(150, 40);
				Neurologikh_OKButton.setLocation(500, 480);
				
				Neurologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
				Neurologikh_epexergasiaButton.setOpaque(true);
				Neurologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
				Neurologikh_OKButton.setOpaque(true);
				
				NeurologikhButtonListener nbl = new NeurologikhButtonListener();
				Neurologikh_OKButton.addMouseListener(new NeurologikhmouseEvent());
				Neurologikh_OKButton.addActionListener(nbl);
				NeurologikhHistoryTable.add(Neurologikh_OKButton);
				
				this.setContentPane(NeurologikhHistoryTable);
				this.setResizable(false);
				this.setSize(1270,570);
				this.setVisible(true);
				this.setTitle("Ιστορικό Νευρολογική");
			}
			
			class NeurologikhButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					if (e.getSource() == Neurologikh_epexergasiaButton){
					    dispose();
					}
					else if (e.getSource() == Neurologikh_OKButton){
						new HistoryPatientCard();
						dispose();
					}
				}
			}
           class NeurologikhmouseEvent implements MouseListener {
				
				public void mousePressed(MouseEvent e) {
					
				}
				public void mouseReleased(MouseEvent e) {
					int[] selection = NeurologikhHistoryTable.getSelectedRows();
		           	
					for (int i = 0; i < selection.length; i++) {
						 String tmp = NeurologikhHistoryTable.getValueAt(selection[i], 0).toString();
						 
						 if(tmp!="Κωδικός Ασθενή"){
							 Search.selected_patient_id = Integer.parseInt(tmp);
						 }
					 }
				}
				public void mouseEntered(MouseEvent e) {}
	            public void mouseExited(MouseEvent e) {}
	            public void mouseClicked(MouseEvent e) {
	            	
	            }
	            
		   }
			
		}
		class Kardiologikh_History extends JFrame{
			
			private JTable KardiologikhHistoryTable;
			
			public Kardiologikh_History(){
		
				try {
				    Class.forName(driverClassName);
				    Connection con = DriverManager.getConnection (url,user,passwd);
				    Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM history WHERE clinic = 'KARDIOLOGIKH' LIMIT 20";
				    ResultSet rs = stmt.executeQuery(sql);
				 				 
				    DefaultTableModel model = new DefaultTableModel(); 
				    
				    model.addColumn("Κωδικός Ασθενή");
				    model.addColumn("Όνομα");
				    model.addColumn("ΑΜΚΑ");
				    model.addColumn("Ημερ.Γεν.");
				    /*
				    model.addColumn("Φύλο");
				    model.addColumn("Ασφάλιση");
				    model.addColumn("Τηλέφωνο");
				    model.addColumn("’τομο Επικοινωνίας");
				    model.addColumn("Ομάδα Αίματος");
				    model.addColumn("Δωμάτιο");
				    model.addColumn("Κλινική");
				    model.addColumn("Διάγνωση Εισόδου");
				    model.addColumn("Διάγνωση Εξόδου");
				    model.addColumn("Σχόλια");*/
				    model.addRow(new Object[]{"Κωδικός Ασθενή","Όνομα","ΑΜΚΑ","Ημερ.Γεν."});
				    				    
				    while (rs.next()){
				    	
				    	String patient_id = rs.getString("patient_id");
				        String name = rs.getString("name");
				        String amka = rs.getString("amka");
				        String birth = rs.getString("birth");
				        /*String sex = rs.getString("sex");
				        String insurance = rs.getString("insurance");
				        String phone = rs.getString("phone");
				        String contact_person = rs.getString("contact_person");
				        String blood_type = rs.getString("blood_type");
				        String room = rs.getString("room");
				        String clinic = rs.getString("clinic");
				        String entry_diagnosis = rs.getString("entry_diagnosis");
				        String exit_diagnosis = rs.getString("exit_diagnosis");
				        String comments = rs.getString("comments");*/
				        
				        model.addRow(new Object[]{patient_id,name,amka,birth});					
				        KardiologikhHistoryTable = new JTable(model);
				        KardiologikhHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    }
				}
				catch (SQLException e) {
				    e.printStackTrace();
				}
				catch (Exception e) {
				    e.printStackTrace();
				}
										
					Kardiologikh_epexergasiaButton=new JButton("Επεξεργασία");
					Kardiologikh_epexergasiaButton.setSize(150, 40);
					Kardiologikh_epexergasiaButton.setLocation(300, 480);
					Kardiologikh_epexergasiaButton.addActionListener(new epexergasiaButtonListener());
					KardiologikhHistoryTable.add(Kardiologikh_epexergasiaButton);
					Kardiologikh_OKButton=new JButton("OK");
					Kardiologikh_OKButton.setSize(150, 40);
					Kardiologikh_OKButton.setLocation(500, 480);
					
					Kardiologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
					Kardiologikh_epexergasiaButton.setOpaque(true);
					Kardiologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
					Kardiologikh_OKButton.setOpaque(true);
					
					KardiologikhButtonListener kbl = new KardiologikhButtonListener();
					Kardiologikh_OKButton.addActionListener(kbl);
					Kardiologikh_OKButton.addMouseListener(new KardiologikhmouseEvent());
					KardiologikhHistoryTable.add(Kardiologikh_OKButton);
					
					this.setContentPane(KardiologikhHistoryTable);
					this.setResizable(false);
					this.setSize(1270,570);
					this.setVisible(true);
					this.setTitle("Ιστορικό Καρδιολογική");
				}
			class KardiologikhButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					if (e.getSource() == Kardiologikh_epexergasiaButton){
					    dispose();
					}
					else if (e.getSource() == Kardiologikh_OKButton){
						new HistoryPatientCard();
						dispose();
					}
				}
			}	
           class KardiologikhmouseEvent implements MouseListener {
				
				public void mousePressed(MouseEvent e) {
					
				}
				public void mouseReleased(MouseEvent e) {
					int[] selection = KardiologikhHistoryTable.getSelectedRows();
		           	
					for (int i = 0; i < selection.length; i++) {
						 String tmp = KardiologikhHistoryTable.getValueAt(selection[i], 0).toString();
						 
						 if(tmp!="Κωδικός Ασθενή"){
							 Search.selected_patient_id = Integer.parseInt(tmp);
						 }
					 }
				}
				public void mouseEntered(MouseEvent e) {}
	            public void mouseExited(MouseEvent e) {}
	            public void mouseClicked(MouseEvent e) {
	            	
	            }
	            
		   }
			
			}
		}
		class Pathologikh_History extends JFrame{
			
			private JTable PathogikhHistoryTable;
			
			public Pathologikh_History(){
				
				try {
				    Class.forName(driverClassName);
				    Connection con = DriverManager.getConnection (url,user,passwd);
				    Statement stmt = con.createStatement();
				    String sql = "SELECT * FROM history WHERE clinic = 'PATHOLOGIKH' LIMIT 20";
				    ResultSet rs = stmt.executeQuery(sql);
				 				 
				    DefaultTableModel model = new DefaultTableModel(); 
				    
				    model.addColumn("Κωδικός Ασθενή");
				    model.addColumn("Όνομα");
				    model.addColumn("ΑΜΚΑ");
				    model.addColumn("Ημερ.Γεν.");
				    /*model.addColumn("Φύλο");
				    model.addColumn("Ασφάλιση");
				    model.addColumn("Τηλέφωνο");
				    model.addColumn("’τομο Επικοινωνίας");
				    model.addColumn("Ομάδα Αίματος");
				    model.addColumn("Δωμάτιο");
				    model.addColumn("Κλινική");
				    model.addColumn("Διάγνωση Εισόδου");
				    model.addColumn("Διάγνωση Εξόδου");
				    model.addColumn("Σχόλια");*/
				    model.addRow(new Object[]{"Κωδικός Ασθενή","Όνομα","ΑΜΚΑ","Ημερ.Γεν."});
				    				    
				    while (rs.next()){
				    	
				    	String patient_id = rs.getString("patient_id");
				        String name = rs.getString("name");
				        String amka = rs.getString("amka");
				        String birth = rs.getString("birth");
				        /*
				        String sex = rs.getString("sex");
				        String insurance = rs.getString("insurance");
				        String phone = rs.getString("phone");
				        String contact_person = rs.getString("contact_person");
				        String blood_type = rs.getString("blood_type");
				        String room = rs.getString("room");
				        String clinic = rs.getString("clinic");
				        String entry_diagnosis = rs.getString("entry_diagnosis");
				        String exit_diagnosis = rs.getString("exit_diagnosis");
				        String comments = rs.getString("comments");*/
				        
				        model.addRow(new Object[]{patient_id,name,amka,birth});					
				        PathogikhHistoryTable = new JTable(model);
				        PathogikhHistoryTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    }
				}
				catch (SQLException e) {
				    e.printStackTrace();
				}
				catch (Exception e) {
				    e.printStackTrace();
				}
												
						Pathologikh_epexergasiaButton=new JButton("Επεξεργασία");
						Pathologikh_epexergasiaButton.setSize(150, 40);
						Pathologikh_epexergasiaButton.setLocation(300, 480);
						Pathologikh_epexergasiaButton.addActionListener(new epexergasiaButtonListener());
						PathogikhHistoryTable.add(Pathologikh_epexergasiaButton);
						Pathologikh_OKButton=new JButton("OK");
						Pathologikh_OKButton.setSize(150, 40);
						Pathologikh_OKButton.setLocation(500, 480);
						
						Pathologikh_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
						Pathologikh_epexergasiaButton.setOpaque(true);
						Pathologikh_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
						Pathologikh_OKButton.setOpaque(true);
						
						PathologikhButtonListener pbl = new PathologikhButtonListener();
						Pathologikh_OKButton.addMouseListener(new PathologikhmouseEvent());
						Pathologikh_OKButton.addActionListener(pbl);
						PathogikhHistoryTable.add(Pathologikh_OKButton);
						
						this.setContentPane(PathogikhHistoryTable);
						this.setResizable(false);
						this.setSize(1270,570);
						this.setVisible(true);
						this.setTitle("Ιστορικό Παθολογική");
					}
			class PathologikhButtonListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					
					if (e.getSource() == Pathologikh_epexergasiaButton){
					    dispose();
					}
					else if (e.getSource() == Pathologikh_OKButton){
						new HistoryPatientCard();
						dispose();
					}
				}
			}
			class PathologikhmouseEvent implements MouseListener {
				
				public void mousePressed(MouseEvent e) {
					
				}
				public void mouseReleased(MouseEvent e) {
					int[] selection = PathogikhHistoryTable.getSelectedRows();
		           	
					for (int i = 0; i < selection.length; i++) {
						 String tmp = PathogikhHistoryTable.getValueAt(selection[i], 0).toString();
						 
						 if(tmp!="Κωδικός Ασθενή"){
							 Search.selected_patient_id = Integer.parseInt(tmp);
						 }
					 }
				}
				public void mouseEntered(MouseEvent e) {}
	            public void mouseExited(MouseEvent e) {}
	            public void mouseClicked(MouseEvent e) {
	            	
	            }
	            
		   }
				
		}
		class epexergasiaButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == TEP_epexergasiaButton){
				
				}else if (e.getSource() == Kardiologikh_epexergasiaButton){
				
				}else if (e.getSource() == Pathologikh_epexergasiaButton){
					
				}else if (e.getSource() == Neurologikh_epexergasiaButton){
				
				}else if (e.getSource() == TEP_OKButton){
					
				}else if (e.getSource() == Kardiologikh_OKButton){
						
				}else if (e.getSource() == Neurologikh_OKButton){
					
				}else if (e.getSource() ==  Pathologikh_OKButton){
					
				}
			}
	}
						
}
