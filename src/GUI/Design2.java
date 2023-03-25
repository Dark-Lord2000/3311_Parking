package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Design2 extends JFrame {

	private JPanel mainScreen;
	static Design2 frame = new Design2();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Design2 frame = new Design2();
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
	public Design2() {
		setTitle("Book Your Parking Spot");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		mainScreen = new JPanel();
		mainScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainScreen);
		mainScreen.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInScreen sis = signInScreen.getInstance();
				sis.getEmail().setText("");
				sis.getPassword().setText("");
				sis.getLabel().setText("");
				sis.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(156, 81, 140, 43);
		mainScreen.add(btnNewButton);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountCreationScreen acs = accountCreationScreen.getInstance();
				acs.getEmail().setText("");
				acs.getPassword().setText("");
				acs.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCreateAccount.setBounds(156, 160, 140, 43);
		mainScreen.add(btnCreateAccount);
	}
	
	public static Design2 getInstance() {
		return frame;
	}
	
}
