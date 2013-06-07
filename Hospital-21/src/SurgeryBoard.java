import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;
//Klash Grafikwn

public class SurgeryBoard extends JFrame{

private JLabel SurgeryBoardLabel;
private JComboBox<String> availabilityComboBox1,availabilityComboBox2,availabilityComboBox3,availabilityComboBox4,
                          availabilityComboBox5,availabilityComboBox6,availabilityComboBox7,availabilityComboBox8,
                          availabilityComboBox9,availabilityComboBox10,availabilityComboBox11,availabilityComboBox12,
                          availabilityComboBox13;

private String[] availabilityList;


private ArrayList<Surgery> surgeryList = new ArrayList<Surgery>();


	public SurgeryBoard(ArrayList<Surgery> surgeryList){
		ImageIcon SurgeryIcon = new ImageIcon("SurgeryBoard.gif");
		SurgeryBoardLabel= new JLabel(SurgeryIcon);
		
		availabilityList = new String [2];
		
		availabilityList[0] = "Διαθέσιμο";
		availabilityList[1] = "Μη Διαθέσιμο";
		
		this.surgeryList = surgeryList;
		
		
		
		//for(int i = 0 ; i < surgeryList.size(); i++){
			//System.out.println(surgeryList.get(i).getAvailable());
		//}
		
		
		System.out.println(surgeryList.size());
		
		//CB1
		availabilityComboBox1=new JComboBox(availabilityList);
		availabilityComboBox1.setEditable(false);
		if(surgeryList.get(0).getAvailable() == true)
			{availabilityComboBox1.setSelectedItem(availabilityList[0]);}
		else
			{availabilityComboBox1.setSelectedItem(availabilityList[1]);}
		SurgeryBoardLabel.add(availabilityComboBox1);
		availabilityComboBox1.addActionListener(new ComboBoxListener() ) ;
		
		//CB2	
		availabilityComboBox2=new JComboBox(availabilityList);
		availabilityComboBox2.setEditable(false);
		if(surgeryList.get(1).getAvailable() == true)
			availabilityComboBox2.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox2.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox2);
		availabilityComboBox2.addActionListener(new ComboBoxListener() ) ;
		
		//CB3
		availabilityComboBox3=new JComboBox(availabilityList);
		availabilityComboBox3.setEditable(false);
		if(surgeryList.get(2).getAvailable() == true)
			availabilityComboBox3.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox3.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox3);
		availabilityComboBox3.addActionListener(new ComboBoxListener() ) ;
		
		//CB4
		availabilityComboBox4=new JComboBox(availabilityList);
		availabilityComboBox4.setEditable(false);
		if(surgeryList.get(3).getAvailable() == true)
			availabilityComboBox4.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox4.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox4);
		availabilityComboBox4.addActionListener(new ComboBoxListener() ) ;
		
		//CB5
		availabilityComboBox5=new JComboBox(availabilityList);
		availabilityComboBox5.setEditable(false);
		if(surgeryList.get(4).getAvailable() == true)
			availabilityComboBox5.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox5.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox5);
		availabilityComboBox5.addActionListener(new ComboBoxListener() ) ;
		
		//CB6
		availabilityComboBox6=new JComboBox(availabilityList);
		availabilityComboBox6.setEditable(false);
		if(surgeryList.get(5).getAvailable() == true)
			availabilityComboBox6.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox6.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox6);
		availabilityComboBox6.addActionListener(new ComboBoxListener() ) ;
		
		//CB7
		availabilityComboBox7=new JComboBox(availabilityList);
		availabilityComboBox7.setEditable(false);
		if(surgeryList.get(6).getAvailable() == true)
			availabilityComboBox7.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox7.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox7);
		availabilityComboBox7.addActionListener(new ComboBoxListener() ) ;
		
		//CB8
		availabilityComboBox8=new JComboBox(availabilityList);
		availabilityComboBox8.setEditable(false);
		if(surgeryList.get(7).getAvailable() == true)
			availabilityComboBox8.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox8.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox8);
		availabilityComboBox8.addActionListener(new ComboBoxListener() ) ;
		
		//CB9
		availabilityComboBox9=new JComboBox(availabilityList);
		availabilityComboBox9.setEditable(false);
		if(surgeryList.get(8).getAvailable() == true)
			availabilityComboBox9.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox9.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox9);
		availabilityComboBox9.addActionListener(new ComboBoxListener() ) ;
		
		//CB10
		availabilityComboBox10=new JComboBox(availabilityList);
		availabilityComboBox10.setEditable(false);
		if(surgeryList.get(9).getAvailable() == true)
			availabilityComboBox10.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox10.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox10);
		availabilityComboBox10.addActionListener(new ComboBoxListener() ) ;
		
		//CB11
		availabilityComboBox11=new JComboBox(availabilityList);
		availabilityComboBox11.setEditable(false);
		if(surgeryList.get(10).getAvailable() == true)
			availabilityComboBox11.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox11.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox11);
		availabilityComboBox11.addActionListener(new ComboBoxListener() ) ;
		
		//CB12
		availabilityComboBox12=new JComboBox(availabilityList);
		availabilityComboBox12.setEditable(false);
		if(surgeryList.get(11).getAvailable() == true)
			availabilityComboBox12.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox12.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox12);
		availabilityComboBox12.addActionListener(new ComboBoxListener() ) ;
		
		//CB13
		availabilityComboBox13=new JComboBox(availabilityList);
		availabilityComboBox13.setEditable(false);
		if(surgeryList.get(12).getAvailable() == true)
			availabilityComboBox13.setSelectedItem(availabilityList[0]);
		else
			availabilityComboBox13.setSelectedItem(availabilityList[1]);
		SurgeryBoardLabel.add(availabilityComboBox13);
		availabilityComboBox13.addActionListener(new ComboBoxListener() ) ;
		
		
	
		
		availabilityComboBox1.setBounds(460, 30, 130, 30);
		availabilityComboBox2.setBounds(460, 60, 130, 30);
		availabilityComboBox3.setBounds(460, 90, 130, 30);
		availabilityComboBox4.setBounds(460, 120, 130, 30);
		availabilityComboBox5.setBounds(460, 150, 130, 30);
		availabilityComboBox6.setBounds(460, 180, 130, 30);
		availabilityComboBox7.setBounds(460, 210, 130, 30);
		availabilityComboBox8.setBounds(460, 240, 130, 30);
		availabilityComboBox9.setBounds(460, 270, 130, 30);
		availabilityComboBox10.setBounds(460, 300, 130, 30);
		availabilityComboBox11.setBounds(460, 330, 130, 30);
		availabilityComboBox12.setBounds(460, 360, 130, 30);
		availabilityComboBox13.setBounds(460, 390, 130, 30);
		
		
		this.setContentPane(SurgeryBoardLabel);
		this.setResizable(false);
		this.setSize(770,450);
		this.setVisible(true);
		this.setTitle("Χειρουργεία");
		
    }



