package regular.classes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI {

	private JFrame loginWindow = new JFrame();

	private JPanel contentPane;
	private JPanel registerPane;
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
		loginWindow.setResizable(false);
		loginWindow.setTitle("Login");
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		loginWindow.setContentPane(contentPane);

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

		//
		JPanel registerPanel = new JPanel();
		registerPane = new JPanel();
		registerPane.add(registerPanel, BorderLayout.CENTER);
		registerPanel.setLayout(null);

		JLabel lblCreateUsername = new JLabel("Enter Username");
		lblCreateUsername.setBounds(80, 70, 90, 20);
		registerPanel.add(lblCreateUsername);

		JLabel lblEmail = new JLabel("Enter Email");
		lblEmail.setBounds(80, 110, 90, 20);
		registerPanel.add(lblEmail);

		JTextField userNameTxtField = new JTextField();
		userNameTxtField.setBounds(180, 70, 100, 20);
		registerPanel.add(userNameTxtField);
		userNameTxtField.setColumns(10);

		JTextField emailTxtField = new JTextField();
		emailTxtField.setBounds(180, 110, 100, 20);
		registerPanel.add(emailTxtField);
		emailTxtField.setColumns(10);

		JLabel lblEnterPassword = new JLabel("Create Password");
		lblEnterPassword.setBounds(80, 150, 90, 20);
		registerPanel.add(lblEnterPassword);

		JButton backButton = new JButton("<- Back to Login");
		backButton.setBounds(80, 206, 110, 23);
		registerPanel.add(backButton);

		JButton regButton = new JButton("Register");
		regButton.setBounds(200, 206, 89, 23);
		registerPanel.add(regButton);

		JPasswordField createPasswordField = new JPasswordField();
		createPasswordField.setBounds(180, 150, 100, 20);
		registerPanel.add(createPasswordField);

		JFrame mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 450, 300);

	}

	private class mainWindow extends JFrame {

		public mainWindow() {
			setResizable(true);
			setTitle("PhotosApplication");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1350, 900);
			contentPane = new JPanel();
			contentPane.setLayout(null);
			setContentPane(contentPane);
		}
	}

	private class BtnListener implements ActionListener {

		private String username = null;
		private String password = null;
		private String email = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			String callingBtn = e.getActionCommand();

			if (callingBtn.equals("Login")) {
				username = loginField.getText();
				password = new String(passwordField.getPassword());

				if (username.equals("user") && password.equals("pass")) {
					JOptionPane.showMessageDialog(contentPane, "Login Successful!");
					mainWindow window = new mainWindow();
					window.setVisible(true);
					loginWindow.setVisible(false);
					loginWindow.dispose();

				} else {
					JOptionPane.showMessageDialog(contentPane, "Username or password is incorrect");
				}
			}

			else if (callingBtn.equals("Register")) {
//				contentPane.add(registerPane);
//				contentPane.remove(contentPane);

//				email = new String(emailField.getText());
				User createUser = new User(username, password, email);
			}

			/*
			 * needs id, pwd, email, creation date private String id; private String
			 * password; private String email; private Date creationDate; //how to capture
			 * what is typed into gui box and then create a new object of that "user"
			 */

			else if (callingBtn.equals("Cancel")) {
				System.exit(0);
			}

		}

	}

	public static void main(String[] args) {
		GUI frame = new GUI();
		frame.loginWindow.setVisible(true);
		// Should set window to center
		frame.loginWindow.setLocationRelativeTo(null);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
