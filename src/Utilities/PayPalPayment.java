package Utilities;

import Parking.Booking;
import Users.Client;

//PayPalPayment decorator class
public class PayPalPayment implements PaymentMethod {
 private PaymentMethod paymentMethod;

 public PayPalPayment() {
 }

 /**
  * This method makes the payment via PayPal
  * @param book is the Booking object to be paid
  * @return true if payment was successful, false otherwise
  */
 public boolean makePayment(Booking book) {
     // Process payment via PayPal
     System.out.println("Processing payment via PayPal...");
     boolean success = paymentMethod.makePayment(book);
     return success;
 }

	@Override
	public void addToBalance(Client client, double money) {
		client.increaseFunds(money);
		
	}
}
