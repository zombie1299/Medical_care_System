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
    
    class PatientVisit extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
        
        private String entry_diagnosis;
        private String exit_diagnosis; 
        private String comments;
        private String visit_day;
        private String visit_doctor; 
		
		private JTable PatientVisitTable;
		private JButton SaveButton;
		
		public PatientVisit(){
											
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    model.addColumn("Διάγνωση Εισόδου");
			    model.addColumn("Διάγνωση Εξόδου");
			    model.addColumn("Σχόλια");
			    model.addColumn("Ημερομηνία");
			    model.addColumn("Γιατρός");
			    			     
			    Object titles[] = new Object[]{"Διάγνωση Εισόδου","Διάγνωση Εξόδου","Σχόλια","Ημερομηνία.","Γιατρός"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	entry_diagnosis = rs.getString("entry_diagnosis");
			        exit_diagnosis = rs.getString("exit_diagnosis");
			        comments = rs.getString("comments");
			        visit_day = rs.getString("visit_day");
			        visit_doctor = rs.getString("visit_doctor");
			        			        
			        model.addRow(new Object[]{entry_diagnosis,exit_diagnosis,comments,visit_day,visit_doctor});					
					PatientVisitTable = new JTable(model);
					PatientVisitTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
				
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientVisitTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Επίσκεψη");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientVisitTable.add(SaveButton);
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientVisitTable.getRowCount(); i++) {  
					   
					   if(PatientVisitTable.getValueAt(i, 0) != null)
					      entry_diagnosis = PatientVisitTable.getValueAt(i, 0).toString();
					   if(PatientVisitTable.getValueAt(i, 1) != null)
					      exit_diagnosis = PatientVisitTable.getValueAt(i, 1).toString();
					   if(PatientVisitTable.getValueAt(i, 2) != null)
						      comments = PatientVisitTable.getValueAt(i, 2).toString();
					   if(PatientVisitTable.getValueAt(i, 3) != null)
						      visit_day = PatientVisitTable.getValueAt(i, 3).toString();
					   if(PatientVisitTable.getValueAt(i, 4) != null)
						      visit_doctor = PatientVisitTable.getValueAt(i, 4).toString();
					}
				
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET entry_diagnosis = '" +entry_diagnosis 
				                +"', exit_diagnosis = '" +exit_diagnosis +"'"
				                +", comments = '" +comments +"'"
				                +", visit_day = '" +visit_day +"'"
				                +", visit_doctor = '" +visit_doctor +"'"
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
