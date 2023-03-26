package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentVerificationScreen extends JFrame {

	private JPanel contentPane;
	private static studentVerificationScreen frame = new studentVerificationScreen();
	private JTextField textField_ID;
	private JButton btnSubmit;
	private JButton btnBack;
	private JLabel lblNewLabel_1;

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
	public studentVerificationScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Student Number");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(111, 32, 235, 32);
		contentPane.add(lblNewLabel);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(111, 107, 235, 26);
		contentPane.add(textField_ID);
		textField_ID.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(111, 233, 235, 16);
		contentPane.add(lblNewLabel_1);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_ID.getText().length() == 9) {
					lblNewLabel_1.setText("");
					textField_ID.setText("");
					System1.maintain.users.add(System1.currentUser);
					try {System1.maintain.update("/Users/matt/eclipse-workspace/T007_project_deliverable_II/users.csv");
					
					} catch (Exception x) {
						x.printStackTrace();
					}
					SignUpConfirmed suc = SignUpConfirmed.getInstance();
					suc.setVisible(true);
					frame.setVisible(false);
				}
				else {
					lblNewLabel_1.setText("Invalid Student ID");
				}
			}
		});
		btnSubmit.setBounds(166, 178, 117, 43);
		contentPane.add(btnSubmit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountCreationScreen acs = accountCreationScreen.getInstance();
				textField_ID.setText("");
				acs.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(15, 38, 84, 29);
		contentPane.add(btnBack);
		
	}
	
	public static studentVerificationScreen getInstance() {
		return frame;
	}
}