class ComboBoxListener implements ActionListener 
{
	public void actionPerformed(ActionEvent e)
	{     int Selection;
		 if(e.getSource()==availabilityComboBox1)
		 {
		    Selection = availabilityComboBox1.getSelectedIndex();
		    if (Selection == 0) 
		    {
		    	surgeryList.get(0).setAvailable(true);
		    }
		    else 
		    {
		    	surgeryList.get(0).setAvailable(false);
		    }
		 }
		 else if(e.getSource()==availabilityComboBox2)
		 {
			
			 Selection = availabilityComboBox2.getSelectedIndex();
			 if (Selection == 0) 
			    {
				 	surgeryList.get(1).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(1).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox3)
		 {
		
		    Selection = availabilityComboBox3.getSelectedIndex();
		    if (Selection == 0) 
		    {
		    	surgeryList.get(2).setAvailable(true);
			 	
		    }
		    else 
		    {
		    	surgeryList.get(2).setAvailable(false);
		    	
		    }
		 }
		 else if(e.getSource()==availabilityComboBox4)
		 {
			 Selection = availabilityComboBox4.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(3).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(3).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox5)
		 {
			
			 Selection = availabilityComboBox5.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(4).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(4).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox6)
		 {
			 Selection = availabilityComboBox6.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(5).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(5).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox7)
		 {
			
			 Selection = availabilityComboBox7.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(6).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(6).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox8)
		 {
			
			 Selection = availabilityComboBox8.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(7).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(7).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox9)
		 {
			
			 Selection = availabilityComboBox9.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(8).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(8).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox10)
		 {
			
			 Selection = availabilityComboBox10.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(9).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(9).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox11)
		 {
			
			 Selection = availabilityComboBox11.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(10).setAvailable(true);
				 	System.out.println("mphke");
			    }
			    else 
			    {
			    	surgeryList.get(10).setAvailable(false);
			    	System.out.println("mphke");
			    }
		 }
		 else if(e.getSource()==availabilityComboBox12)
		 {
			 Selection = availabilityComboBox12.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(11).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(11).setAvailable(false);
			    	
			    }
		 }
		 else if(e.getSource()==availabilityComboBox13)
		 {
			
			 Selection = availabilityComboBox13.getSelectedIndex();
			    if (Selection == 0) 
			    {
			    	surgeryList.get(12).setAvailable(true);
				 	
			    }
			    else 
			    {
			    	surgeryList.get(12).setAvailable(false);
			    	
			    }
		 }
	 }
		 
  }
}