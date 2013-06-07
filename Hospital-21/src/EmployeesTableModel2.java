import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class EmployeesTableModel2 extends AbstractTableModel{
	
	
	private Hospital myHospital = new Hospital ();
	
	ArrayList<Nurse> nurseList = new ArrayList<Nurse>() ;
	
	
	private final String[] columnNames = {"A/A" , "ом/ло" , "ажл" , 
			"гл/миа цеммгсгс" , "тгкежымо" , "коцаяиаслос тяапефас" , "диеухумсг" , "лисхос"} ;
	
	
	public EmployeesTableModel2(ArrayList<Nurse> nurseList){
		this.nurseList = nurseList;
	}

	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount() 
	{
		return myHospital.getNurses().size();
	}
	
	public String getColumnName(int arg0)
	{
		return columnNames[arg0];
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Nurse nurse = myHospital.getNurses().get(row);
		
		switch(col) 
		{
		case 0 :
			return ""+(row+1);
		case 1 :
			return nurse.getName();
		case 2 :
			return nurse.getAfm();
		case 3 :
			return nurse.getBirthDate();
		case 4 :
			return nurse.getPhone();
		case 5 :
			return nurse.getBankAccount();
		case 6 :
			return nurse.getAddress();
		case 7 :
			return nurse.printWage() ;
		}
		return null;
	}
	
	

}
