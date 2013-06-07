import javax.swing.*;

public class FinancialData extends JFrame{
	
	private JLabel ImagePanel;
    private JTextField incomePrice ,costsPrice, profitsPrice;
    
	public FinancialData(){
		
		ImageIcon PanelIcon = new ImageIcon("FinancialDataBoard.gif");
		ImagePanel=new JLabel(PanelIcon);

		incomePrice=new JTextField();
		costsPrice=new JTextField();
		profitsPrice=new JTextField();
		
		incomePrice.setLocation(160, 40);
		costsPrice.setLocation(160, 70);
		profitsPrice.setLocation(160, 100);
		
		incomePrice.setSize(140,20);
		costsPrice.setSize(140,20);
		profitsPrice.setSize(140,20);

		ImagePanel.add(incomePrice);
		ImagePanel.add(costsPrice);
		ImagePanel.add(profitsPrice);
		
		this.setContentPane(ImagePanel);
		
		this.setSize(320,200);
		this.setVisible(true);
		this.setTitle("Οικονομικά Στοιχεία Νοσοκομείου");
	}
}
