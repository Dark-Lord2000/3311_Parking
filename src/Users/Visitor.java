package Users;

import Parking.Booking;

public class Visitor extends Client{

	public Visitor(String email, String password, Booking booking) {
		super(email, password, booking);
	}

}
