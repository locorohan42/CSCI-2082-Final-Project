package regular.classes;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import javax.swing.*;
import java.awt.Component;

@SuppressWarnings("serial")
public class mainWindow extends JFrame {

	// Variables declaration
	int position = 0; // Initial position is 0
	String[] filenames; // Array to hold the file names
	final String Path = "src/StartingPhotos"; // path to images
	private JButton NextButton;
	private JButton PreviousButton;
	private JLabel picLabel;
	private JPanel sidePanel;
	private JLabel lblMyPhotos;
	private JList list;
	private JScrollPane scrollPane;
	// End of variables declaration//GEN-END:variables

	/**
	 * Class constructor: mainWindow
	 */
	public mainWindow() {
		initComponents();
		listFiles(Path); // Lists all the files in the directory on window opening
		setLabelIcon(Path, filenames[position]); // sets the label to display the first
													// image in the directory on window opening.
		PreviousButton.setEnabled(false);

		sidePanel = new JPanel();
		getContentPane().add(sidePanel, BorderLayout.WEST);
		sidePanel.setLayout(new BorderLayout(0, 0));
		
		lblMyPhotos = new JLabel("My Photos");
		lblMyPhotos.setHorizontalAlignment(SwingConstants.CENTER);
		sidePanel.add(lblMyPhotos, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		sidePanel.add(scrollPane, BorderLayout.CENTER);
		
		list = new JList(filenames);
		scrollPane.setViewportView(list);
	}

	/**
	 * Initialize components
	 */
	private void initComponents() {
		setTitle("Image Viewer");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());// The layout is BorderLayout
		// setBorder(javax.swing.BorderFactory.createEtchedBorder());
		setBackground(Color.GRAY);
		picLabel = new JLabel(); // Create the Label to display the picture
		picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		
		// VerticalBox to hold the pictureLabel and the buttons
		Box vbox = Box.createVerticalBox(); 
		vbox.add(Box.createVerticalStrut(30));
		vbox.add(picLabel);
		vbox.add(Box.createVerticalStrut(50));
		getContentPane().add(vbox, BorderLayout.CENTER);
		
		PreviousButton = new JButton();
		PreviousButton.setToolTipText("Previous");
		PreviousButton.setText("");
		Image prevArrow = new ImageIcon(this.getClass().getResource("/left-arrow.png")).getImage();
		
		PreviousButton.setIcon(new ImageIcon(prevArrow));
		PreviousButton.setIconTextGap(10); // Distance between the icon and text is 10
		PreviousButton.addActionListener(new ActionListener() { 
																				
			public void actionPerformed(ActionEvent evt) {
				PreviousButtonActionPerformed(evt);
			}
		});
		NextButton = new JButton();
		NextButton.setBackground(new Color(240, 240, 240));
		NextButton.setToolTipText("Next");
		NextButton.setPreferredSize(PreviousButton.getPreferredSize());
		NextButton.setText("");
		Image nextArrow = new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		
		NextButton.setIcon(new ImageIcon(nextArrow));
		NextButton.setHorizontalTextPosition(SwingConstants.LEFT);
		NextButton.setIconTextGap(10); // Distance between the icon and text is 10
		NextButton.addActionListener(new ActionListener() { 
																			
			public void actionPerformed(ActionEvent evt) {
				NextButtonActionPerformed(evt);
			}
		});
		JPanel prev_next_pane = new JPanel(); // Panel to hold the Previous and Next buttons.
		FlowLayout flow = new FlowLayout(FlowLayout.CENTER);
		flow.setHgap(30);
		prev_next_pane.setLayout(flow);
		prev_next_pane.add(PreviousButton);
		prev_next_pane.add(NextButton);
		prev_next_pane.setOpaque(false);
		vbox.add(prev_next_pane); // Add the panel to the verticalBox
		Toolkit kit = getToolkit();
		Dimension size = kit.getScreenSize();
		setLocation(size.width / 5, size.height / 10);
		setMinimumSize(new Dimension(900, 600));
		// setMaximumSize(new Dimension(size.width/4 + 50,size.height/4));
		// pack();
	}// END:initComponents

	/**
	 * Handler for previous button
	 */
	private void PreviousButtonActionPerformed(ActionEvent evt) {
		position--; // Decrement the index position of the array of filenames by one on
					// buttonPressed
		if (!NextButton.isEnabled()) { // if NextButton is
			NextButton.setEnabled(true); // disabled, enable it
		}
		if (position == 0) { // If we are viewing the first Picture in
			PreviousButton.setEnabled(false); // the directory, disable previous button
		}
		setLabelIcon(Path, filenames[position]);
	}// End of PreviousButton handler

	/**
	 * Handler for NextButton
	 */
	private void NextButtonActionPerformed(ActionEvent evt) {
		position++; // Increment the index position of array of filenames by one on buttonPressed
		if (!PreviousButton.isEnabled()) {
			listFiles(Path);
			PreviousButton.setEnabled(true);
		}
		if (position == filenames.length) {
			NextButton.setEnabled(false);
			position--;
			return;
		}
		setLabelIcon(Path, filenames[position]);
	}// End of NextButton handler

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/*
		 * Set the look and feel of the window
		 */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		/*
		 * Create and display the form
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainWindow().setVisible(true);
			}
		});
	}

	/**
	 * Method to list all the files in the directory And store their names in an
	 * array
	 */
	private void listFiles(String Path) {
		File file = new File(Path);
		filenames = file.list(); // store the file names in the array of strings.
		for (String names : filenames) {
			// Print the filenames to the console [temp]
			System.out.println(names); 
		}
	}

	// Method to set the picture on the label
	private void setLabelIcon(String Path, String name) {
		File file = new File(Path + "\\" + name);
		BufferedImage image = null;
		try {
			image = ImageIO.read(file); // Read the image from the file.
		} catch (IOException ie) {
			JOptionPane.showMessageDialog(this, "Error reading image file", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		ImageIcon icon = new ImageIcon(image);
		// Scales the images to desired size
		int width = image.getWidth();
		int height = image.getHeight();
		Image img = icon.getImage().getScaledInstance(width / 4, height / 4, Image.SCALE_SMOOTH);
		
		// Create a new imageicon from an image object.																									
		ImageIcon newIcon = new ImageIcon(img);
		
		// Caption using filenames
		String pictureName = file.getName();
		int pos = pictureName.lastIndexOf("."); // This removes the extensions
		String caption = pictureName.substring(0, pos); // from the file names. e.g .gif, .jpg, .png
		picLabel.setIcon(newIcon); // Set the imageIcon on the Label
		picLabel.setText(caption); // Set the caption
		
		// Caption appears below the image
		picLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
	}

}
