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
    
    class PatientSurgery extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
        
        private String surgery;
        private String doctors; 
        private String nurses;
        private String machines;
        private String surgery_success;  
        private String surgery_day;
        private String surgery_comments;
		
		private JTable PatientSurgeryTable;
		private JButton SaveButton;
		
		public PatientSurgery(){
											
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    model.addColumn("Χειρουργείο");
			    model.addColumn("Γιατροί");
			    model.addColumn("Νοσηλευτές");
			    model.addColumn("Μηχανήματα");
			    model.addColumn("Επιτυχία");
			    model.addColumn("Ημερομηνία");
			    model.addColumn("Σχόλια");
			    			     
			    Object titles[] = new Object[]{"Χειρουργείο","Γιατροί","Νοσηλευτές","Μηχανήματα.","Επιτυχία","Ημερομηνία","Σχόλια"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	surgery = rs.getString("surgery");
			        doctors = rs.getString("doctors");
			        nurses = rs.getString("nurses");
			        machines = rs.getString("machines");
			        surgery_success = rs.getString("surgery_success");
			        surgery_day = rs.getString("surgery_day");
			        surgery_comments = rs.getString("surgery_comments");
			        			        
			        model.addRow(new Object[]{surgery,doctors,nurses,machines,surgery_success,surgery_day,surgery_comments});					
			        PatientSurgeryTable = new JTable(model);
			        				
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientSurgeryTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Χειρουργείο");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientSurgeryTable.add(SaveButton);
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientSurgeryTable.getRowCount(); i++) {  
					   
					   if(PatientSurgeryTable.getValueAt(i, 0) != null)
					      surgery = PatientSurgeryTable.getValueAt(i, 0).toString();
					   if(PatientSurgeryTable.getValueAt(i, 1) != null)
					      doctors = PatientSurgeryTable.getValueAt(i, 1).toString();
					   if(PatientSurgeryTable.getValueAt(i, 2) != null)
						   nurses = PatientSurgeryTable.getValueAt(i, 2).toString();
					   if(PatientSurgeryTable.getValueAt(i, 3) != null)
						   machines = PatientSurgeryTable.getValueAt(i, 3).toString();
					   if(PatientSurgeryTable.getValueAt(i, 4) != null)
						   surgery_success = PatientSurgeryTable.getValueAt(i, 4).toString();
					   if(PatientSurgeryTable.getValueAt(i, 5) != null)
						   surgery_day = PatientSurgeryTable.getValueAt(i, 5).toString();
					   if(PatientSurgeryTable.getValueAt(i, 6) != null)
						   surgery_comments = PatientSurgeryTable.getValueAt(i, 6).toString();
					}
				
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET surgery = '" +surgery 
				                +"', doctors = '" +doctors +"'"
				                +", nurses = '" +nurses +"'"
				                +", machines = '" +machines +"'"
				                +", surgery_success = '" +surgery_success +"'"
				                +", surgery_day = '" +surgery_day +"'"
				                +", surgery_comments = '" +surgery_comments +"'"
				                +"WHERE patient_id ='" +Search.selected_patient_id +"'");
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
			}
		
    }

