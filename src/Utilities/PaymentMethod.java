package Utilities;
import Parking.Booking;
import Users.Client;

// PaymentMethod interface
public interface PaymentMethod {
    boolean makePayment(Booking book);

	void addToBalance(Client client, double money);
}
