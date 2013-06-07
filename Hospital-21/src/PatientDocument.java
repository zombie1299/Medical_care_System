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
    
    class PatientDocument extends JFrame{
    	
    	static Connection dbConnection = null ;
        static String     driverClassName = "com.mysql.jdbc.Driver" ;
        static String     url             = "jdbc:mysql://localhost/hospital";
        static String     user   = "root" ;
        static String     passwd = "" ; 
        
        private String document_day;
        private String document_comments; 
     
		
		private JTable PatientDocumentTable;
		private JButton SaveButton;
		
		public PatientDocument(){
											
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    String sql = "SELECT * FROM history WHERE patient_id = '" +Search.selected_patient_id +"'";
			    ResultSet rs = stmt.executeQuery(sql);
			 				 
			    DefaultTableModel model = new DefaultTableModel(); 
			    
			    model.addColumn("Ημερομηνία");
			    model.addColumn("Σχόλια");
			    			    			     
			    Object titles[] = new Object[]{"Ημερομηνία","Σχόλια"};
			    model.addRow(titles);
			    				    
			    while (rs.next()){
			    	String document_day = rs.getString("document_day");
			        String document_comments = rs.getString("document_comments");
			        			        			        			        
			        model.addRow(new Object[]{document_day,document_comments});					
			        PatientDocumentTable = new JTable(model);
				
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}		
			
			this.setContentPane(PatientDocumentTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Παραστατικά");
			
			SaveButton = new JButton("Αποθήκευση Αλλαγών");
			SaveButton.setSize(180, 40);
			SaveButton.setLocation(20, 480);
			SaveButton.setBackground(Color.getHSBColor(100, 50, 700));
			SaveButton.setOpaque(true);
			SaveButton.addActionListener(new SaveButtonListener());
			PatientDocumentTable.add(SaveButton);
			
		}
		
		class SaveButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				for (int i = 0; i < PatientDocumentTable.getRowCount(); i++) {  
					   
					   if(PatientDocumentTable.getValueAt(i, 0) != null)
					      document_day = PatientDocumentTable.getValueAt(i, 0).toString();
					   if(PatientDocumentTable.getValueAt(i, 1) != null)
					      document_comments = PatientDocumentTable.getValueAt(i, 1).toString();					   					   					   
					}
				
					try {
					    Class.forName(driverClassName);
					    dbConnection = DriverManager.getConnection (url,user,passwd);
					    
					    Statement stmt ; 
				        int       rowsUpdated ;
				        
				        stmt = dbConnection.createStatement () ;
				        
				        rowsUpdated = stmt.executeUpdate (
				                "UPDATE history "
				                +"SET document_day = '" +document_day 
				                +"', document_comments = '" +document_comments +"'"
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

