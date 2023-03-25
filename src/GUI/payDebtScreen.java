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

public class payDebtScreen extends JFrame {

	private JPanel contentPane;
	private static payDebtScreen frame = new payDebtScreen();

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
	public payDebtScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pay Debt");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(178, 32, 105, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(89, 87, 301, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentInquiries pi = paymentInquiries.getInstance();
				lblNewLabel_1.setText("");
				pi.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 34, 82, 29);
		contentPane.add(btnBack);
		
		JButton btnPayDebt = new JButton("Pay Debt");
		btnPayDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				if(client.getBooking() == null) {
					lblNewLabel_1.setText("No Booking Exists!");
				}
				else {
					if(client.payBooking()) {
						lblNewLabel_1.setText("Payment Confirmed! Current Balance: " + String.format("%.2f", client.getBalance()));
					}
					else {
						if(client.getBooking().getPaid()) {
							lblNewLabel_1.setText("Booking Already Paid! Current Balance: " + String.format("%.2f", client.getBalance()));
						}
						else {
							lblNewLabel_1.setText("Not Enough Funds! Current Balance: " + String.format("%.2f", client.getBalance()));
						}
					}
				}
			}
		});
		btnPayDebt.setBounds(166, 213, 117, 29);
		contentPane.add(btnPayDebt);
		
		
	}
	
	public static payDebtScreen getInstance() {
		return frame;
	}

}
