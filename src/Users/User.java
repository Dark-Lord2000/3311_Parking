package Users;
import App.System1;

public class User {

	//Class variables
	String email;
	String password;
	String type;
	
	/**
	 * Constructor
	 * @param email is a String corresponding to the email of the User
	 * @param password is a String corresponding to the password of the User
	 */
	public User(String email, String password, String type) {
		this.email = email;
		this.password = password;
		this.type = type;
		System1.addUser(this);
		System1.maintain.users.add(this);
		try {System1.maintain.update("/Users/matt/eclipse-workspace/T007_project_deliverable_II/users.csv");
		
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
	
	/**
	 * This method returns the type of client (student, faculty, ... etc.)
	 * @return returns a String corresponding to the type of Client
	 */
	public String getType() {
		String str = this.type.toLowerCase();
		return str;
	}
	
	public String getEmail() {
		String str = this.email.toLowerCase();
		return str;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		String st = "Email: " + this.email + ", Password: " + this.password + ", Type: " + this.type;
		return st;
	}
}
