import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
    
    class PatientInfo extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
     
		
		private JTable PatientInfoTable;
		private JButton SaveButton;
		private String patient_id = "";
		private String name = "";
		private String amka = "";
		private String birth = "";
		private String sex = "";
		private String insurance = "";
		private String phone = "";
		private String contact_person = "";
		private String blood_type = "";
		private String room = "";
		private String clinic = "";
		
		public PatientInfo(){
																	
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    //model.addColumn("Κωδικός Ασθενή");
			    model.addColumn("Όνομα");
			    model.addColumn("ΑΜΚΑ");
			    model.addColumn("Ημερ.Γεν.");
			    model.addColumn("Φύλο");
			    model.addColumn("Ασφάλιση");
			    model.addColumn("Τηλέφωνο");
			    model.addColumn("’τομο Επικοινωνίας");
			    model.addColumn("Ομάδα Αίματος");
			    model.addColumn("Δωμάτιο");
			    model.addColumn("Κλινική");
			     
			    
			    Object titles[] = new Object[]{"Όνομα","AMKA","Ημερ.Γεν.","Φύλο","Ασφάλιση","Τηλέφωνο","’τομο Επικοινωνίας","Ομάδα Αίματος","Δωμάτιο","Κλινική"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	patient_id = rs.getString("patient_id");
			        name = rs.getString("name");
			        amka = rs.getString("amka");
			        birth = rs.getString("birth");
			        sex = rs.getString("sex");
			        insurance = rs.getString("insurance");
			        phone = rs.getString("phone");
			        contact_person = rs.getString("contact_person");
			        blood_type = rs.getString("blood_type");
			        room = rs.getString("room");
			        clinic = rs.getString("clinic");
			        
			        model.addRow(new Object[]{name,amka,birth,sex,insurance,phone,contact_person,blood_type,room,clinic});					
					PatientInfoTable = new JTable(model);
					PatientInfoTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
									
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientInfoTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Στοιχεία Ασθενή");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientInfoTable.add(SaveButton);
			
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientInfoTable.getRowCount(); i++) {  
					   //patient_id = PatientInfoTable.getValueAt(i, 1).toString();
					   name = PatientInfoTable.getValueAt(i, 0).toString();
					   amka = PatientInfoTable.getValueAt(i, 1).toString();
					   birth = PatientInfoTable.getValueAt(i, 2).toString();
					   sex = PatientInfoTable.getValueAt(i, 3).toString();
					   insurance = PatientInfoTable.getValueAt(i, 4).toString();
					   phone = PatientInfoTable.getValueAt(i, 5).toString();
					   if(PatientInfoTable.getValueAt(i, 6) != null)
					      contact_person = PatientInfoTable.getValueAt(i, 6).toString();
					   if(PatientInfoTable.getValueAt(i, 7) != null)
					      blood_type = PatientInfoTable.getValueAt(i, 7).toString();
					   if(PatientInfoTable.getValueAt(i, 8) != null)
					      room = PatientInfoTable.getValueAt(i, 8).toString();
					   if(PatientInfoTable.getValueAt(i, 9) != null)
					      clinic = PatientInfoTable.getValueAt(i, 9).toString();
					   					   
					}
				
				if(name.length()>0 && amka.length()>0 && birth.length()>0 && sex.length()>0 && insurance.length()>0 &&phone.length()>0){
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET name = '" +name 
				                +"', amka = '" +amka +"'"
				                +", birth = '" +birth +"'"
				                +", insurance = '" +insurance +"'"
				                +", phone = '" +phone +"'"
				                +", birth = '" +birth +"'"
				                +", contact_person = '" +contact_person +"'"
				                +", blood_type = '" +blood_type +"'"
				                +", room = '" +room +"'"
				                +", clinic = '" +clinic +"'"
				                +"WHERE patient_id ='" +patient_id +"'");
				        if(rowsUpdated==0){
				        	JOptionPane.showMessageDialog(null, "Ο ασθενής με αυτά τα στοιχεία δεν βρέθηκε!"); 
				        }
				        else{
				        JOptionPane.showMessageDialog(null, "Updated " + rowsUpdated + " row(s)."); 
				        dispose();
				        }
					}
					catch (SQLException esql) {
					    esql.printStackTrace();
					}
					catch (Exception ex) {
					    ex.printStackTrace();
					}
					}
					else{
						JOptionPane.showMessageDialog(null, "Τα πεδία Όνομα, ΑΜΚΑ, Ημ.Γεν., Φύλο, Ασφάλιση και Τηλέφωνο είναι υποχρεωτικά!");     		
					}
				
			}
		}
		
    }
