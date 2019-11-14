package regular.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class GUI extends JFrame{
	
	// Initialize GUI Components
	
	// Panels
	
	// Labels
	
	// Buttons
	
	// Text Area(s)
	
	// Text Fields
	
	// New Class instances
	
	public GUI(String title) {
		super(title);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(600, 400, 1000, 600); // (x, y, width, height)
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
		
		
}
	
	private class BtnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();
			
			if(callingBtn.equals("Login"));
				
			}
			
		}
	}
	

