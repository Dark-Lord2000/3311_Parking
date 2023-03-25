package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class paymentInquiries extends JFrame {

	private JPanel contentPane;
	private static paymentInquiries frame = new paymentInquiries();

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
	public paymentInquiries() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Payment Inquiries");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(131, 27, 194, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnAccountPaymentDetails = new JButton("Account Payment Details");
		btnAccountPaymentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPaymentDetailsScreen apds = accountPaymentDetailsScreen.getInstance();
				apds.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAccountPaymentDetails.setBounds(131, 64, 201, 43);
		contentPane.add(btnAccountPaymentDetails);
		
		JButton btnAddFunds = new JButton("Add Funds");
		btnAddFunds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentTypeScreen pts = paymentTypeScreen.getInstance();
				pts.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAddFunds.setBounds(131, 107, 201, 43);
		contentPane.add(btnAddFunds);
		
		JButton btnPayDebt = new JButton("Pay Debt");
		btnPayDebt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payDebtScreen pds = payDebtScreen.getInstance();
				pds.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnPayDebt.setBounds(131, 150, 201, 39);
		contentPane.add(btnPayDebt);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpConfirmed suc = SignUpConfirmed.getInstance();
				suc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 29, 87, 29);
		contentPane.add(btnBack);
		
	}
	
	public static paymentInquiries getInstance() {
		return frame;
	}
}
