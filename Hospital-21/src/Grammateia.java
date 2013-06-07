import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Grammateia extends JFrame{

	private JLabel ImagePanel;
	private JButton TmhmaEpigontwnPeristatikwnButton;
	
	public Grammateia(){
		
		ImagePanel= new JLabel();
		ImagePanel.setBackground(Color.getHSBColor(400, 50, 600));
		ImagePanel.setOpaque(true);
		
		
		TmhmaEpigontwnPeristatikwnButton= new JButton("Τμήμα Επειγόντων Περιστατικών");
		
		TmhmaEpigontwnPeristatikwnButton.setSize(250, 50);
		
		TmhmaEpigontwnPeristatikwnButton.setLocation(100, 80);
		
		ImagePanel.add(TmhmaEpigontwnPeristatikwnButton);
		ImagePanel.setBackground(Color.getHSBColor(120, 50, 250));

		TmhmaEpigontwnPeristatikwnButton.addActionListener(new ButtonListener());
		TmhmaEpigontwnPeristatikwnButton.setBackground(Color.getHSBColor(100, 50, 700));
		TmhmaEpigontwnPeristatikwnButton.setOpaque(true);
		
		this.setContentPane(ImagePanel);
		this.setResizable(false);
		this.setSize(450,300);
		this.setVisible(true);
		this.setTitle("Γραμματεία");
	}
	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
		
			
			if (e.getSource() == TmhmaEpigontwnPeristatikwnButton){
				new TmhmaEpigontwnPeristatikwn();
				dispose();
			}
		}
	}
}
