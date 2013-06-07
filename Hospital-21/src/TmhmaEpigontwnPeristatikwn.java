import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TmhmaEpigontwnPeristatikwn extends JFrame{

	private JTable TepHistoryTable;
	
	static Connection dbConnection = null ;
    static String     driverClassName = "com.mysql.jdbc.Driver" ;
    static String     url             = "jdbc:mysql://localhost/hospital";
    static String     user   = "root" ;
    static String     passwd = "" ; 
	
	public TmhmaEpigontwnPeristatikwn(){
										
		try {
		    Class.forName(driverClassName);
		    Connection con = DriverManager.getConnection (url,user,passwd);
		    Statement stmt = con.createStatement();
		    String sql = "SELECT * FROM history WHERE clinic = 'TEP'";
		    ResultSet rs = stmt.executeQuery(sql);
		 				 
		    DefaultTableModel model = new DefaultTableModel(); 
		    
		    model.addColumn("������� ������");
		    model.addColumn("�����");
		    model.addColumn("����");
		    model.addColumn("����.���.");
		    /*
		    model.addColumn("����");
		    model.addColumn("��������");
		    model.addColumn("��������");
		    model.addColumn("����� ������������");
		    model.addColumn("����� �������");
		    model.addColumn("�������");
		    model.addColumn("�������");
		    model.addColumn("�������� �������");
		    model.addColumn("�������� ������");
		    model.addColumn("������");
		    */
		    
		    Object titles[] = new Object[]{"������� ������","�����","AMKA","����.���."};
		    model.addRow(titles);
		    				    
		    while (rs.next()){
		    	String patient_id = rs.getString("patient_id");
		        String name = rs.getString("name");
		        String amka = rs.getString("amka");
		        String birth = rs.getString("birth");
		        /*
		        String sex = rs.getString("sex");
		        String insurance = rs.getString("insurance");
		        String phone = rs.getString("phone");
		        String contact_person = rs.getString("contact_person");
		        String blood_type = rs.getString("blood_type");
		        String room = rs.getString("room");
		        String clinic = rs.getString("clinic");
		        String entry_diagnosis = rs.getString("entry_diagnosis");
		        String exit_diagnosis = rs.getString("exit_diagnosis");
		        String comments = rs.getString("comments");
		        */
		        
		        model.addRow(new Object[]{patient_id,name,amka,birth});					
				TepHistoryTable = new JTable(model);
				TepHistoryTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));
			
		    }
		}
		catch (SQLException e) {
		    e.printStackTrace();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		/*								
		TEP_epexergasiaButton=new JButton("�����������");
		TEP_epexergasiaButton.setSize(150, 40);
		TEP_epexergasiaButton.setLocation(300, 480);
		TEP_epexergasiaButton.addActionListener(new TEPButtonListener());
		TepHistoryTable.add(TEP_epexergasiaButton);
		TEP_OKButton=new JButton("OK");
		TEP_OKButton.setSize(150, 40);
		TEP_OKButton.setLocation(500, 480);
		TEPButtonListener tbl = new TEPButtonListener();
		TEP_OKButton.addActionListener(tbl);
		TepHistoryTable.add(TEP_OKButton);
		*/
		this.setContentPane(TepHistoryTable);
		this.setResizable(false);
		this.setSize(1270,570);
		this.setVisible(true);
		this.setTitle("�������� ���");
	}
	/*
	class TEPButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == TEP_epexergasiaButton){
			    dispose();
			}
			else if (e.getSource() == TEP_OKButton){
				new HistoryPatientCard();
				dispose();
			}
		}
	}*/
	
}

