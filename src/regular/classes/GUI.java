package regular.classes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class GUI extends JFrame{
	
	private JPanel contentPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	// Initialize GUI Components
	
	// Panels
	
	// Labels
	
	// Buttons
	
	// Text Area(s)
	
	// Text Fields
	
	// New Class instances
	
	public GUI() {
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel loginPanel = new JPanel();
		contentPane.add(loginPanel, BorderLayout.CENTER);
		loginPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(80, 70, 80, 20);
		loginPanel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 110, 80, 20);
		loginPanel.add(lblPassword);
		
		loginField = new JTextField();
		loginField.setBounds(164, 70, 100, 20);
		loginPanel.add(loginField);
		loginField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 110, 100, 20);
		loginPanel.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(80, 170, 90, 24);
		loginPanel.add(btnRegister);
		btnRegister.addActionListener(new BtnListener());
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(175, 170, 90, 24);
		loginPanel.add(btnLogin);
		btnLogin.addActionListener(new BtnListener());
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(270, 170, 90, 24);
		loginPanel.add(btnCancel);
		btnCancel.addActionListener(new BtnListener());
		
		
		
}
	
	private class BtnListener implements ActionListener {

		private String username = null;
		private String password = null;
		private String email = null;
		@Override
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();
			
			if(callingBtn.equals("Login")) {
				username = loginField.getText();
				password = new String(passwordField.getPassword());
			}
			
			else if(callingBtn.equals("Register")) {
				email = new String(emailField.getText());
				User createUser = new User(username, password, email); 
			}
			
			/* needs id, pwd, email, creation date 
			 *  private String id;
				private String password;
				private String email;
				private Date creationDate;
				//how to capture what is typed into gui box and then
				 * create a new object of that "user" 
			 */
			
			
			else if(callingBtn.equals("Cancel")) {
				System.exit(0);
			}
				
			}
	
		
			
		}
	
	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.setVisible(true);
		// Should set window to center
		frame.setLocationRelativeTo(null);
				
	}
	}
	

