package Users;

import Parking.Booking;

public class NonFacultyStaff extends Client{

	public NonFacultyStaff(String email, String password, Booking booking) {
		super(email, password, booking, "non-faculty staff");
	}

}
