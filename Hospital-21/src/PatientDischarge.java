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
    
    class PatientDischarge extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
        
        private String discharge_day;
        private String discharge_diagnosis;
        private String discharge_comments;     
		
		private JTable PatientDischargeTable;
		private JButton SaveButton;
		
		public PatientDischarge(){
											
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    model.addColumn("Ημερομηνία");
			    model.addColumn("Διάγνωση");
			    model.addColumn("Σχόλια");
			    			    			     
			    Object titles[] = new Object[]{"Ημερομηνία","Διάγνωση","Σχόλια"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	discharge_day = rs.getString("discharge_day");
			        discharge_diagnosis = rs.getString("discharge_diagnosis");
			        discharge_comments = rs.getString("discharge_comments");
			        			        			        
			        model.addRow(new Object[]{discharge_day,discharge_diagnosis,discharge_comments});					
			        PatientDischargeTable = new JTable(model);
				
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientDischargeTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Εξιτήριο");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientDischargeTable.add(SaveButton);
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientDischargeTable.getRowCount(); i++) {  
					   
					   if(PatientDischargeTable.getValueAt(i, 0) != null)
					      discharge_day = PatientDischargeTable.getValueAt(i, 0).toString();
					   if(PatientDischargeTable.getValueAt(i, 1) != null)
					      discharge_diagnosis = PatientDischargeTable.getValueAt(i, 1).toString();
					   if(PatientDischargeTable.getValueAt(i, 2) != null)
					      discharge_comments = PatientDischargeTable.getValueAt(i, 2).toString();
					   					   					   
					}
				
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET discharge_day = '" +discharge_day 
				                +"', discharge_diagnosis = '" +discharge_diagnosis +"'"
				                +", discharge_comments = '" +discharge_comments +"'"
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

