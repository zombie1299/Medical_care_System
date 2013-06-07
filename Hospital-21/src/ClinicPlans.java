import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ClinicPlans extends JFrame{

	private JLabel ImagePanel;
	
	public ClinicPlans(){
		
		ImageIcon HospitalIcon = new ImageIcon("HospitalImage.gif");
		ImagePanel=new JLabel(HospitalIcon);
		

		this.setContentPane(ImagePanel);
		
		this.setSize(1000,500);
		this.setVisible(true);
		this.setTitle("HOSPITAL");
	}
	
}

