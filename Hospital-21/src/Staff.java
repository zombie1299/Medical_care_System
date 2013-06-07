import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;


public class Staff extends JFrame{
	
	private JPanel mainPanel = new JPanel();
	
	private JLabel doctorLabel = new JLabel("ΓΙΑΤΡΟΙ");
	private JLabel nurseLabel = new JLabel("ΝΟΣΗΛΕΥΤΕΣ");
	
	private NurseTablePanel nursePanel ;
	private	DoctorTablePanel doctorPanel ;
	private Hospital myHospital;
    
	public Staff(Hospital myHospital){
		
		ArrayList doctorList = myHospital.getDoctors();
		ArrayList nurseList = myHospital.getNurses();
		
		
		this.myHospital = myHospital;
		

		doctorLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		nurseLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		
		doctorPanel = new DoctorTablePanel(doctorList);
		//doctorPanel.setEnabled(true);
		
		nursePanel = new NurseTablePanel(nurseList);
		
		mainPanel.add(doctorLabel);
		mainPanel.add(doctorPanel);
		mainPanel.add(nurseLabel);
		mainPanel.add(nursePanel);
		
	 	

		Dimension dim = new Dimension(1000,580);
		mainPanel.setPreferredSize(dim);
	
		
		this.setResizable(false);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("Προσωπικό Νοσοκομείου");
		this.setContentPane(mainPanel);
		this.pack();
	}
	

	
	
}

