package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.Client;

public class Fun extends JFrame {

	private JPanel contentPane;
	private static Fun frame = new Fun();

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

	public Fun() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 1, 10, 10));
		
		JLabel lblNewLabel = new JLabel("Welcome To The Booking System");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
		contentPane.add(buttonPanel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCreateNewBooking = new JButton("Create New Booking");
		btnCreateNewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				BookingCreationScreen bcs = BookingCreationScreen.getInstance();
				bcs.setVisible(true);
				frame.setVisible(false);
			}
		});
		buttonPanel.add(btnCreateNewBooking);
		
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
		buttonPanel.add(btnEditBooking);
		
		JButton btnViewBooking = new JButton("View Your Booking");
		btnViewBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewBookingScreen cbs = viewBookingScreen.getInstance();
				cbs.setVisible(true);
				frame.setVisible(false);
			}
		});
		buttonPanel.add(btnViewBooking);
		
		JButton btnCancelBooking = new JButton("Cancel Booking");
		btnCancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areYouSureCancelScreen ays = areYouSureCancelScreen.getInstance();
				ays.setVisible(true);
				frame.setVisible(false);
			}
		});
		buttonPanel.add(btnCancelBooking);
		
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
		btnSignOut.setFont(new Font("Segoe UI", Font.BOLD, 14));
		contentPane.add(btnSignOut);
		
		contentPane.setBackground(Color.WHITE);
		buttonPanel.setBackground(Color.WHITE);
	}
	
	public static Fun getInstance() {
		return frame;
	}
}
