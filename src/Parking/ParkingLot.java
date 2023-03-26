package Parking;
import Users.*;
import java.util.HashMap;
import java.util.Map;
import App.System1;
import Utilities.Sensor;

public class ParkingLot {
	
	//Class variables
	public static int totalLots = 0;
	private Map<ParkingSpace, Client> spaceList;
	private int lotNumber;
	private boolean enabled;
	
	/**
	 * Constructor
	 */
	public ParkingLot() {
		this.spaceList = new HashMap<>();
		this.lotNumber = totalLots;
		for (int i=1; i<101; i++) {
			//ParkingSpace space = new ParkingSpace(i, this, new Sensor(), this.lotNumber);
			ParkingSpace space = new ParkingSpace.Builder().spaceNum(i).inLot(this).sensor(new Sensor()).location(this.lotNumber).build();
			spaceList.put(space, null);
			System1.addParkingSpace(space);
		}
		this.enabled = true;
		totalLots += 1;
		System1.addLot(this);
	}
	
	
	/**
	 * This method checks if the parking lot is enabled
	 * @return returns true if the parking lot is enabled
	 */
	public boolean isEnabled() {
		return this.enabled;
	}
	
	
	/**
	 * This method returns the lot number of this parking lot
	 * @return returns an int relating the lot number of this parking lot
	 */
	public int getLotNumber() {
		return this.lotNumber;
	}
	
	
	/**
	 * This method enabled the parking lot
	 */
	public void enable() {
		this.enabled = true;
	}
	
	/**
	 * This method disables the parking lot
	 */
	public void disable() {
		this.enabled = false;
	}
	
	public Map<ParkingSpace, Client> getSpaceList(){
		return this.spaceList;
	}
	
	public ParkingSpace getParkingSpace(int spaceNumber) {
		for (ParkingSpace space : this.spaceList.keySet()) {
			if (space.getSpaceNumber() == spaceNumber) {
				return space;
			}
		}
		return null;
	}
}
