package Users;
import Utilities.AccountGenerator;

public class SuperManager extends Manager{

	public SuperManager(String email, String password) {
		super(email, password, "super manager");
	}
	
	/**
	 * This method returns a new User account
	 * @return returns a User object
	 */
	public Manager generateAccount() {
		AccountGenerator generate = AccountGenerator.getInstance();
		return generate.generateAccount(this);
	}

}
