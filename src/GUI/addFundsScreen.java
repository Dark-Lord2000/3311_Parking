package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class addFundsScreen extends JFrame {

	private JPanel contentPane;
	private static addFundsScreen frame = new addFundsScreen();
	private JTextField textField_CardNumber;
	private JTextField textField_CCV;
	private JTextField textField_exp;

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
	public addFundsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Funds");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(166, 30, 114, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblDisplay = new JLabel("");
		lblDisplay.setBounds(88, 243, 268, 16);
		contentPane.add(lblDisplay);
		
		JButton btn5 = new JButton("Add $5.00");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				client.addFunds(5.00);
				lblDisplay.setText("$5.00 Added! Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btn5.setBounds(34, 192, 117, 39);
		contentPane.add(btn5);
		
		JButton btn10 = new JButton("Add $10.00");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				String cardNumber = textField_CardNumber.getText();
				String CCV = textField_CCV.getText();
				String exp = textField_exp.getText();
				client.setCardNumber(cardNumber);
				client.setCCV(CCV);
				client.setExpiryDate(exp);
				client.addFunds(10.00);
				lblDisplay.setText("$10.00 Added! Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btn10.setBounds(163, 192, 117, 39);
		contentPane.add(btn10);
		
		JButton btn20 = new JButton("Add $20.00");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				client.addFunds(20.00);
				lblDisplay.setText("$20.00 Added! Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btn20.setBounds(292, 192, 117, 39);
		contentPane.add(btn20);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentInquiries pi = paymentInquiries.getInstance();
				lblDisplay.setText("");
				pi.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(20, 26, 89, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Select Payment Type:");
		lblNewLabel_1.setBounds(31, 88, 138, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Card Number:");
		lblNewLabel_2.setBounds(31, 116, 138, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_CardNumber = new JTextField();
		textField_CardNumber.setBounds(184, 111, 225, 26);
		contentPane.add(textField_CardNumber);
		textField_CardNumber.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CCV:");
		lblNewLabel_3.setBounds(34, 144, 40, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Expiry Date:");
		lblNewLabel_4.setBounds(34, 169, 89, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_CCV = new JTextField();
		textField_CCV.setBounds(184, 139, 130, 26);
		contentPane.add(textField_CCV);
		textField_CCV.setColumns(10);
		
		textField_exp = new JTextField();
		textField_exp.setBounds(184, 164, 130, 26);
		contentPane.add(textField_exp);
		textField_exp.setColumns(10);
		
		String[] options = {"Visa Debit", "Mastercard", "Visa Credit" };
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setBounds(181, 84, 228, 27);
		contentPane.add(comboBox_Type);
		
	}
	
	public static addFundsScreen getInstance() {
		return frame;
	}
}
