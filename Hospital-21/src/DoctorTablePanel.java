import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class DoctorTablePanel extends JPanel{


	private JTable doctorTable;
	//private Hospital myHospital;
	
	ArrayList<Doctor> doctorList=new ArrayList<Doctor>();
	
	
	public DoctorTablePanel(ArrayList<Doctor> doctorList){
		
		this.doctorList = doctorList;
		
		
		doctorTable = new JTable(new EmployeesTableModel(doctorList));
		doctorTable.setFont(new Font("Times New Roman" , Font.PLAIN , 16));
		doctorTable.setRowHeight(35);
		doctorTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(doctorTable);
		
		//doctorTable.setEnabled(true);
		
		Dimension dim = new Dimension(900,200);
		doctorTable.setPreferredScrollableViewportSize(dim);
		
		this.add(scrollPane);
		this.setOpaque(true);
		
		
		
		
		
		
		
	}
	
	/*
	public String getSelectedDoctor(){
		int row = doctorTable.getSelectedRow();
		int col = doctorTable.getSelectedColumn();
		String name = (String) doctorTable.getModel().getValueAt(row, col);
		return name;
		
	}
	*/
	
}
