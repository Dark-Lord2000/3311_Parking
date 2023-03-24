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

public class BookingConfirmedScreen extends JFrame {

	private JPanel contentPane;
	private static BookingConfirmedScreen frame = new BookingConfirmedScreen();
	
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
	public BookingConfirmedScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Confirmed!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(117, 45, 212, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Back To Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUpConfirmed suc = SignUpConfirmed.getInstance();
				suc.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(147, 223, 151, 29);
		contentPane.add(btnNewButton);
	}
	
	public static BookingConfirmedScreen getInstance() {
		return frame;
	}

}
