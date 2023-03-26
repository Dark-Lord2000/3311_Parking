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

public class paymentTypeScreen extends JFrame {

	private JPanel contentPane;
	private static paymentTypeScreen frame = new paymentTypeScreen();

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
	public paymentTypeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Payment Type");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 19));
		lblNewLabel.setBounds(127, 35, 207, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnPaypal = new JButton("Paypal");
		btnPaypal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paypalScreen ps = paypalScreen.getInstance();
				ps.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnPaypal.setBounds(160, 84, 117, 52);
		contentPane.add(btnPaypal);
		
		JButton btnDebit = new JButton("Debit/Credit");
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFundsScreen afs = addFundsScreen.getInstance();
				afs.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnDebit.setBounds(160, 148, 117, 46);
		contentPane.add(btnDebit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentInquiries pi = paymentInquiries.getInstance();
				pi.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 36, 84, 29);
		contentPane.add(btnBack);
	}
	
	public static paymentTypeScreen getInstance() {
		return frame;
	}
}
