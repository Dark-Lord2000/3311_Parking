package Users;
import App.System1;
import Parking.*;

public class Manager extends User{
	
	public Manager(String email, String password, String type) {
			super(email, password, type);
	}
	
	/*
	 * Methods
	 */
	
	/**
	 * This method creates and adds a parking lot
	 * @param lot is the ParkingLot object to be added
	 */
	public void addParkingLot() {
		ParkingLot newLot = new ParkingLot();
	}
	
	/**
	 * This method enables a parking lot
	 * @param lot is the ParkingLot object to be enabled
	 */
	public void enableParkingLot(ParkingLot lot) {
		lot.enable();
	}
	
	/**
	 * This method disables a parking lot
	 * @param lot is the ParkingLot object to be disabled
	 */
	public void disableParkingLot(ParkingLot lot) {
		lot.disable();
	}
	
	/**
	 * This method enables a parking space
	 * @param spot is the ParkingSpace object to be enabled
	 */
	public void enableParkingSpace(ParkingSpace spot) {
		spot.enable();
	}
	
	/**
	 * This method disables a parking space
	 * @param spot is the ParkingSpace object to be disabled
	 */
	public void disableParkingSpace(ParkingSpace spot) {
		spot.disable();
	}
	/**
	 * This method validates the Client
	 * @param client is the Client object to be validated
	 * @return returns true if the Client validation is successful, false otherwise
	 */
	public boolean validateUser(Client client) {
		if (!client.getType().equals("visitor")) {
			return true;
		}
		return false;
	}
	
}
