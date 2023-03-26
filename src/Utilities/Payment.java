package Utilities;
import Parking.Booking;
import Users.Client;

public class Payment implements PaymentMethod {
    // Class variables
    private PaymentMethod paymentMethod;
    private double totalCost;

    /**
     * Constructor
     * @param paymentMethod is a PaymentMethod object corresponding to the type of payment
     * @param booking is a Booking object corresponding to the booking that will be paid
     * @param totalCost is a double corresponding to the total cost
     * @param deposit is a double corresponding to the deposit
     */
    public Payment(PaymentMethod paymentMethod, double totalCost) {
        this.paymentMethod = paymentMethod;
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
     * @param book is the Booking object to be paid
     * @return true if payment was successful, false otherwise
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

	@Override
	public void addToBalance(Client client, double money) {
		// TODO Auto-generated method stub
		
	}


}
