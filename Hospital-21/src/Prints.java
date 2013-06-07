import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Prints extends JFrame{
	
	private JLabel ImagePanel;
	private JButton FinancialDataButton,StaffButton,ClinicsButton;
	private Hospital myHospital;
	private Staff staffF ;
	
	public Prints(){
		
		myHospital = new Hospital();
		ImagePanel= new JLabel();
		ImagePanel.setBackground(Color.getHSBColor(120, 50, 250));
		ImagePanel.setOpaque(true);
		
		
		FinancialDataButton= new JButton("Οικονομικά Στοιχεία");
		StaffButton= new JButton("Προσωπικό");
		ClinicsButton= new JButton ("Κλινικές");

		FinancialDataButton.setSize(150, 50);
		StaffButton.setSize(150, 50);
		ClinicsButton.setSize(150, 50);
		
		FinancialDataButton.setLocation(30, 20);
		StaffButton.setLocation(250, 20);
		ClinicsButton.setLocation(30, 150);
			
		FinancialDataButton.addActionListener( new ButtonListener());
		StaffButton.addActionListener( new ButtonListener());
		ClinicsButton.addActionListener( new ButtonListener());
		
		FinancialDataButton.setBackground(Color.getHSBColor(100, 50, 700));
		StaffButton.setBackground(Color.getHSBColor(100, 50, 700));
		ClinicsButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		FinancialDataButton.setOpaque(true);
		StaffButton.setOpaque(true);
		ClinicsButton.setOpaque(true);
		
		
		ImagePanel.add(FinancialDataButton);
		ImagePanel.add(StaffButton);
		ImagePanel.add(ClinicsButton);
		
		this.setContentPane(ImagePanel);
		this.setResizable(false);
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("Εκτυπώσεις");
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == FinancialDataButton){
				new FinancialData();
			}else if (e.getSource() == StaffButton){
				//JFrame staffFrame = new JFrame();
				staffF = new Staff(myHospital);
				//staffFrame.setContentPane(staffF);
			}else if (e.getSource() == ClinicsButton){
				new ClinicPrints();
			}
		}
	}
}

