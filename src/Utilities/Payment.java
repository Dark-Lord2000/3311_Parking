package Utilities;
import Parking.Booking;
import Users.Client;

public class Payment {
	//Class variables
	private String payType;
	private Booking booking;
	private double totalCost;
	private double deposit;
	
	/**
	 * Constructor
	 * @param payType is a String object corresponding to the type of payment
	 * @param booking is a Booking object corresponding to the booking that will be paid
	 * @param totalCost is a double corresponding to the total cost
	 * @param deposit is a double corresponding to the deposit
	 */
	public Payment(String payType, Booking booking, double totalCost, double deposit) {
		this.payType = payType;
		this.booking = booking;
		this.totalCost = totalCost;
		this.deposit = deposit;
	}
	
	/*
	 * Get methods
	 */
	
	/**
	 * This method returns the total cost of the payment
	 * @return returns a double corresponding to the total cost 
	 */
	public double getTotalCost() {
		return this.totalCost;
	}
	
	/**
	 * This method returns the deposit for the payment
	 * @return returns a double corresponding to the deposit
	 */
	public double getDeposit() {
		return this.deposit;
	}
	
	//One set method
	
	/**
	 * This method sets the deposit for this payment
	 * @param deposit is a double that corresponds with this payment
	 */
	public void setDepoit(double deposit) {
		this.deposit = deposit;
	}
	
	/*
	 * Useful methods
	 */
	
	/**
	 * This method makes the payment
	 * @param string
	 * @return
	 */
	public String makePayemnt(String string) {
		return null;
	}
	
	/**
	 * This method refunds the clients deposit if applicable 
	 * @param client is the Client to be refunded
	 */
	public void refundDeposit(Client client) {
		
	}

}
