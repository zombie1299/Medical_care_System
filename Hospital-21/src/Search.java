import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.TreeSelectionModel;

public class Search extends JFrame{
	
	private JLabel searchPanel;
	private JLabel nameLabel;
	private JTextField nameSearchTextField;
	private JLabel amkaLabel;
	private JTextField amkaSearchTextField;
	private JButton okButton;
	
	static Connection dbConnection = null ;
    static String     driverClassName = "com.mysql.jdbc.Driver" ;
    static String     url             = "jdbc:mysql://localhost/hospital";
    static String     user   = "root" ;
    static String     passwd = "" ; 
    static String     name_search_key = "";
    static String     amka_search_key = "";
    static String     sql;
    public static int     selected_patient_id;
	
	public Search(){
		
		searchPanel=new JLabel();
		nameLabel = new JLabel("Όνομα");
		nameSearchTextField= new JTextField();
		amkaLabel = new JLabel("AMKA");
		amkaSearchTextField= new JTextField();
		okButton=new JButton("OK");
		
		nameLabel.setLocation(20,30);
		nameLabel.setSize(150,40);
		amkaLabel.setLocation(20,80);
		amkaLabel.setSize(150,40);
		nameSearchTextField.setLocation(120, 30);
		nameSearchTextField.setSize(150,40);
		amkaSearchTextField.setLocation(120, 80);
		amkaSearchTextField.setSize(150,40);
		okButton.setLocation(60, 150);
		okButton.setSize(150,40);
		okButton.setBackground(Color.getHSBColor(100, 50, 700));
		okButton.setOpaque(true);
		searchButtonListener search = new searchButtonListener();
		okButton.addActionListener(search);

		searchPanel.setBackground(Color.getHSBColor(120, 50, 250));

		searchPanel.add(nameLabel);
		searchPanel.add(nameSearchTextField);
		searchPanel.add(amkaLabel);
		searchPanel.add(amkaSearchTextField);
		searchPanel.add(okButton);
		this.setContentPane(searchPanel);
		this.setSize(300,250);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("ΑΝΑΖΗΤΗΣΗ");
	}
	
	class searchButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			name_search_key = nameSearchTextField.getText();
			amka_search_key = amkaSearchTextField.getText();
			if(name_search_key.length()>0 || amka_search_key.length()>0){
			   new Search_Results();
			   dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "Please fill in at least one of the fields!");
			}
		}
   }
	
	public class Search_Results extends JFrame{

		private JButton SEARCH_epexergasiaButton;
		private JButton SEARCH_OKButton;
		private JTable SearchTable;
					
		public Search_Results(){
			try {
			    Class.forName(driverClassName);
			    Connection con = DriverManager.getConnection (url,user,passwd);
			    Statement stmt = con.createStatement();
			    if(name_search_key.length()>0 && amka_search_key.length()==0)
			       sql = "SELECT * FROM history WHERE name = '" +name_search_key + "'";
			    else if(name_search_key.length()==0 && amka_search_key.length()>0)
			       sql = "SELECT * FROM history WHERE amka = '" +amka_search_key + "'";
			    else if(name_search_key.length()>0 && amka_search_key.length()>0)
			       sql = "SELECT * FROM history WHERE name = '" +name_search_key +"' AND amka = '" +amka_search_key + "'";
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
					SearchTable = new JTable(model);
					SearchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					SearchTable.addMouseListener(new mouseEvent());
					
			    }
			}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			catch (Exception e) {
			    e.printStackTrace();
			}
											
			SEARCH_epexergasiaButton=new JButton("Επεξεργασία");
			SEARCH_epexergasiaButton.setSize(150, 40);
			SEARCH_epexergasiaButton.setLocation(300, 480);
			
			
			SEARCH_epexergasiaButton.addActionListener(new ButtonListener());
			SearchTable.add(SEARCH_epexergasiaButton);
			SEARCH_OKButton=new JButton("OK");
			SEARCH_OKButton.setSize(150, 40);
			SEARCH_OKButton.setLocation(500, 480);
			
			SEARCH_OKButton.addActionListener(new ButtonListener());
			SearchTable.add(SEARCH_OKButton);
			
			SEARCH_epexergasiaButton.setBackground(Color.getHSBColor(100, 50, 700));
			SEARCH_epexergasiaButton.setOpaque(true);
			SEARCH_OKButton.setBackground(Color.getHSBColor(100, 50, 700));
			SEARCH_OKButton.setOpaque(true);
			
			
			this.setContentPane(SearchTable);
			this.setResizable(false);
			this.setSize(1270,570);
			this.setVisible(true);
			this.setTitle("Αποτελέσματα Αναζήτησης");
		}
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == SEARCH_epexergasiaButton){
				
				}
				else if (e.getSource() == SEARCH_OKButton){
					new HistoryPatientCard();
				    dispose();
				}
			}
	   }
		class mouseEvent implements MouseListener {
			
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				int[] selection = SearchTable.getSelectedRows();
	           	
				for (int i = 0; i < selection.length; i++) {
					 String tmp = SearchTable.getValueAt(selection[i], 0).toString();
					 
					 if(tmp!="Κωδικός Ασθενή"){
						 selected_patient_id = Integer.parseInt(tmp);
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
