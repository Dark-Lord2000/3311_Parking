package Users;
import Parking.*;
import java.util.Date;
import Utilities.*;

import App.System1;

public class Client extends User {
	
	//Class variables
	private Booking booking;
	private double balance;
	private String cardNumber;
	private String CCV;
	private String expiryDate;

	/**
	 * Constructor
	 * @param email is a String corresponding to the email of the User
	 * @param password is a String corresponding to the password of the User
	 * @param licensePlate is a String corresponding to the license plate of the car of the client
	 * @param booking is the Booking object corresponding to this Clients booked parking space
	 */
	public Client(String email, String password, Booking booking, String type) {
		super(email, password, type);
		this.booking = booking;
		this.balance = 0.0;
	}
	
	/*
	 * Get methods
	 */
	
	/**
	 * This method returns the clients booking
	 * @return returns a Booking object corresponding to the Clients booking
	 */
	public Booking getBooking() {
		return this.booking;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public String getCardNumber() {
		if (this.cardNumber == null) {
			return "";
		}
		return this.cardNumber;
	}
	
	
	/*
	 * Set methods
	 */
	
	/**
	 * This method sets the clients booking
	 * @param booking is the Booking object to be set
	 */
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	public void setCCV(String CCV) {
		this.CCV = CCV;
	}
	
	public void setCardNumber(String number) {
		this.cardNumber = number;
	}
	
	public void setExpiryDate(String exp) {
		this.expiryDate = exp;
	}
	
	public void addFunds(double money, String paymentType) {
		paymentFactory factory = paymentFactory.getInstance();
		PaymentMethod pm = factory.createPayment(paymentType);
		pm.addToBalance(this, money);
	}
	
	public void takeFunds(double money) {
		this.balance -= money;
	}
	
	public void increaseFunds(double money) {
		this.balance += money;
	}
	
	public void cancelBooking() {
		this.booking.getParkingSpace().setBooked(false);
		this.booking = null;
	}
	
	public boolean payBooking() {
		return this.booking.pay();
	}
	
	/**
	 * This method books a parking space for the Client
	 * @param startTime is a Date object associated with the time the booking starts
	 * @param endTime is a Date object associated with the time the booking ends
	 * @param spot is a ParkingSpace object associated with the parking space to be booked
	 * @param string
	 * @return returns a Booking object, that is the newly booked parking space for the Client
	 */
	public boolean bookSpace(Date startTime, Date endTime, int lotNumber, int spaceNumber, String licensePlate) {

		for (ParkingLot lot : System1.getAllLots()) {
			if (lot.getLotNumber() == lotNumber) {
				for (ParkingSpace space : lot.getSpaceList().keySet()) {
					if (space.getSpaceNumber() == spaceNumber) {

						Booking book = new Booking(this, startTime, endTime, space, licensePlate);
						if (book.getClient() == null) {

							return false;
						}
						break;
					}
				}
			}
		}
		return true;
	}

}
