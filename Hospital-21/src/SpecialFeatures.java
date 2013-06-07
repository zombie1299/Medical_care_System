import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SpecialFeatures extends JFrame{

	private JLabel ImagePanel;
	private JButton StatisticsButton;
	private JButton Ektaktes_Eisagwges,Taktikes_Eisagwges_ana_Klinikh,Mesos_Oros_Hlikias_Gia_Tep,xeirourgikes_Epembaseis;
	private Hospital myHospital;

	public SpecialFeatures(){
		
		ImagePanel= new JLabel();
		ImagePanel.setBackground(Color.getHSBColor(120, 50, 250));
		ImagePanel.setOpaque(true);
		
		myHospital = new Hospital();
		StatisticsButton= new JButton("Στατιστικά");
		
		StatisticsButton.setSize(250, 50);
		
		StatisticsButton.setLocation(100, 80);
		StatisticsButton.setBackground(Color.getHSBColor(100, 50, 700));
		StatisticsButton.setOpaque(true);
		
		StatisticsButton.addActionListener(new ButtonListener());
		
		ImagePanel.add(StatisticsButton);
		
		this.setContentPane(ImagePanel);
		this.setResizable(false);
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("Ειδικές Λειτουργίες");
	}
	
	class Statistics extends JFrame{
		
		private JLabel StatisticsPanel;
		
		public Statistics(){
			
			StatisticsPanel=new JLabel();
			Ektaktes_Eisagwges=new JButton("Εκτατες Εισαγωγές");
			Taktikes_Eisagwges_ana_Klinikh=new JButton("Τακτικες Ειασγωγές Κλινικής");
			Mesos_Oros_Hlikias_Gia_Tep=new JButton("Μέσος όρος Ηλικίας ΤΕΠ");
			
			xeirourgikes_Epembaseis=new JButton("Χειρουργικές Επεμβάσεις");
			
			Ektaktes_Eisagwges.setSize(250, 40);
			Taktikes_Eisagwges_ana_Klinikh.setSize(250, 40);
			Mesos_Oros_Hlikias_Gia_Tep.setSize(250, 40);
			xeirourgikes_Epembaseis.setSize(250, 40);
			
			Ektaktes_Eisagwges.setBackground(Color.getHSBColor(100, 50, 700));
			Taktikes_Eisagwges_ana_Klinikh.setBackground(Color.getHSBColor(100, 50, 700));
			Mesos_Oros_Hlikias_Gia_Tep.setBackground(Color.getHSBColor(100, 50, 700));
			xeirourgikes_Epembaseis.setBackground(Color.getHSBColor(100, 50, 700));
			
			Ektaktes_Eisagwges.setOpaque(true);
			Taktikes_Eisagwges_ana_Klinikh.setOpaque(true);
			Mesos_Oros_Hlikias_Gia_Tep.setOpaque(true);
			xeirourgikes_Epembaseis.setOpaque(true);
			
			Ektaktes_Eisagwges.setLocation(40,20);
			Taktikes_Eisagwges_ana_Klinikh.setLocation(40, 80);
			Mesos_Oros_Hlikias_Gia_Tep.setLocation(40, 140);
			xeirourgikes_Epembaseis.setLocation(40,200);
			
			StatisticsPanel.add(Ektaktes_Eisagwges);
			StatisticsPanel.add(Taktikes_Eisagwges_ana_Klinikh);
			StatisticsPanel.add(Mesos_Oros_Hlikias_Gia_Tep);
			StatisticsPanel.add(xeirourgikes_Epembaseis);
			
			StatisticsPanel.setBackground(Color.getHSBColor(120, 50, 250));

			
			Ektaktes_Eisagwges.addActionListener(new ButtonListener());
			Taktikes_Eisagwges_ana_Klinikh.addActionListener(new ButtonListener());
			Mesos_Oros_Hlikias_Gia_Tep.addActionListener(new ButtonListener());
			xeirourgikes_Epembaseis.addActionListener(new ButtonListener());
			
			this.setContentPane(StatisticsPanel);
			this.setResizable(false);
			this.setSize(350,400);
			this.setVisible(true);
			this.setTitle("Στατιστικά Νοσοκομείου");
		}
		
	}
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			if (e.getSource() == StatisticsButton){
				new Statistics();
			}if (e.getSource() == Ektaktes_Eisagwges){
				new Ektaktes_Eisagwges();
			}if (e.getSource() == Taktikes_Eisagwges_ana_Klinikh){
				new Taktikes_Eisagwges_ana_Klinikh();
			}if (e.getSource() == Mesos_Oros_Hlikias_Gia_Tep){
				new Mesos_Oros_Hlikias_Gia_Tep();
			}
			if (e.getSource() == xeirourgikes_Epembaseis){
				new xeirourgikes_Epembaseis();
			}
		}
	}
class Ektaktes_Eisagwges extends JFrame{
		
		private JLabel Ektaktes_EisagwgesLabel;
		private JTextField Ektaktes_EisagwgesTextField;
		
