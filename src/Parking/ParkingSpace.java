package Parking;
import Utilities.Sensor;

public class ParkingSpace {
	
	//Class variables
	private int spaceNum;
	private ParkingLot inLot;
	private boolean enabled;
	private Sensor sensor;
	private boolean booked;
	private int location;
	
	/**
	 * Constructor
	 * @param spaceNum is an int corresponding to the parking space number
	 * @param inLot is a ParkingLot object which this ParkingSpace is in
	 * @param sensor is a Sensor object corresponding to the parking spaces sensor 
	 * @param location is a String corresponding to the parking location
	 */
	public ParkingSpace(int spaceNum, ParkingLot inLot, Sensor sensor, int location) {
		this.spaceNum = spaceNum;
		this.inLot = inLot;
		this.sensor = sensor;
		this.location = location;
		this.booked = false;
		this.enabled = true;
	}
	
	/*
	 * Get methods
	 */
	
	/**
	 * This method returns the space number of this parking space
	 * @return returns an int that corresponds to this parking space
	 */
	public int getSpaceNumber() {
		return this.spaceNum;
	}
	
	/**
	 * This method returns the Parking Lot that this parking space in in
	 * @return returns a ParkingLot object that corresponds to this parking space
	 */
	public ParkingLot getParkingLot() {
		return this.inLot;
	}
	
	/**
	 * This method returns the sensor for this parking space
	 * @return returns a Sensor object associated with this ParkingSpace
	 */
	public Sensor getSensor() {
		return this.sensor;
	}
	
	/**
	 * This method returns the location for this parking space
	 * @return returns a String object associated with the location of this ParkingSpace
	 */
	public int getLocation() {
		return this.location;
	}
	
	/**
	 * This method checks if this parking space is booked
	 * @return returns true if this ParkingSpace is booked, false otherwise
	 */
	public boolean isBooked() {
		return this.booked;
	}
	
	/**
	 * This method checks if this parking space is enabled
	 * @return returns true if this ParkingSpace is enabled, false otherwise
	 */
	public boolean isEnabled() {
		return this.enabled;
	}
	
	/*
	 * Set methods
	 */
	
	/**
	 * This method enables this parking space
	 */
	public void enable() {
		this.enabled = true;
	}
	
	/**
	 * This method disables this parking space
	 */
	public void disable() {
		this.enabled = false;
	}
	
	/**
	 * This method either books or unbooks this parking space
	 * @param book is a boolean corresponding to if this parking space is booked or not
	 */
	public void setBooked(boolean book) {
		this.booked = book;
	}
	
}
