package App;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import Parking.*;
import Users.User;
import Users.Manager;
import Users.MaintainUser;

public class System1 {
	
	//Class variables
	private static  List<ParkingLot> allLots = new ArrayList<>();
	private static List<User> allUsers = new ArrayList<>();
	private static List<Manager> allManagers = new ArrayList<>();
	private static List<ParkingSpace> allSpaces = new ArrayList<>();
	//private static List<ParkingSpace> allOccupiedSpaces = new ArrayList<>();
	public static User currentUser;
	public static MaintainUser maintain = new MaintainUser();
	
	private static Map<ParkingLot, List<ParkingSpace>> c;
	
	public System1(ArrayList<ParkingLot> Lots, ArrayList<User> Users, ArrayList<ParkingSpace> Spaces, ArrayList<Manager> Managers) {
		allLots = Lots;
		allUsers = Users;
		allSpaces = Spaces;
		allManagers = Managers;
	}
	
	public static void addLot(ParkingLot lot){
		allLots.add(lot);
	}
	
	public static ParkingLot getParkingLot(int lotNum) {
		//ParkingLot lot = new ParkingLot();
		//lot.getSpaceList().put(new ParkingSpace(1, lot, null, "mexico" ), null);
		//allLots.add(lot);
		
		for (int i=0; i<allLots.size(); i++) {
			if (allLots.get(i).getLotNumber() == lotNum){
				return allLots.get(i);
			}
		}
		return null;
	}
	
	public static ParkingSpace getParkingSpace(int spaceNum, int lotNumber) {
		for (int i=0; i<allSpaces.size(); i++) {
			if (allSpaces.get(i).getSpaceNumber() == spaceNum && allSpaces.get(i).getParkingLot().getLotNumber() == lotNumber){
				return allSpaces.get(i);
			}
		}
		return null;
	}
	
	public static List<User> getAllUsers(){
		return allUsers;
	}
	
	public static List<Manager> getAllManagers(){
		return allManagers;
	}
	
	public static List<ParkingSpace> getAllSpaces(){
		return allSpaces;
	}
	
	public static List<ParkingLot> getAllLots(){
		return allLots;
	}
	
	public static void addUser(User user) {
		allUsers.add(user);
	}

	public static void addManager(Manager newManager) {
		allManagers.add(newManager);
		
	}
	
	public static void addParkingSpace(ParkingSpace space) {
		allSpaces.add(space);
	}
	
	
	public static User signIn(String email, String password) {
		
		//If there are users in the list of users
		if (allUsers.size() != 0) {
			//Search for the user
			for (int i=0; i<allUsers.size(); i++) {
				User temp = allUsers.get(i);
				if (temp.getEmail().equals(email) &&
					temp.getPassword().equals(password)) {
					currentUser = temp;
					return temp;
				}
			}
			
		}
		
		return null;
	}
}
