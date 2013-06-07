import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Mov_Office extends JFrame{

	private JLabel ImagePanel;
	private JButton PatientCardButton,TEPticketButton,SergeryButton,DischargeButton;
	
	private Hospital myHospital;
	
	private ArrayList surgeryList;
	
	public Mov_Office(Hospital myHospital){
		
		surgeryList = myHospital.getSurgeries();
		
		ImagePanel= new JLabel();
		ImagePanel.setBackground(Color.getHSBColor(100, 50, 600));
		ImagePanel.setOpaque(true);
		
		PatientCardButton= new JButton("Καρτέλα Ασθενή");
		TEPticketButton= new JButton("ΤΕΠ");
		SergeryButton= new JButton ("Χειρουργεία");
		DischargeButton= new JButton ("Εξιτήριο");

		PatientCardButton.setSize(150, 50);
		TEPticketButton.setSize(150, 50);
		SergeryButton.setSize(150, 50);
		DischargeButton.setSize(150, 50);
		
		PatientCardButton.setLocation(30, 20);
		TEPticketButton.setLocation(250, 20);
		SergeryButton.setLocation(30, 150);
		DischargeButton.setLocation(250, 150);
		
		PatientCardButton.addActionListener( new ButtonListener());
		TEPticketButton.addActionListener( new ButtonListener());
		SergeryButton.addActionListener( new ButtonListener());
		DischargeButton.addActionListener( new ButtonListener());
		
		PatientCardButton.setBackground(Color.getHSBColor(100, 50, 700));
		TEPticketButton.setBackground(Color.getHSBColor(100, 50, 700));
		SergeryButton.setBackground(Color.getHSBColor(100, 50, 700));
		DischargeButton.setBackground(Color.getHSBColor(100, 50, 700));
		
		PatientCardButton.setOpaque(true);
		TEPticketButton.setOpaque(true);
		SergeryButton.setOpaque(true);
		DischargeButton.setOpaque(true);
		
		ImagePanel.add(PatientCardButton);
		ImagePanel.add(TEPticketButton);
		ImagePanel.add(SergeryButton);
		ImagePanel.add(DischargeButton);
		ImagePanel.setBackground(Color.getHSBColor(120, 50, 250));
		
		this.setContentPane(ImagePanel);
		this.setResizable(false);
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("Γραφείο Κίνησης");
		
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == PatientCardButton){
				new PatientCard();
			}else if (e.getSource() == TEPticketButton){
				new TepCard();
			}else if (e.getSource() == SergeryButton){
				new SurgeryBoard(surgeryList);
			}else if (e.getSource() == DischargeButton){
				new DischargeNoteBoard();
			}
			dispose();
		}
	}
}
