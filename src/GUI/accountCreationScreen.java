package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import Users.*;
import App.System1;

public class accountCreationScreen extends JFrame {

	private JPanel accountCreationPanel;
	private JTextField textField_email;
	private JTextField textField_password;
	static accountCreationScreen frame = new accountCreationScreen();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public accountCreationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		accountCreationPanel = new JPanel();
		accountCreationPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(accountCreationPanel);
		accountCreationPanel.setLayout(null);
		
		JLabel lblEnterEmail = new JLabel("Enter Email:");
		lblEnterEmail.setBounds(25, 100, 88, 16);
		accountCreationPanel.add(lblEnterEmail);
		
		JLabel lblWeakPassword = new JLabel("");
		lblWeakPassword.setBounds(25, 245, 419, 16);
		accountCreationPanel.add(lblWeakPassword);
		
		textField_email = new JTextField();
		textField_email.setBounds(140, 95, 261, 26);
		accountCreationPanel.add(textField_email);
		textField_email.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(25, 138, 106, 16);
		accountCreationPanel.add(lblEnterPassword);
		
		textField_password = new JTextField();
		textField_password.setBounds(140, 133, 261, 26);
		accountCreationPanel.add(textField_password);
		textField_password.setColumns(10);
		
		JLabel lblWhatAreYou = new JLabel("What Are You?");
		lblWhatAreYou.setBounds(25, 175, 96, 16);
		accountCreationPanel.add(lblWhatAreYou);
		
		String[] options = {"Visitor", "Faculty", "Non-Faculty Staff", "Student", "Manager", "Super Manager"};
		JComboBox<String> comboBox = new JComboBox<String>(options);
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(140, 171, 261, 27);
		accountCreationPanel.add(comboBox);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_email.getText().toLowerCase();
				String password = textField_password.getText();
				String type = (String) comboBox.getSelectedItem();
				UserFactory factory = UserFactory.getInstance();
				User user = factory.createUser(email, password, type);
				
					if (user == null) {
						lblWeakPassword.setText("Weak Password");
					}
					
					else {
				
					
					//Set new screen
					if (type.equalsIgnoreCase("manager") || type.equalsIgnoreCase("super manager")) {
						System1.currentUser = user;
						ManagementScreen ms = ManagementScreen.getInstance();
						ms.setVisible(true);
						frame.setVisible(false);
					}
					else {
						System1.currentUser = (Client) user;
						SignUpConfirmed suc = SignUpConfirmed.getInstance();
						suc.setVisible(true);
						frame.setVisible(false);
					}
					
					}
				
			}
		});
		btnSignUp.setBounds(164, 210, 117, 29);
		accountCreationPanel.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(149, 34, 152, 26);
		accountCreationPanel.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblWeakPassword.setText("");
				Design2 ds2 = Design2.getInstance();
				ds2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(14, 16, 117, 29);
		accountCreationPanel.add(btnBack);
		
		
	}
	
	public static accountCreationScreen getInstance() {
		return frame;
	}
	
	public JTextField getEmail() {
		return textField_email;
	}
	
	public JTextField getPassword() {
		return textField_password;
	}
}
