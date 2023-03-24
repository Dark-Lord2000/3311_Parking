package Utilities;
import Users.Manager;
import Users.User;
import java.util.Random;

import App.System1;

public class AccountGenerator {
	
	private static AccountGenerator singleton = new AccountGenerator();
	
	private AccountGenerator() {
		
	}

	/**
	 * This method generates a new Manager account with a random email and password
	 * @param manager must be an object of type SuperManager
	 * @return returns a Manager object that is the newly generated manager account
	 */
	public Manager generateAccount(Manager manager) {
		
		if (manager.getType().equalsIgnoreCase("super manager")){
			
			String email = this.randomString();
			String password = this.randomString();
			Manager newManager = new Manager(email, password, "manager");
			System1.addUser(newManager);
			System1.addManager(newManager);

			return newManager;
		}
			throw new IllegalArgumentException("You cannot generate an account!");
	}
	
	/**
	 * 
	 * @return
	 */
	private String randomString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString() + "!";
        return saltStr;
	}
	
	public static AccountGenerator getInstance() {
		return singleton;
	}
	
}
