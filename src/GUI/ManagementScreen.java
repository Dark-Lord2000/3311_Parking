package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementScreen extends JFrame {

	private JPanel contentPane;
	private static ManagementScreen frame = new ManagementScreen();;

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
	public ManagementScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Management");
		lblNewLabel.setFont(new Font("Lao MN", Font.BOLD, 18));
		lblNewLabel.setBounds(157, 23, 125, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblGentxt = new JLabel("");
		lblGentxt.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblGentxt.setBounds(156, 223, 211, 21);
		contentPane.add(lblGentxt);
		
		JLabel lblGettxt2 = new JLabel("");
		lblGettxt2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblGettxt2.setBounds(157, 240, 274, 16);
		contentPane.add(lblGettxt2);
		
		JLabel lblGentxt3 = new JLabel("");
		lblGentxt3.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblGentxt3.setBounds(157, 256, 210, 16);
		contentPane.add(lblGentxt3);
		
		JButton btnEditLots = new JButton("Edit Parking Lots");
		btnEditLots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGentxt.setText("");
				lblGettxt2.setText("");
				lblGentxt3.setText("");
				editParkingLotsScreen eps = editParkingLotsScreen.getInstance();
				eps.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEditLots.setBounds(146, 64, 136, 39);
		contentPane.add(btnEditLots);
		
		JButton btnEditSpaces = new JButton("Edit Parking Spaces");
		btnEditSpaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGentxt.setText("");
				lblGettxt2.setText("");
				lblGentxt3.setText("");
				editExistingSpaceScreen eps = editExistingSpaceScreen.getInstance();
				eps.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEditSpaces.setBounds(146, 115, 136, 39);
		contentPane.add(btnEditSpaces);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblGentxt.setText("");
				lblGettxt2.setText("");
				lblGentxt3.setText("");
				Design2 ds2 = Design2.getInstance();
				System1.currentUser = null;
				ds2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSignOut.setBounds(23, 28, 88, 29);
		contentPane.add(btnSignOut);
		
		JButton btnGenerateAccount = new JButton("Generate Account");
		btnGenerateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (System1.currentUser.getType().equalsIgnoreCase("super manager")) {
					SuperManager superM = (SuperManager) System1.currentUser;
					Manager newManager = superM.generateAccount();
					lblGentxt.setText("Account Generated!");
					lblGettxt2.setText("Email: " + newManager.getEmail());
					lblGentxt3.setText("Password: " + newManager.getPassword());
					
				}
				else {
					lblGentxt.setText("");
					lblGettxt2.setText("Only Super Managers Can Generate Accounts");
					lblGentxt3.setText("");
				}
			}
		});
		btnGenerateAccount.setBounds(146, 166, 136, 39);
		contentPane.add(btnGenerateAccount);
		
		
	}
	
	public static ManagementScreen getInstance() {
		return frame;
	}
}
