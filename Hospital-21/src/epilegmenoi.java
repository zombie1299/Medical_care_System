import javax.swing.*;


public class epilegmenoi extends JFrame{

	private JTable patientinfoTable;
	
	public epilegmenoi(){
		//px epilegmenoi kwstas
		String[] columnNames = {"����������� ��������"};
		Object[][] data = {
			    {"����������� ��������"},{"������"}};
		
		patientinfoTable = new JTable(data, columnNames);
		
		this.setContentPane(patientinfoTable);
		this.setSize(300,300);
		this.setVisible(true);
		this.setTitle("�����������");
	}
	public void printInfo(){
		//ektuponei tis plhrofories ths epiloghs ths anazhthshs
	}
	public void delete(){
		//svinei tous epilegmenous
	}
}
