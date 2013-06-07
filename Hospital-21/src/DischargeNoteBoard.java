import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class DischargeNoteBoard extends JFrame{

	private JButton OKButton, cancelButton;
	private JLabel DischargeBoard;
	//private DischargeNotePaint patientCodeLabel,nameLabel,amkaLabel,doctorLabel,diagnosisLabel,commentsLabel,dischargeNoteLabel;
	private JTextField nameTextField,amkaTextField,diagnosisTextField,commentsTextField,dischargeNoteTextField,patient_idTextField;
	
	private String name = "";
	private String amka = "";
	private String discharge_diagnosis = "";
	private String discharge_comments = "";
	private String discharge_day = "";
	private String patient_id;
	
	private Connection dbConnection = null ;
    private String     driverClassName = "com.mysql.jdbc.Driver" ;
    private String     url             = "jdbc:mysql://localhost/hospital";
    private  String     user   = "root" ;
    private String     passwd = "" ; 
	
	public DischargeNoteBoard(){
		
		ImageIcon DischargeNoteIcon = new ImageIcon("DischargeBoardPanel.gif");
		DischargeBoard=new JLabel(DischargeNoteIcon);
		
		nameTextField=new JTextField();
		amkaTextField=new JTextField();
		diagnosisTextField=new JTextField();
		commentsTextField=new JTextField();
		dischargeNoteTextField=new JTextField();
		patient_idTextField = new JTextField();		
		
		nameTextField.setLocation(75,100);
		amkaTextField.setLocation(220, 100);
		diagnosisTextField.setLocation(365, 100);
		commentsTextField.setLocation(515, 100);
		dischargeNoteTextField.setLocation(665, 100);
		patient_idTextField.setLocation(815,100);
		
		nameTextField.setSize(140,40);
		amkaTextField.setSize(140,40);
		diagnosisTextField.setSize(140,40);
		commentsTextField.setSize(140,40);
		dischargeNoteTextField.setSize(140,40);
		patient_idTextField.setSize(140,40);
		
		
		DischargeBoard.add(nameTextField);
		DischargeBoard.add(amkaTextField);
		DischargeBoard.add(diagnosisTextField);
		DischargeBoard.add(commentsTextField);
		DischargeBoard.add(dischargeNoteTextField);
		DischargeBoard.add(patient_idTextField);
		
		OKButton= new JButton("OK");
		DischargeBoard.add(OKButton);
		OKButton.setSize(150, 50);
		OKButton.setLocation(800, 200);
		
				
		cancelButton= new JButton("Ακύρωση");
		DischargeBoard.add(cancelButton);
		cancelButton.setSize(150, 50);
		cancelButton.setLocation(1000, 200);
		
		OKButton.setBackground(Color.getHSBColor(100, 50, 700));
		cancelButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		OKButton.setOpaque(true);
		cancelButton.setOpaque(true);
		
		
		OKButton.addActionListener(new ButtonListener());
		cancelButton.addActionListener(new ButtonListener());
		
		this.setContentPane(DischargeBoard);
		this.setResizable(false);
		this.setSize(1200,300);
		this.setVisible(true);
		this.setTitle("Εξιτήριο");
    }
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			
			if (e.getSource() == OKButton){
				name = nameTextField.getText();
				amka = amkaTextField.getText();
				discharge_diagnosis = diagnosisTextField.getText();
				discharge_day = dischargeNoteTextField.getText();
				discharge_comments = commentsTextField.getText();
				patient_id = patient_idTextField.getText();
				
				if(name.length()>0 && amka.length()>0 && patient_id.length()>0){
				try {
				    Class.forName(driverClassName);
				    dbConnection = DriverManager.getConnection (url,user,passwd);
				    
				    Statement stmt ; 
			        int       rowsUpdated ;
			        
			        stmt = dbConnection.createStatement () ;
			        
			        rowsUpdated = stmt.executeUpdate (
			                "UPDATE history "
			                +"SET discharge_diagnosis = '" +discharge_diagnosis 
			                +"', discharge_day = '" +discharge_day +"'"
			                +", discharge_comments = '" +discharge_comments +"'"
			                +"WHERE name = '" +name +"' AND amka = '" +amka + "'" +" AND patient_id ='" +patient_id +"'");
			        if(rowsUpdated==0){
			        	JOptionPane.showMessageDialog(null, "Ο ασθενής με αυτά τα στοιχεία δεν βρέθηκε!"); 
			        }
			        else{
			        JOptionPane.showMessageDialog(null, "Updated " + rowsUpdated + " row(s)."); 
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
					JOptionPane.showMessageDialog(null, "Τα πεδία Όνομα, ΑΜΚΑ και Κωδικός Ασθενή είναι υποχρεωτικά!");     		
				}
				
			}else if (e.getSource() == cancelButton){
				dispose();
			}
		}
	}
}