		public Ektaktes_Eisagwges(){
			
			Ektaktes_EisagwgesLabel=new JLabel("Εκτατες Εισαγωγές:");
			Ektaktes_EisagwgesTextField=new JTextField(myHospital.countTepTableSize());
			Ektaktes_EisagwgesTextField.setSize(130, 30);
			Ektaktes_EisagwgesTextField.setLocation(120,70);
			Ektaktes_EisagwgesLabel.add(Ektaktes_EisagwgesTextField);
			Ektaktes_EisagwgesTextField.setEditable(false);
			
			this.setContentPane(Ektaktes_EisagwgesLabel);
			this.setResizable(false);
			this.setSize(270,200);
			this.setVisible(true);
			this.setTitle("Εκτατες Εισαγωγές");
		}
		
	}
    class Taktikes_Eisagwges_ana_Klinikh extends JFrame{
		
		private JLabel TEPLabel,KardiologikhLabel,PathologikhLabel,NeurologikhLabel;
		private JTextField TEPTextField,KardiologikhTextField,PathologikhTextField,NeurologikhTextField;
		private JPanel Taktikes_Eisagwges_ana_KlinikhLabel;
		
		public Taktikes_Eisagwges_ana_Klinikh(){
			
			Taktikes_Eisagwges_ana_KlinikhLabel=new JPanel(new GridLayout(4,2));
			TEPLabel=new JLabel("ΤΕΠ:");
			KardiologikhLabel=new JLabel("Καρδιολογική:");
			PathologikhLabel=new JLabel("Παθολογική:");
			NeurologikhLabel=new JLabel("Νευρολογική:");
			
			TEPTextField=new JTextField(myHospital.countTepTableSizePerClinic("TEP"));
			
			KardiologikhTextField=new JTextField(myHospital.countTepTableSizePerClinic("Cardiologic"));
			
			PathologikhTextField=new JTextField(myHospital.countTepTableSizePerClinic("Pathologic"));
			
			NeurologikhTextField=new JTextField(myHospital.countTepTableSizePerClinic("Neurologic"));
		
			
			Taktikes_Eisagwges_ana_KlinikhLabel.add(TEPLabel);
			Taktikes_Eisagwges_ana_KlinikhLabel.add(TEPTextField);
			TEPTextField.setEditable(false);
			
			Taktikes_Eisagwges_ana_KlinikhLabel.add(KardiologikhLabel);
			Taktikes_Eisagwges_ana_KlinikhLabel.add(KardiologikhTextField);
			KardiologikhTextField.setEditable(false);
			
			Taktikes_Eisagwges_ana_KlinikhLabel.add(NeurologikhLabel);
			Taktikes_Eisagwges_ana_KlinikhLabel.add(NeurologikhTextField);
			NeurologikhTextField.setEditable(false);
			
			Taktikes_Eisagwges_ana_KlinikhLabel.add(PathologikhLabel);
			Taktikes_Eisagwges_ana_KlinikhLabel.add(PathologikhTextField);
			PathologikhTextField.setEditable(false);
			
			this.setContentPane(Taktikes_Eisagwges_ana_KlinikhLabel);
			this.setResizable(false);
			this.setSize(350,200);
			this.setVisible(true);
			this.setTitle("Εκτατες Εισαγωγές ανά Κλινική");
		}
		
	}
class Mesos_Oros_Hlikias_Gia_Tep extends JFrame{
		
		private JLabel Mesos_Oros_Hlikias_Gia_TepLabel;
		private JTextField Mesos_Oros_Hlikias_Gia_TepTextField;
		
		public Mesos_Oros_Hlikias_Gia_Tep(){
			
			Mesos_Oros_Hlikias_Gia_TepLabel=new JLabel("Μέσος Όρος Ηλικίας για ΤΕΠ:");
			Mesos_Oros_Hlikias_Gia_TepTextField=new JTextField(myHospital.countTepStatisticPerAge());
			Mesos_Oros_Hlikias_Gia_TepTextField.setSize(130, 30);
			Mesos_Oros_Hlikias_Gia_TepTextField.setLocation(170,70);
			Mesos_Oros_Hlikias_Gia_TepLabel.add(Mesos_Oros_Hlikias_Gia_TepTextField);
			Mesos_Oros_Hlikias_Gia_TepTextField.setEditable(false);
			
			this.setContentPane(Mesos_Oros_Hlikias_Gia_TepLabel);
			this.setResizable(false);
			this.setSize(350,200);
			this.setVisible(true);
			this.setTitle("Εκτατες Εισαγωγές");
		}
		
	}

class xeirourgikes_Epembaseis extends JFrame{
	
	private JLabel xeirourgikes_EpembaseisLabel;
	private JTextField xeirourgikes_EpembaseisTextField;
	
	public xeirourgikes_Epembaseis(){
		
		xeirourgikes_EpembaseisLabel=new JLabel("Χειρουργικές Επεμβάσεις:");
		xeirourgikes_EpembaseisTextField=new JTextField(myHospital.countSurgeryStatistic());
		xeirourgikes_EpembaseisTextField.setSize(130, 30);
		xeirourgikes_EpembaseisTextField.setLocation(160,70);
		xeirourgikes_EpembaseisLabel.add(xeirourgikes_EpembaseisTextField);
		xeirourgikes_EpembaseisTextField.setEditable(false);
		
		this.setContentPane(xeirourgikes_EpembaseisLabel);
		this.setResizable(false);
		this.setSize(350,200);
		this.setVisible(true);
		this.setTitle("Χειρουργικές Επεμβάσεις");
	}
	
}

}
