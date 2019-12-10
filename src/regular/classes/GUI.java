package regular.classes;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame{
	//IDK if we do the user stuff here but here is a list of users that we can use in the login page
	ArrayList<User> userList;
	
	

	private JFrame loginWindow = new JFrame();

	private JPanel contentPane;
	private JPanel registerPane;
	private JTextField loginField;
	private JPasswordField passwordField;
	
	private JTextField enterUserTxtField, enterEmailTxtField, createPasswordTxtField;

	// Initialize GUI Components

	// Panels

	// Labels

	// Buttons

	// Text Area(s)

	// Text Fields

	// New Class instances

	public GUI() {
		//Instantiate arrayList
		userList = new ArrayList<>();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginWindow.setResizable(false);
		loginWindow.setTitle("Login");
		loginWindow.setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginWindow.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		// Login Pane Components
		JPanel loginPane = new JPanel();
//		contentPane.add(loginPane, "login");
		loginPane.setLayout(null);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(80, 70, 80, 20);
		loginPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(80, 110, 80, 20);
		loginPane.add(lblPassword);

		loginField = new JTextField();
		loginField.setBounds(164, 70, 100, 20);
		loginPane.add(loginField);
		loginField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 110, 100, 20);
		loginPane.add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(175, 170, 90, 24);
		loginPane.add(btnLogin);
		btnLogin.addActionListener(new BtnListener());

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(270, 170, 90, 24);
		loginPane.add(btnCancel);
		btnCancel.addActionListener(new BtnListener());

		// Register Pane Components
		JPanel registerPane = new JPanel();
		registerPane = new JPanel();
//		contentPane.add(registerPane, "register");
		registerPane.setLayout(null);

		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(80, 70, 100, 20);
		registerPane.add(lblEnterUsername);

		JLabel lblEnterEmail = new JLabel("Enter Email");
		lblEnterEmail.setBounds(80, 110, 100, 20);
		registerPane.add(lblEnterEmail);

		enterUserTxtField = new JTextField();
		enterUserTxtField.setBounds(190, 70, 100, 20);
		registerPane.add(enterUserTxtField);
		enterUserTxtField.setColumns(10);

		enterEmailTxtField = new JTextField();
		enterEmailTxtField.setBounds(190, 110, 100, 20);
		registerPane.add(enterEmailTxtField);
		enterEmailTxtField.setColumns(10);

		JLabel lblCreatePassword = new JLabel("Create Password");
		lblCreatePassword.setBounds(80, 150, 100, 20);
		registerPane.add(lblCreatePassword);

		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(200, 206, 110, 24);
		registerPane.add(btnCreateUser);
		btnCreateUser.addActionListener(new BtnListener());

		createPasswordTxtField = new JPasswordField();
		createPasswordTxtField.setBounds(190, 150, 100, 20);
		registerPane.add(createPasswordTxtField);
		
		// Tabs 
		JTabbedPane tabbedPane = new JTabbedPane();
		
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Login", loginPane);
		tabbedPane.addTab("Register", registerPane);

		JFrame mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 450, 300);

	}

	private class mainWindow extends JFrame {
		private JFrame mainWindow;

		public mainWindow() {
			mainWindow.setResizable(true);
			mainWindow.setTitle("PhotosApplication");
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setBounds(100, 100, 1350, 900);
			contentPane = new JPanel();
			contentPane.setLayout(null);
			mainWindow.setContentPane(contentPane);
		}
	}

	private class BtnListener implements ActionListener {

		private String username = null;
		private String password = null;
		private String email = null;

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("EVENT HAPPENED");
			String callingBtn = e.getActionCommand();
			CardLayout cardlayout = new CardLayout();
			

			if (callingBtn.equals("Login")) {
				
				try {
					File file = new File("/CSCI 2082 Final Project/loginInfo.txt");
					Scanner scan = new Scanner(file);
					String line = null;
					FileWriter fileWrite = new FileWriter(file, true);
					
					String userTxt = " ";
					String passTxt = " ";
					
					while (scan.hasNext()) {
						userTxt = scan.nextLine();
						passTxt = scan.nextLine();
						
						if (username.equals(userTxt) && password.equals(passTxt)) {
							JOptionPane.showMessageDialog(contentPane, "Login Successful!");
							mainWindow window = new mainWindow();
							window.setVisible(true);
							loginWindow.setVisible(false);
							loginWindow.dispose();

						} else if(username.equals("") && password.equals("")){
							JOptionPane.showMessageDialog(contentPane, "Please enter Username and Passwors");
						}
						
						else {
							JOptionPane.showMessageDialog(contentPane, "Username or password is incorrect");
						}
						
					}
				} catch (IOException d){
					d.printStackTrace();
				}
				
				username = loginField.getText();
				password = new String(passwordField.getPassword());

			}

			else if (callingBtn.equals("Create User")) {

//				email = new String(emailField.getText());
				//	private JTextField enterUserTxtField, enterEmailTxtField, createPasswordTxtField;
				String username = enterUserTxtField.getText();
				boolean flag = false;
				
				if(username.equals("")) {
					System.out.println("Username cannot be empty");
					flag = true;
				}
				
				String email = enterEmailTxtField.getText();
				if(email.equals("")) {
					System.out.println("Email cannot be empty");
					flag = true;
				}
				else if(!email.contains(".") || !email.contains("@")) {
					System.out.println("Email must be valid");
					flag = true;
				}
				
				String pass = createPasswordTxtField.getText();
				if(pass.equals("")) {
					System.out.println("Password cannot be empty");
					flag = true;
				}
				
				//Passed all input validation cases, create user and add
				if(!flag) {
					User u = new User(username, pass, email);
					
					//Check against duplicates
					boolean dupeFlag = false;
					for(int i = 0; i < userList.size(); i++) {
						User temp = userList.get(i);
						if(temp.getId().equals(u.getId())) {
							System.out.println("Users cannot have the same ID");
							dupeFlag = true;
						}
						if(temp.getEmail().equals(u.getEmail())) {
							System.out.println("Users cannot have the same password");
							dupeFlag = true;
						}
					}
					if(dupeFlag) { //Duplicate user detected
						return;
					}
					
					System.out.println("User successfully added!");
					System.out.println(u);
					userList.add(u);
				}
				
			}

			/*
			 * needs id, pwd, email, creation date private String id; private String
			 * password; private String email; private Date creationDate; //how to capture
			 * what is typed into gui box and then create a new object of that "user"
			 */

			else if (callingBtn.equals("Cancel")) {
				System.exit(0);
			}
			
			else if(callingBtn.equals("<- Back")) {
				cardlayout.next(registerPane);
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
