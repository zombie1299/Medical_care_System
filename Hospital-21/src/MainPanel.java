import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
//Klash Grafikwn
public class MainPanel extends JFrame{

	private JLabel ImagePanel;
	private JButton Mov_OfficeButton,SecretariatButton,PrinterButton,Special_UseButton;
	private JButton ChosenButton,HistoryButton,PlanButton;
	private JButton SearchButton,ClearButton,PrintButton;
	
	
	
	
	//we've changed-start
	private Hospital myHospital ;
	////we've changed-end
	
	public MainPanel(){
		
		myHospital = new Hospital() ;
		
		ImageIcon PanelIcon = new ImageIcon("StartPanelBoard.gif");
		ImagePanel=new JLabel(PanelIcon);
		
		Mov_OfficeButton=new JButton("Γραφείο Κίνησης");
		SecretariatButton=new JButton("Γραμματεία");
		PrinterButton=new JButton("Εκτυπώσεις");
		Special_UseButton=new JButton("Ειδικές Λειτουργίες");
		
		Mov_OfficeButton.setSize(150, 50);
		SecretariatButton.setSize(150, 50);
		PrinterButton.setSize(150, 50);
		Special_UseButton.setSize(150, 50);
		
		Mov_OfficeButton.setLocation(10, 10);
		SecretariatButton.setLocation(170, 10);
		PrinterButton.setLocation(340, 10);
		Special_UseButton.setLocation(500, 10);
		
	    Mov_OfficeButton.setBackground(Color.getHSBColor(100, 50, 700));
	    Mov_OfficeButton.setOpaque(true);
	    SecretariatButton.setBackground(Color.getHSBColor(100, 50, 700));
	    SecretariatButton.setOpaque(true);
	    PrinterButton.setBackground(Color.getHSBColor(100, 50, 700));
	    PrinterButton.setOpaque(true); 
	    Special_UseButton.setBackground(Color.getHSBColor(100, 50, 700));
	    Special_UseButton.setOpaque(true);
	    
	    Mov_OfficeButton.addActionListener( new ButtonListener());
	    SecretariatButton.addActionListener( new ButtonListener());
	    PrinterButton.addActionListener( new ButtonListener());
	    Special_UseButton.addActionListener( new ButtonListener());
		
		ChosenButton=new JButton("Επιλεγμένοι");
		HistoryButton=new JButton("Ιστορικό");
		PlanButton=new JButton("Πλάνο");
		
		ChosenButton.setBackground(Color.getHSBColor(100, 50, 700));
	    ChosenButton.setOpaque(true);
	    HistoryButton.setBackground(Color.getHSBColor(100, 50, 700));
	    HistoryButton.setOpaque(true); 
	    PlanButton.setBackground(Color.getHSBColor(100, 50, 700));
	    PlanButton.setOpaque(true);
		
		ChosenButton.setSize(150, 40);
		HistoryButton.setSize(150, 40);
		PlanButton.setSize(150, 40);
		
		ChosenButton.setLocation(650, 100);
		HistoryButton.setLocation(650, 170);
		PlanButton.setLocation(650, 250);
		
		ChosenButton.addActionListener( new ButtonListener());
		PlanButton.addActionListener( new ButtonListener());
		HistoryButton.addActionListener( new ButtonListener());
		
		SearchButton=new JButton("ΑΝΑΖΗΤΗΣΗ");
		ClearButton=new JButton("ΚΑΘΑΡΙΣΜΟΣ");
		PrintButton=new JButton("ΕΚΤΥΠΩΣΗ");
		
		SearchButton.setSize(150, 40);
		ClearButton.setSize(150, 40);
		PrintButton.setSize(150, 40);
		
		SearchButton.setLocation(830,100);
		ClearButton.setLocation(830, 170);
		PrintButton.setLocation(830, 250);
	
		SearchButton.setBackground(Color.getHSBColor(100, 50, 700));
		SearchButton.setOpaque(true);
		ClearButton.setBackground(Color.getHSBColor(100, 50, 700));
	    ClearButton.setOpaque(true);
	    PrintButton.setBackground(Color.getHSBColor(100, 50, 700));
	    PrintButton.setOpaque(true); 
		
	    SearchButton.addActionListener( new ButtonListener());
	    
	    ImagePanel.add(Mov_OfficeButton);
		ImagePanel.add(SecretariatButton);
		ImagePanel.add(PrinterButton);
		ImagePanel.add(Special_UseButton);
		
		ImagePanel.add(ChosenButton);
		ImagePanel.add(HistoryButton);
		ImagePanel.add(PlanButton);
		
		ImagePanel.add(SearchButton);
		ImagePanel.add(ClearButton);
		ImagePanel.add(PrintButton);
		
		this.setContentPane(ImagePanel);
		
		this.setSize(1000,500);
		this.setVisible(true);
		this.setTitle("HOSPITAL");
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e){
		
			
			if (e.getSource() == Mov_OfficeButton){
				new Mov_Office(myHospital);
			}else if (e.getSource() == SecretariatButton){
				new Grammateia();
			}else if (e.getSource() == PrinterButton){
				new Prints();
			}else if (e.getSource() == Special_UseButton){
				new SpecialFeatures();
			}else if (e.getSource() == PlanButton){
				new ClinicPlans();
			}else if (e.getSource() == ChosenButton){
				new epilegmenoi();
			}else if (e.getSource() == HistoryButton){
				new History();
			}else if (e.getSource() == ClearButton){
			    Clear();
			}else if (e.getSource() == PrintButton){
			    //ektuposh
			}else if (e.getSource() == SearchButton){
				new Search();
			}
		}
	}
	public void Clear() {
		//katharismos twn epilegmenwn
		
	}


}
