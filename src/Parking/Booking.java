package Parking;
import Users.*;
import Parking.ParkingSpace;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Booking {

	//Class variables
	private Client client;
	private Date startingDate;
	private Date endingDate;
	private ParkingSpace spot;
	private double bill;
	private String licensePlate;
	
	/**
	 * The constructor
	 * @param client is the Client for this booking
	 * @param startingDate is the Date the booking will start
	 * @param endingDate is the Date the booking will end
	 * @param spot is the ParkingSpace to be booked
	 */
	public Booking(Client client, Date startingDate, Date endingDate, ParkingSpace spot, String licensePlate) {
		if (this.validateNewTimes(startingDate, endingDate) && !spot.isBooked() && spot.isEnabled()) {
			spot.setBooked(true);
			this.client = client;
			this.startingDate = startingDate;
			this.endingDate = endingDate;
			this.spot = spot;
			this.licensePlate = licensePlate;
			this.bill = this.calculateBill();
			client.setBooking(this);
		}
		else {
			this.client = null;
		}
	}
	
	private double calculateBill() {
		double value = 0;
		
		if (this.client.getType().equalsIgnoreCase("visitor")) {
			value = 15.0;
		}
		else if (this.client.getType().equalsIgnoreCase("non-faculty staff")) {
			value = 10.0;
		}
		else if (this.client.getType().equalsIgnoreCase("student")) {
			value = 5.0;
		}
		else if (this.client.getType().equalsIgnoreCase("faculty")) {
			value = 8.0;
		}
		
		long diffInMilliseconds = this.endingDate.getTime() - this.startingDate.getTime();
		long diffInHours = diffInMilliseconds / (1000 * 60 * 60);
		
		
		return (value * diffInHours) + value;
	}

	/*
	 * Get methods
	 */
	
	/**
	 * This method returns the client associated with this booking time
	 * @return returns the Client object associated with this booking time
	 */
	public Client getClient() {
		return this.client;
	}
	
	/**
	 * This method returns the starting date of this booking
	 * @return returns a Date object associated with the starting time of this booking
	 */
	public Date getStartingDate() {
		return this.startingDate;
	}
	
	/**
	 * This method returns the ending date of this booking
	 * @return returns a Date object associated with the ending time of this booking
	 */
	public Date endingDate() {
		return this.endingDate;
	}
	
	/**
	 * This method returns the parking space associated with this booking time
	 * @return returns the ParkingSpace object associated with this booking time
	 */
	public ParkingSpace getParkingSpace() {
		return this.spot;
	}
	
	/*
	 * Set methods
	 */
	
	/**
	 * This method sets the client for this booking time
	 * @param client is the Client object to be associated with this booking time
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
	/**
	 * This method sets the starting time for this booking
	 * @param date is the Date object to be associated with this bookings starting time
	 */
	public void setStartingDate(Date date) {
		this.startingDate = date;
	}
	
	/**
	 * This method sets the ending time for this booking
	 * @param date is the Date object to be associated with this bookings ending time
	 */
	public void setEndingDate(Date date) {
		this.endingDate = date;
	}
	
	/**
	 * This method sets the parking space for this booking time
	 * @param spot is the ParkingSpace object to be associated with this booking time
	 */
	public void setParkingSpace (ParkingSpace spot) {
		this.spot = spot;
	}
	
	/*
	 * Other useful methods
	 */
	
	/**
	 * This method cancels this booking time
	 * @return
	 */
	public String Cancel() {
		return null;
	}
	
	/**
	 * This method checks if this booking time has started
	 * @return returns true if the this booking time has started, false otherwise
	 */
	public boolean isStarted() {
		Date currentDate = new Date();
		if (this.startingDate.before(currentDate) && this.endingDate.after(currentDate)){
			return true;
		}
		return false;
	}
	
	/**
	 * This method checks if this booking time has ended
	 * @return returns true if the this booking time has ended, false otherwise
	 */
	public boolean isEnded() {
		Date currentDate = new Date();
		if (this.endingDate.after(currentDate)){
			return true;
		}
		return false;
	}
	
	/**
	 * This method returns this current time
	 * @return returns a double containing the current time
	 */
	public double getCurrentTime() {
		Date currentDate = new Date();
		return currentDate.getTime();
	}
	
	
	/**
	 * This method checks if the start time and end time is valid for this booking
	 * @param start is the starting time
	 * @param end is the ending time
	 * @return returns true if the end time and start time are valid times
	 */
	public boolean validateNewTimes(Date start, Date end) {
		Date currentDate = new Date();
		if (end.before(start) || start.before(currentDate) || end.before(currentDate)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	/**
	 * This method edits the current booking for the client
	 * @param booking is the Booking object to be edited
	 * @param newStartTime is Date object that is the new start time
	 * @param newEndTime is the Date object that is the new end time
	 * @return
	 */
	public boolean Edit(Booking booking, Date newStartTime, Date newEndTime) {
		if (!booking.validateNewTimes(newStartTime, newEndTime)) {
			return false;
		}
		booking.setStartingDate(newStartTime);
		booking.setEndingDate(newEndTime);
		return true;
	}
	
	public String toStringStarting() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	   return dateFormat.format(this.startingDate);
	}
	
	public String toStringEnding() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	   return dateFormat.format(this.endingDate);
	}
}
