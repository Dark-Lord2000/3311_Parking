package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Parking.ParkingLot;
import Users.Manager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addParkingLotScreen extends JFrame {

	private JPanel contentPane;
	private static addParkingLotScreen frame = new addParkingLotScreen();

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
	public addParkingLotScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Parking Lot");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(134, 30, 179, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(24, 231, 399, 16);
		contentPane.add(lblNewLabel_3);
		
		JButton btnAddLot = new JButton("Add Lot");
		btnAddLot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Manager m = (Manager) System1.currentUser;
				m.addParkingLot();
				lblNewLabel_3.setText("Parking Lot Created With Lot Number: " + (ParkingLot.totalLots- 1));
			}
		});
		btnAddLot.setBounds(158, 114, 136, 76);
		contentPane.add(btnAddLot);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Design2 ds2 = Design2.getInstance();
				System1.currentUser = null;
				lblNewLabel_3.setText("");
				ds2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSignOut.setBounds(325, 40, 98, 29);
		contentPane.add(btnSignOut);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementScreen ms = ManagementScreen.getInstance();
				lblNewLabel_3.setText("");
				frame.setVisible(false);
				ms.setVisible(true);
			}
		});
		btnBack.setBounds(24, 40, 98, 29);
		contentPane.add(btnBack);
		
	}
	
	public static addParkingLotScreen getInstance() {
		return frame;
	}
}
