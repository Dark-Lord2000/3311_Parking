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

public class SignUpConfirmed extends JFrame {

	private JPanel contentPane;
	private static SignUpConfirmed frame = new SignUpConfirmed();
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
	public SignUpConfirmed() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To The Booking System");
		lblNewLabel.setFont(new Font("Lao MN", Font.PLAIN, 20));
		lblNewLabel.setBounds(62, 22, 338, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(139, 211, 192, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnEditBooking = new JButton("Edit Booking");
		btnEditBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				if (client.getBooking() != null) {
					editBookingScreen ebs = editBookingScreen.getInstance();
					ebs.setVisible(true);
					frame.setVisible(false);
				}
				else {
					lblNewLabel_1.setText("No Existing Booking");
				}
			}
		});
		btnEditBooking.setBounds(139, 96, 170, 35);
		contentPane.add(btnEditBooking);
		
		JButton btnCreateNewBooking = new JButton("Create New Booking");
		btnCreateNewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				BookingCreationScreen bcs = BookingCreationScreen.getInstance();
				bcs.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCreateNewBooking.setBounds(139, 62, 170, 35);
		contentPane.add(btnCreateNewBooking);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				Design2 ds2 = Design2.getInstance();
				System1.currentUser = null;
				ds2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSignOut.setBounds(169, 229, 117, 29);
		contentPane.add(btnSignOut);
		
		JButton btnViewBooking = new JButton("View Your Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBookingScreen cbs = viewBookingScreen.getInstance();
				cbs.setVisible(rootPaneCheckingEnabled);
				frame.setVisible(false);
			}
		});
		btnViewBooking.setBounds(139, 131, 170, 35);
		contentPane.add(btnViewBooking);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areYouSureCancelScreen ays = areYouSureCancelScreen.getInstance();
				ays.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCancelBooking.setBounds(139, 164, 171, 35);
		contentPane.add(btnCancelBooking);
		
	}
	
	public static SignUpConfirmed getInstance() {
		return frame;
	}
}
