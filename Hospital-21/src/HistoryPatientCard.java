import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HistoryPatientCard extends JFrame{
		
		private JLabel PatientPanel;
		private JButton DataButton,VisitButton,SurgeryButton,RefererrsButton,DischargeNoteButton,DocumentButton;
		private JTable DataTable,VisitTable,SurgeryTable,RefererrsTable,DischargeNoteTable,DocumentTable;
		
		public HistoryPatientCard(){
			
			DataButton=new JButton("Στοιχεία");
			VisitButton=new JButton("Επισκέψεις");
			SurgeryButton=new JButton("Επεμβάσεις");
			RefererrsButton=new JButton("Παραπεμπτικά");
			DischargeNoteButton=new JButton("Εξιτήριο");
			DocumentButton=new JButton("Παραστατικά");
			
			DataButton.setBackground(Color.getHSBColor(100, 50, 700));
			VisitButton.setBackground(Color.getHSBColor(100, 50, 700));
			SurgeryButton.setBackground(Color.getHSBColor(100, 50, 700));
			RefererrsButton.setBackground(Color.getHSBColor(100, 50, 700));
			DischargeNoteButton.setBackground(Color.getHSBColor(100, 50, 700));
			DocumentButton.setBackground(Color.getHSBColor(100, 50, 700));
			
			DataButton.setOpaque(true);
			VisitButton.setOpaque(true);
			SurgeryButton.setOpaque(true);
			RefererrsButton.setOpaque(true);
			DischargeNoteButton.setOpaque(true);
			DocumentButton.setOpaque(true);
			
			ButtonListener patient_info = new ButtonListener();
			DataButton.addActionListener(patient_info);
			VisitButton.addActionListener(patient_info);
			SurgeryButton.addActionListener(patient_info);
			RefererrsButton.addActionListener(patient_info);
			DischargeNoteButton.addActionListener(patient_info);
			DocumentButton.addActionListener(patient_info);
			
			String[] columnNamesData = {"Στοιχεία Ασθενή","ΟΝΟΜΑ-ΕΠΩΝΥΜΟ","AMKA","Ημ. Γένησης","Φύλο","Ασφάλιση","Τηλέφωνο","’νθρωπος Επικοινωνίας","Ομάδα Αίματος","Δωμάτιο"};
			Object[][] dataOfData = {
				    {"Στοιχεία Ασθενή","ΟΝΟΜΑ-ΕΠΩΝΥΜΟ","AMKA","Ημ. Γένησης","Φύλο","Ασφάληση","Τηλέφωνο","’νθρωπος Επικοινωνίας","Ομάδα Αίματος","Δωμάτιο"},{}};
			
			DataTable = new JTable(dataOfData, columnNamesData);
			
			String[] columnNamesVisit = {"Επίσκεψη","Διάγνωση Εισόδου","Διάγνωση Εξόδου","Σχόλια","Ημερομηνία","Γιατρός"};
			Object[][] dataOfVisit = {
				    {"Επίσκεψη","Διάγνωση Εισόδου","Διάγνωση Εξόδου","Σχόλια","Ημερομηνία","Γιατρός"},{}};
			
			DataTable = new JTable(dataOfVisit, columnNamesVisit);
			
			String[] columnNamesSurgery = {"Χειρουργεία","Γιατροί","Νοσηλευτές","Μηχανήματα","Επιτυχία","Ημερομηνία","Σχόλια"};
			Object[][] dataOfSurgery = {
				    {"Χειρουργεία","Γιατροί","Νοσηλευτές","Μηχανήματα","Επιτυχία","Ημερομηνία","Σχόλια"},{}};
			
			DataTable = new JTable(dataOfSurgery, columnNamesSurgery);
			
			String[] columnNamesRefererrs = {"Εξετάσεις","Ημερομηνία"};
			Object[][] dataOfRefererrs = {
				    {"Εξετάσεις","Ημερομηνία"},{}};
			
			DataTable = new JTable(dataOfRefererrs , columnNamesRefererrs );
			
			String[] columnNamesDischargeNote = {"Αριθμός","Ημερομηνία","Σχόλια"};
			Object[][] dataOfDischargeNote = {
				    {"Αριθμός","Ημερομηνία","Σχόλια"},{}};
			
			DataTable = new JTable(dataOfDischargeNote, columnNamesDischargeNote);
			
			String[] columnNamesDocument = {"Έγγραφα","Ημερομηνία"};
			Object[][] dataOfDocument = {
				    {"Έγγραφα","Ημερομηνία"},{}};
			
			DataTable = new JTable(dataOfDocument, columnNamesDocument);
			
			
			PatientPanel=new JLabel();
			PatientPanel.setBackground(Color.getHSBColor(120, 50, 250));

			
			DataButton.setSize(150, 40);
			VisitButton.setSize(150, 40);
			SurgeryButton.setSize(150, 40);
			RefererrsButton.setSize(150, 40);
			DischargeNoteButton.setSize(150, 40);
			DocumentButton.setSize(150, 40);
			
			DataButton.setLocation(40,20);
			VisitButton.setLocation(40, 80);
			SurgeryButton.setLocation(40, 140);
			RefererrsButton.setLocation(40, 200);
			DischargeNoteButton.setLocation(40,260);
			DocumentButton.setLocation(40,320);
			
			PatientPanel.add(DataButton);
			PatientPanel.add(VisitButton);
			PatientPanel.add(SurgeryButton);
			PatientPanel.add(RefererrsButton);
			PatientPanel.add(DischargeNoteButton);
			PatientPanel.add(DocumentButton);
			
			this.setContentPane(PatientPanel);
			this.setResizable(false);
			this.setSize(250,400);
			this.setVisible(true);
			this.setTitle("Στοιχεία Ασθενή");
		}
		class ButtonListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
			
				if (e.getSource() == DataButton){
					new PatientInfo();
				}else if (e.getSource() == VisitButton){
					new PatientVisit();				
				}else if (e.getSource() == SurgeryButton){
					new PatientSurgery();
				}else if (e.getSource() == RefererrsButton){
					new PatientReferral();
				}else if (e.getSource() == DischargeNoteButton){
					new PatientDischarge();
				}else if (e.getSource() == DocumentButton){
					new PatientDocument();
				}
			}
		}
}
