package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import App.System1;
import java.util.List;
import java.util.ArrayList;
import Users.*;

public class signInScreen extends JFrame {

	private JPanel signInPanel;
	private JTextField textField_email;
	private JTextField textField_password;
	private JLabel lblNewLabel;
	private JLabel lblWrongInfo;
	private JButton btnBack;
	static signInScreen frame = new signInScreen();

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
	public signInScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		signInPanel = new JPanel();
		signInPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(signInPanel);
		signInPanel.setLayout(null);
		
		JLabel lblEnterEmail = new JLabel("Enter Email:");
		lblEnterEmail.setBounds(45, 112, 89, 16);
		signInPanel.add(lblEnterEmail);
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		lblEnterPassword.setBounds(45, 150, 109, 16);
		signInPanel.add(lblEnterPassword);
		
		lblWrongInfo = new JLabel("");
		lblWrongInfo.setBounds(136, 240, 168, 16);
		signInPanel.add(lblWrongInfo);
		
		textField_email = new JTextField();
		textField_email.setBounds(161, 107, 227, 26);
		signInPanel.add(textField_email);
		textField_email.setColumns(10);
		
		textField_password = new JTextField();
		textField_password.setBounds(161, 145, 227, 26);
		signInPanel.add(textField_password);
		textField_password.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField_email.getText().toLowerCase();
				String password = textField_password.getText();
				
				System1.signIn(email, password);
				
				if (System1.currentUser == null) {
					lblWrongInfo.setText("Wrong Email Or Password!");
				}
				else {
					if (System1.currentUser instanceof Manager) {
						ManagementScreen suc = ManagementScreen.getInstance();
						suc.setVisible(true);
						frame.setVisible(false);
					}
					else {
						SignUpConfirmed suc = SignUpConfirmed.getInstance();
						suc.setVisible(true);
						frame.setVisible(false);
					}
				}
			}
		});
		btnSignIn.setBounds(161, 199, 117, 29);
		signInPanel.add(btnSignIn);
		
		lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(180, 29, 109, 26);
		signInPanel.add(lblNewLabel);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design2 ds2 = Design2.getInstance();
				ds2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(17, 31, 117, 29);
		signInPanel.add(btnBack);
		
	}
	
	public static signInScreen getInstance() {
		return frame;
	}
	
	public JTextField getEmail() {
		return textField_email;
	}
	
	public JTextField getPassword() {
		return textField_password;
	}
	
	public JLabel getLabel() {
		return lblWrongInfo;
	}
}
