import javax.swing.*;


public class epilegmenoi extends JFrame{

	private JTable patientinfoTable;
	
	public epilegmenoi(){
		//px epilegmenoi kwstas
		String[] columnNames = {"Επιλεγμένοι Ασθενεις"};
		Object[][] data = {
			    {"Επιλεγμένοι Ασθενεις"},{"Κωστας"}};
		
		patientinfoTable = new JTable(data, columnNames);
		
		this.setContentPane(patientinfoTable);
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("Επιλεγμένοι");
	}
	public void printInfo(){
		//ektuponei tis plhrofories ths epiloghs ths anazhthshs
	}
	public void delete(){
		//svinei tous epilegmenous
	}
}
