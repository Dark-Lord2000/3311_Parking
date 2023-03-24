package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import App.System1;
import Users.Manager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class editExistingSpaceScreen extends JFrame {

	private JPanel contentPane;
	private static editExistingSpaceScreen frame = new editExistingSpaceScreen();
	private JTextField textField_LotNumber;
	private JTextField textField_SpaceNumber;

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
	public editExistingSpaceScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Existing Parking Space");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(81, 32, 296, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Parking Lot Number:");
		lblNewLabel_1.setBounds(36, 93, 140, 16);
		contentPane.add(lblNewLabel_1);
		
		textField_LotNumber = new JTextField();
		textField_LotNumber.setBounds(200, 88, 130, 26);
		contentPane.add(textField_LotNumber);
		textField_LotNumber.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Parking Space Number:");
		lblNewLabel_2.setBounds(36, 136, 157, 16);
		contentPane.add(lblNewLabel_2);
		
		textField_SpaceNumber = new JTextField();
		textField_SpaceNumber.setBounds(200, 131, 130, 26);
		contentPane.add(textField_SpaceNumber);
		textField_SpaceNumber.setColumns(10);
		
		String[] status = {"enabled", "disabled"};
		JComboBox comboBox = new JComboBox(status);
		comboBox.setBounds(200, 169, 130, 27);
		contentPane.add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editParkingLotsScreen epls = editParkingLotsScreen.getInstance();
				textField_SpaceNumber.setText("");
				textField_LotNumber.setText("");
				epls.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 34, 75, 29);
		contentPane.add(btnBack);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System1.currentUser = null;
				Design2 d2 = Design2.getInstance();
				textField_SpaceNumber.setText("");
				textField_LotNumber.setText("");
				d2.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnSignOut.setBounds(6, 232, 117, 29);
		contentPane.add(btnSignOut);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(36, 176, 61, 16);
		contentPane.add(lblStatus);
		
		JButton btnEditSpace = new JButton("Edit Space");
		btnEditSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lotNumber = Integer.parseInt(textField_LotNumber.getText());
				int spaceNumber = Integer.parseInt(textField_SpaceNumber.getText());
				String status = (String) comboBox.getSelectedItem();
				if (status.equalsIgnoreCase("enabled")) {
					Manager m = (Manager) System1.currentUser;
					if (System1.getParkingSpace(spaceNumber, lotNumber) != null) {
						m.enableParkingSpace(System1.getParkingSpace(spaceNumber, lotNumber));
					}
				}
				else {
					Manager m = (Manager) System1.currentUser;
					if (System1.getParkingSpace(spaceNumber, lotNumber) != null) {
						m.disableParkingSpace(System1.getParkingSpace(spaceNumber, lotNumber));
					}
				}
			}
		});
		btnEditSpace.setBounds(172, 219, 117, 42);
		contentPane.add(btnEditSpace);
		
	}
	
	public static editExistingSpaceScreen getInstance() {
		return frame;
	}
}
