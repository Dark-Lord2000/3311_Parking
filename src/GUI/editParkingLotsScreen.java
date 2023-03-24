package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editParkingLotsScreen extends JFrame {

	private JPanel contentPane;
	private static editParkingLotsScreen frame = new editParkingLotsScreen();;

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
	public editParkingLotsScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditLot = new JButton("Edit Existing Lot");
		btnEditLot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editExistingLotScreen eels = editExistingLotScreen.getInstance();
				eels.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnEditLot.setBounds(154, 68, 136, 57);
		contentPane.add(btnEditLot);
		
		JButton btnAddLot = new JButton("Add Parking Lot");
		btnAddLot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addParkingLotScreen apls = addParkingLotScreen.getInstance();
				apls.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnAddLot.setBounds(154, 147, 136, 57);
		contentPane.add(btnAddLot);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementScreen ms = ManagementScreen.getInstance();
				ms.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(19, 20, 88, 29);
		contentPane.add(btnBack);
	}
	
	public static editParkingLotsScreen getInstance() {
		return frame;
	}

}
