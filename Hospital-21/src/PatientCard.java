import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientCard extends JFrame{
	
	private JLabel BoardLabel;
	private JTextField NameTextField,amkaTextField,BirthDateTextField,genderTextField,insuranceTextField,
	phoneTextField,contactPersonTextField,bloodTypeTextField,ClinicTextField,RoomTextField;
	private JButton OKButton,CancelButton;
	
	private String name = "";
	private String amka = "";
	private String birth = "";
	private String sex = "";
	private String insurance = "";
	private String phone = "";
	private String contact_person = "";
	private String blood_type = "";
	private String clinic = "";
	private String room = "";
	
	static private Connection dbConnection = null ;
    static private String     driverClassName = "com.mysql.jdbc.Driver" ;
    static private String     url             = "jdbc:mysql://localhost/hospital";
    static private  String     user   = "root" ;
    static private String     passwd = "" ; 
	
	public PatientCard(){
		
		ImageIcon PatientCardIcon=new ImageIcon("PatientCardBoard.gif");
		BoardLabel=new JLabel(PatientCardIcon);
		OKButton=new JButton("OK");
		CancelButton=new JButton("Ακύρωση");
		
		NameTextField=new JTextField();
		amkaTextField=new JTextField();
		BirthDateTextField=new JTextField();
		genderTextField=new JTextField();
		insuranceTextField=new JTextField();
		phoneTextField=new JTextField();
		contactPersonTextField=new JTextField();
		bloodTypeTextField=new JTextField();
		ClinicTextField=new JTextField();
		RoomTextField=new JTextField();
		
		NameTextField.setLocation(-100,45);
		amkaTextField.setLocation(50,45);
		BirthDateTextField.setLocation(200,45);
		genderTextField.setLocation(350,45);
		insuranceTextField.setLocation(500,45);
		phoneTextField.setLocation(645,45);
		contactPersonTextField.setLocation(795,45);
		bloodTypeTextField.setLocation(945,45);
		ClinicTextField.setLocation(1090,45);
		RoomTextField.setLocation(1240,45);
		OKButton.setLocation(1090,100);
		CancelButton.setLocation(1240,100);
		
		NameTextField.setSize(140,40);
		amkaTextField.setSize(140,40);
		BirthDateTextField.setSize(140,40);
		genderTextField.setSize(140,40);
		insuranceTextField.setSize(140,40);
		phoneTextField.setSize(140,40);
		contactPersonTextField.setSize(140,40);
		bloodTypeTextField.setSize(140,40);
		RoomTextField.setSize(140,40);
		ClinicTextField.setSize(140,40);
		
		OKButton.setSize(140,40);
		CancelButton.setSize(140,40);
		
		OKButton.setBackground(Color.getHSBColor(100, 50, 700));
		CancelButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		OKButton.setOpaque(true);
		CancelButton.setOpaque(true);
		
		BoardLabel.add(NameTextField);
		BoardLabel.add(amkaTextField);
		BoardLabel.add(BirthDateTextField);
		BoardLabel.add(genderTextField);
		BoardLabel.add(insuranceTextField);
		BoardLabel.add(phoneTextField);
		BoardLabel.add(contactPersonTextField);
		BoardLabel.add(bloodTypeTextField);
		BoardLabel.add(ClinicTextField);
		BoardLabel.add(RoomTextField);
		BoardLabel.add(OKButton);
		BoardLabel.add(CancelButton);
		
		OKButton.addActionListener(new ButtonListener());
		CancelButton.addActionListener(new ButtonListener());
		
		this.setContentPane(BoardLabel);
		this.setResizable(false);
		this.setSize(1550,200);
		this.setVisible(true);
		this.setTitle("Κάρτα Ασθενή");
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			
			if (e.getSource() == OKButton){
				
				name = NameTextField.getText();
				amka = amkaTextField.getText();
				birth = BirthDateTextField.getText();
				sex = genderTextField.getText();
				insurance = insuranceTextField.getText();
				phone = phoneTextField.getText();
				contact_person = contactPersonTextField.getText();
				blood_type = bloodTypeTextField.getText();  
				clinic = ClinicTextField.getText();
				room = RoomTextField.getText();
				
				try {
				    Class.forName(driverClassName);
				    dbConnection = DriverManager.getConnection (url,user,passwd);
				    
				    PreparedStatement pstmt ; 
			        int       rowsUpdated ;
			        
			        pstmt = dbConnection.prepareStatement (
			                  "INSERT INTO history ( name, amka, birth, sex, insurance, phone, contact_person, blood_type, room, clinic) " +
			                  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)") ;
			        
			        if(name.length()>0 && amka.length()>0 && birth.length()>0 && sex.length()>0 &&insurance.length()>0 && phone.length()>0){		        
			        pstmt.setString (1, name) ;
			        pstmt.setString (2, amka) ;
			        pstmt.setString (3, birth) ;
			        pstmt.setString (4, sex) ;
			        pstmt.setString (5, insurance) ;
			        pstmt.setString (6, phone) ;
			        pstmt.setString (7, contact_person);
			        pstmt.setString (8, blood_type) ;
			        pstmt.setString (9, room) ;
			        pstmt.setString (10, clinic);
			        
			        rowsUpdated = pstmt.executeUpdate () ;
			        JOptionPane.showMessageDialog(null, "Inserted " + rowsUpdated + " row(s).");
			        }
			        else
			        	JOptionPane.showMessageDialog(null, "Τα πεδία Όνομα, ΑΜΚΑ, Ημ.Γεν. Φύλο, Ασφάλιση, Τηλέφωνο είναι υποχρεωτικά!");
				   
				    			    				    
				}
				catch (SQLException esql) {
				    esql.printStackTrace();
				}
				catch (Exception ex) {
				    ex.printStackTrace();
				}
				
				dispose();
			}else if (e.getSource() == CancelButton){
				dispose();
			}
		}
	}
}
