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
    
    class PatientReferral extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
        
        private String referral;
        private String referral_day;    
		
		private JTable PatientReferralTable;
		private JButton SaveButton;
		
		public PatientReferral(){
											
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    model.addColumn("Εξετάσεις");
			    model.addColumn("Ημερομηνία");
			    			    			     
			    Object titles[] = new Object[]{"Εξετάσεις","Ημερομηνία"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	referral = rs.getString("referral");
			        referral_day = rs.getString("referral_day");
			        			        			        
			        model.addRow(new Object[]{referral,referral_day});					
			        PatientReferralTable = new JTable(model);
				
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientReferralTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Παραπεμπτικά");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientReferralTable.add(SaveButton);
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientReferralTable.getRowCount(); i++) {  
					   
					   if(PatientReferralTable.getValueAt(i, 0) != null)
					      referral = PatientReferralTable.getValueAt(i, 0).toString();
					   if(PatientReferralTable.getValueAt(i, 1) != null)
					      referral_day = PatientReferralTable.getValueAt(i, 1).toString();
					   
					}
				
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET referral = '" +referral 
				                +"', referral_day = '" +referral_day +"'"				                
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

