package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.Client;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewBookingScreen extends JFrame {

	private JPanel contentPane;
	private static viewBookingScreen frame = new viewBookingScreen();

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
	public viewBookingScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(65, 130, 347, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(64, 158, 348, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(65, 186, 347, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(65, 102, 347, 16);
		contentPane.add(lblNewLabel_1);
		
		JButton btnViewBooking = new JButton("View Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				if (client.getBooking() == null) {
					lblNewLabel_1.setText("You Currently Have No Bookings");
				}
				else {
					lblNewLabel_1.setText("Parking Lot Number: " + client.getBooking().getParkingSpace().getLocation());
					lblNewLabel_2.setText("Parking Space Number: " + client.getBooking().getParkingSpace().getSpaceNumber());
					lblNewLabel_3.setText("Starting At: " + client.getBooking().toStringStarting());
					lblNewLabel_4.setText("Ending At: " + client.getBooking().toStringEnding());
				}
			}
		});
		btnViewBooking.setBounds(161, 214, 128, 46);
		contentPane.add(btnViewBooking);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
				lblNewLabel_4.setText("");
				SignUpConfirmed suc = SignUpConfirmed.getInstance();
				suc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(16, 19, 90, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("View Your Booking");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 50, 217, 29);
		contentPane.add(lblNewLabel);
		
		
		
	}
	
	public static viewBookingScreen getInstance() {
		return frame;
	}

}
