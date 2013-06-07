import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NurseTablePanel extends JPanel{
		
	private JTable nurseTable;
	//private Hospital myHospital;
		
	ArrayList<Nurse> nurseList=new ArrayList<Nurse>();
			
	public NurseTablePanel(ArrayList<Nurse> nurseList){
			
		this.nurseList = nurseList;
				
		nurseTable = new JTable(new EmployeesTableModel2(nurseList));
		nurseTable.setFont(new Font("Times New Roman" , Font.PLAIN , 16));
		nurseTable.setRowHeight(35);
		nurseTable.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(nurseTable);
			
		Dimension dim = new Dimension(900,200);
		nurseTable.setPreferredScrollableViewportSize(dim);
			
		this.add(scrollPane);
		this.setOpaque(true);
			
	}

}

