package Utilities;

import Users.Faculty;
import Users.Manager;
import Users.NonFacultyStaff;
import Users.Student;
import Users.SuperManager;
import Users.User;
import Users.Visitor;

public class paymentFactory {
	
	private static paymentFactory factory = new paymentFactory();
	
	private paymentFactory() {
		//
	}
	
	public PaymentMethod createPayment(String type) {
		
		type = type.toLowerCase();
		
		switch (type) {
		  case "credit":
		    CreditCardPayment ccp = new CreditCardPayment();
		    return ccp;
		  case "debit":
			  DebitCardPayment dcp = new DebitCardPayment();
		    return dcp;
		  case "paypal":
		    PayPalPayment ppp = new PayPalPayment();
		    return ppp;
		  default:
		    throw new IllegalArgumentException();
		}
	}
	
	public static paymentFactory getInstance() {
		return factory;
	}
}
