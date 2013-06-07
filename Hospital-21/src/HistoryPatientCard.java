import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HistoryPatientCard extends JFrame{
		
		private JLabel PatientPanel;
		private JButton DataButton,VisitButton,SurgeryButton,RefererrsButton,DischargeNoteButton,DocumentButton;
		private JTable DataTable,VisitTable,SurgeryTable,RefererrsTable,DischargeNoteTable,DocumentTable;
		
		public HistoryPatientCard(){
			
			DataButton=new JButton("��������");
			VisitButton=new JButton("����������");
			SurgeryButton=new JButton("����������");
			RefererrsButton=new JButton("������������");
			DischargeNoteButton=new JButton("��������");
			DocumentButton=new JButton("�����������");
			
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
			
			String[] columnNamesData = {"�������� ������","�����-�������","AMKA","��. �������","����","��������","��������","�������� ������������","����� �������","�������"};
			Object[][] dataOfData = {
				    {"�������� ������","�����-�������","AMKA","��. �������","����","��������","��������","�������� ������������","����� �������","�������"},{}};
			
			DataTable = new JTable(dataOfData, columnNamesData);
			
			String[] columnNamesVisit = {"��������","�������� �������","�������� ������","������","����������","�������"};
			Object[][] dataOfVisit = {
				    {"��������","�������� �������","�������� ������","������","����������","�������"},{}};
			
			DataTable = new JTable(dataOfVisit, columnNamesVisit);
			
			String[] columnNamesSurgery = {"�����������","�������","����������","����������","��������","����������","������"};
			Object[][] dataOfSurgery = {
				    {"�����������","�������","����������","����������","��������","����������","������"},{}};
			
			DataTable = new JTable(dataOfSurgery, columnNamesSurgery);
			
			String[] columnNamesRefererrs = {"���������","����������"};
			Object[][] dataOfRefererrs = {
				    {"���������","����������"},{}};
			
			DataTable = new JTable(dataOfRefererrs , columnNamesRefererrs );
			
			String[] columnNamesDischargeNote = {"�������","����������","������"};
			Object[][] dataOfDischargeNote = {
				    {"�������","����������","������"},{}};
			
			DataTable = new JTable(dataOfDischargeNote, columnNamesDischargeNote);
			
			String[] columnNamesDocument = {"�������","����������"};
			Object[][] dataOfDocument = {
				    {"�������","����������"},{}};
			
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
			this.setTitle("�������� ������");
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
