package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bookingErrorScreen extends JFrame {

	private JPanel contentPane;
	private static bookingErrorScreen frame = new bookingErrorScreen();

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
	public bookingErrorScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingCreationScreen bcs = BookingCreationScreen.getInstance();
				bcs.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(26, 26, 117, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Error in creating the booking. Either the space is occupied,");
		lblNewLabel.setBounds(36, 67, 392, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblTheParkingSpace = new JLabel("the parking space is disabled, or your chosen time is ");
		lblTheParkingSpace.setBounds(36, 108, 392, 29);
		contentPane.add(lblTheParkingSpace);
		
		JLabel lblIncorrectClickBack = new JLabel("incorrect. Click Back to try again.");
		lblIncorrectClickBack.setBounds(36, 149, 392, 29);
		contentPane.add(lblIncorrectClickBack);
	}
	
	public static bookingErrorScreen getInstance() {
		return frame;
	}
}
