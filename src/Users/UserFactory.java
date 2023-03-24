package Users;

public class UserFactory {
	
	//Factory method
	public static UserFactory factory = new UserFactory();
	
	private UserFactory() {
		//
	}
	
	public User createUser(String email, String password, String type) {
		
		type = type.toLowerCase();
		
		 if (!checkPasswordStrength(password)) {
			return null;
		}
		
		 else {
			switch (type) {
			  case "visitor":
			    User visitor = new Visitor(email, password, null);
			    return visitor;
			  case "manager":
			    User manager = new Manager(email, password, "manager");
			    return manager;
			  case "faculty":
			    User faculty = new Faculty(email, password, null);
			    return faculty;
			  case "non-faculty staff":
				  User staff = new NonFacultyStaff(email, password, null);
				    return staff;
			  case "student":
				  User student = new Faculty(email, password, null);
				  return student;
			  case "super manager":
				  User sm = new SuperManager(email, password);
				  return sm;
			  default:
			    throw new IllegalArgumentException();
			}
		 }
		
	}
	
	public static UserFactory getInstance() {
		return factory;
	}
	
	private boolean checkPasswordStrength(String password) {
		boolean number = false;
		boolean symbol = false;
		boolean capital = false;
		for (int i=0; i<password.length(); i++) {
			
			char character = password.charAt(i);
			
			if (!number && (47 < character && character < 58)) {
				number = true;
			}
			
			if (!symbol && ((32 < character && character < 48) 
					|| (57 < character && character < 65) 
					|| (90 < character && character < 97) 
					|| (122 < character && character < 127))) {
				symbol = true;
			}
			
			if (!capital && (64 < character && character < 91)) {
				capital = true;
			}
		}
		return (number && capital && symbol);
	}
}
