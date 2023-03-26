package Users;

import Parking.Booking;

public class Student extends Client{

	public Student(String email, String password, Booking booking) {
		super(email, password, booking, "student");
	}

}
