package Utilities;

import Parking.Booking;
import Users.Client;

public class CreditCardPayment implements PaymentMethod {
    private PaymentMethod paymentMethod;

    public CreditCardPayment() {
    }

    /**
     * This method makes the payment via credit card
     * @param book is the Booking object to be paid
     * @return true if payment was successful, false otherwise
     */
    public boolean makePayment(Booking book) {
        // Process payment via credit card
        System.out.println("Processing payment via credit card...");
        boolean success = paymentMethod.makePayment(book);
        return success;
    }

	@Override
	public void addToBalance(Client client, double money) {
		client.increaseFunds(money);
	}
}
