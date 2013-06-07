import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class EmployeesTableModel extends AbstractTableModel
{
	private Hospital myHospital = new Hospital ();
	
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>() ;
	
	private final String[] columnNames = {"A/A" , "ом/ло" , "ажл" , 
			"гл/миа цеммгсгс" , "тгкежымо" , "коцаяиаслос тяапефас" , "диеухумсг" , "еидийотгта" , "лисхос"} ;
	
	
	public EmployeesTableModel(ArrayList<Doctor> doctorList){
		this.doctorList = doctorList;
	}

	@Override
	public int getColumnCount() 
	{
		return columnNames.length;
	}

	@Override
	public int getRowCount() 
	{
		return myHospital.getDoctors().size();
	}
	
	public String getColumnName(int arg0)
	{
		return columnNames[arg0];
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Doctor doctor = myHospital.getDoctors().get(row);
		
		switch(col) 
		{
		case 0 :
			return ""+(row+1);
		case 1 :
			return doctor.getName();
		case 2 :
			return doctor.getAfm();
		case 3 :
			return doctor.getBirthDate();
		case 4 :
			return doctor.getPhone();
		case 5 :
			return doctor.getBankAccount();
		case 6 :
			return doctor.getAddress();
		case 7 :
			return doctor.getSpecialty() ;
		case 8 :
			return doctor.printWage() ;
		}
		return null;
	}
	
	
	
}