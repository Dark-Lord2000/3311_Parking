package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import App.System1;
import Users.Manager;
import Parking.ParkingLot;

public class editExistingLotScreen extends JFrame {

	private JPanel contentPane;
	private static editExistingLotScreen frame = new editExistingLotScreen();;
	private JTextField textField_LotNumber;

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
	public editExistingLotScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Lot Number:");
		lblNewLabel.setBounds(49, 112, 123, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblB = new JLabel("");
		lblB.setBounds(83, 242, 268, 16);
		contentPane.add(lblB);
		
		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setBounds(49, 154, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		String[] status = {"Enabled", "Disabled"};
		
		JComboBox comboBoxStatus = new JComboBox(status);
		comboBoxStatus.setBounds(174, 150, 130, 27);
		contentPane.add(comboBoxStatus);
		
		textField_LotNumber = new JTextField();
		textField_LotNumber.setBounds(174, 107, 130, 26);
		contentPane.add(textField_LotNumber);
		textField_LotNumber.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_LotNumber.setText("");
				lblB.setText("");
				editParkingLotsScreen epls = editParkingLotsScreen.getInstance();
				epls.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(6, 22, 98, 29);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Edit Existing Lot");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_2.setBounds(143, 19, 175, 27);
		contentPane.add(lblNewLabel_2);
		
		JButton btnEditLot = new JButton("Edit Lot");
		btnEditLot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lotNumber = Integer.parseInt(textField_LotNumber.getText());
				ParkingLot lot = System1.getParkingLot(lotNumber);
				if (lot != null) {
					String comboItem = (String) comboBoxStatus.getSelectedItem();
					if (comboItem.equalsIgnoreCase("enabled")) {
						if (lot.isEnabled()) {
							lblB.setText("Lot Is Already Enabled!");
						}
						else {
							Manager m = (Manager) System1.currentUser;
							m.enableParkingLot(lot);
							lblB.setText("Lot " + lot.getLotNumber() +" Now Enabled.");
						}
					}
					else {
						if (!lot.isEnabled()) {
							lblB.setText("Lot Is Already Disabled!");
						}
						else {
							Manager m = (Manager) System1.currentUser;
							m.disableParkingLot(lot);
							lblB.setText("Lot " + lot.getLotNumber() +" Now Disabled.");
						}
					}
				}
				else {
					lblB.setText("Lot Does Not Exist!");
				}
			}
		});
		btnEditLot.setBounds(174, 189, 117, 41);
		contentPane.add(btnEditLot);
		
	}
	
	public static editExistingLotScreen getInstance() {
		return frame;
	}
}
