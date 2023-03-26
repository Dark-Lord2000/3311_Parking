package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.Client;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class paypalScreen extends JFrame {

	private JPanel contentPane;
	private static paypalScreen frame = new paypalScreen();
	private JTextField textField;
	private JTextField textField_1;

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
	public paypalScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pay With PayPal");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 31, 170, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Enter PayPal Email:");
		lblEmail.setBounds(61, 93, 129, 16);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Enter PayPal Password:");
		lblNewLabel_1.setBounds(61, 121, 155, 16);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(214, 88, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(214, 116, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDisplay = new JLabel("");
		lblDisplay.setBounds(88, 243, 268, 16);
		contentPane.add(lblDisplay);
		
		JButton btn5 = new JButton("Add $5.00");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				client.addFunds(5.00, "paypal");
				lblDisplay.setText("$5.00 Added! Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btn5.setBounds(34, 192, 117, 39);
		contentPane.add(btn5);
		
		JButton btn10 = new JButton("Add $10.00");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				client.addFunds(10.00, "paypal");
				lblDisplay.setText("$10.00 Added! Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btn10.setBounds(163, 192, 117, 39);
		contentPane.add(btn10);
		
		JButton btn20 = new JButton("Add $20.00");
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				client.addFunds(20.00, "paypal");
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
		
	}
	
	public static paypalScreen getInstance() {
		return frame;
	}
}
