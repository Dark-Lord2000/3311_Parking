package Utilities;
import Parking.Booking;
import Users.Client;

public class Payment {
	//Class variables
	private String payType;
	private double totalCost;
	
	/**
	 * Constructor
	 * @param payType is a String object corresponding to the type of payment
	 * @param booking is a Booking object corresponding to the booking that will be paid
	 * @param totalCost is a double corresponding to the total cost
	 * @param deposit is a double corresponding to the deposit
	 */
	public Payment(String payType, double totalCost) {
		this.payType = payType;
		this.totalCost = totalCost;
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
	
	
	/*
	 * Useful methods
	 */
	
	/**
	 * This method makes the payment
	 * @param string
	 * @return
	 */
	public boolean makePayment(Booking book) {
		if((book.getClient().getBalance() >= book.getBill()) && !book.getPaid()) {
			book.getClient().takeFunds(book.getBill());
			book.setPaid(true);
			book.setBill(0.00);
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method refunds the clients deposit if applicable 
	 * @param client is the Client to be refunded
	 */
	public void refundDeposit(Client client) {
		
	}

}
