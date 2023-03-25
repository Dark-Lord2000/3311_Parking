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

public class accountPaymentDetailsScreen extends JFrame {

	private JPanel contentPane;
	private static accountPaymentDetailsScreen frame = new accountPaymentDetailsScreen();

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
	public accountPaymentDetailsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Payment Details");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(100, 28, 278, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurrentBalance = new JLabel("");
		lblCurrentBalance.setBounds(81, 83, 328, 16);
		contentPane.add(lblCurrentBalance);
		
		JLabel lblDebt = new JLabel("");
		lblDebt.setBounds(81, 111, 297, 16);
		contentPane.add(lblDebt);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(81, 139, 297, 16);
		contentPane.add(lblCard);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDebt.setText("");
				lblCard.setText("");
				lblCurrentBalance.setText("");
				paymentInquiries pi = paymentInquiries.getInstance();
				pi.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 30, 85, 29);
		contentPane.add(btnBack);
		
		JButton btnDisplay = new JButton("Display Details");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				lblCard.setText("Card On File: " + client.getCardNumber());
				if (!(client.getBooking() == null)) {
					lblDebt.setText("Amount Due: $" + String.format("%.2f", client.getBooking().getBill()));
				}
				lblCurrentBalance.setText("Current Balance: $" + String.format("%.2f", client.getBalance()));
			}
		});
		btnDisplay.setBounds(162, 210, 117, 46);
		contentPane.add(btnDisplay);
		
		
	}
	
	public static accountPaymentDetailsScreen getInstance() {
		return frame;
	}
}
