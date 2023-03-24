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

public class areYouSureCancelScreen extends JFrame {

	private JPanel contentPane;
	private static areYouSureCancelScreen frame = new areYouSureCancelScreen();

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
	public areYouSureCancelScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(62, 217, 347, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(82, 246, 285, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Are You Sure You Want To Cancel?");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(66, 41, 333, 29);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Yes, Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client client = (Client) System1.currentUser;
				if (client.getBooking() == null) {
					lblNewLabel_1.setText("You Currently Have No Bookings To Cancel!");
				}
				else {
					int lotNum = client.getBooking().getParkingSpace().getLocation();
					int spaceNum = client.getBooking().getParkingSpace().getSpaceNumber();
					String date = client.getBooking().toStringStarting();
					client.cancelBooking();
					lblNewLabel_1.setText("Booking For Parking Lot " + lotNum
											+ ", and Parking Space " + spaceNum);
					lblNewLabel_2.setText("At Time " + date + " Is Now Cancelled");
				}
			}
		});
		btnNewButton.setBounds(156, 110, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("No, Go Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("");
				lblNewLabel_2.setText("");
				SignUpConfirmed suc = SignUpConfirmed.getInstance();
				suc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(156, 162, 117, 29);
		contentPane.add(btnBack);
		
		
	}
	
	public static areYouSureCancelScreen getInstance() {
		return frame;
	}

}
