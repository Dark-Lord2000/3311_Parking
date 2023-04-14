package Tests;

//import org.junit.Test;
import static org.junit.Assert.*;
import Users.*;
import App.System1;
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ParkingAppWrittenTestCases
{
  @Test
  @Order(1)
  public void RegisterVisitor()
  {
	  UserFactory factory = UserFactory.getInstance();
	  User visitor = factory.createUser("email@email.com", "Password1!", "visitor");
	  assertTrue(visitor.getType().equalsIgnoreCase("visitor"));
	  assertTrue(visitor instanceof Visitor);
	  assertTrue(visitor.getEmail().equalsIgnoreCase("email@email.com"));
	  assertTrue(visitor.getPassword().equalsIgnoreCase("Password1!"));
  }

  @Test
  @Order(2)
  public void RegisterFaculty()
  {
	  UserFactory factory = UserFactory.getInstance();
	  User faculty = factory.createUser("email2@email.com", "Password2!", "faculty");
	  assertTrue(faculty.getType().equalsIgnoreCase("faculty"));
	  assertTrue(faculty instanceof Faculty);
	  assertTrue(faculty.getEmail().equalsIgnoreCase("email2@email.com"));
	  assertTrue(faculty.getPassword().equalsIgnoreCase("Password2!"));
  }

  @Test 
  @Order(3)
  public void RegisterStudent()
  {
    //acount neeeds validation
	  UserFactory factory = UserFactory.getInstance();
	  Scanner scan = new Scanner(System.in);
	  System.out.println("Input student ID:");
	  String id = scan.nextLine();
	  assertEquals(id.length(), 9);
	  User student = factory.createUser("email9@email.com", "Password9!", "student");
	  assertTrue(student.getType().equalsIgnoreCase("student"));
	  assertTrue(student instanceof Student);
	  assertTrue(student.getEmail().equalsIgnoreCase("email9@email.com"));
	  assertTrue(student.getPassword().equalsIgnoreCase("Password9!"));
	  scan.close();
  }

  @Test
  @Order(4)
  public void RegisterManager()
  {
	  UserFactory factory = UserFactory.getInstance();
	  User manager = factory.createUser("email3@email.com", "Password3!", "manager");
	  assertTrue(manager.getType().equalsIgnoreCase("manager"));
	  assertTrue(manager instanceof Manager);
	  assertTrue(manager.getEmail().equalsIgnoreCase("email3@email.com"));
	  assertTrue(manager.getPassword().equalsIgnoreCase("Password3!"));
  }

  @Test 
  @Order(5)
  public void RegisterSuperManager()
  {
	  //account generation will be in separate test
	  UserFactory factory = UserFactory.getInstance();
	  User supermanager = factory.createUser("email4@email.com", "Password4!", "super manager");
	  assertTrue(supermanager.getType().equalsIgnoreCase("super manager"));
	  assertTrue(supermanager instanceof SuperManager);
	  assertTrue(supermanager.getEmail().equalsIgnoreCase("email4@email.com"));
	  assertTrue(supermanager.getPassword().equalsIgnoreCase("Password4!"));
  }

  @Test 
  @Order(6)
  public void LoginVisitor()
  {
	  User visitor = System1.signIn("email@email.com", "Password1!");
	  assertTrue(visitor.getType().equalsIgnoreCase("visitor"));
	  assertTrue(System1.currentUser == visitor);
	  assertTrue(visitor instanceof Visitor);
	  assertTrue(System1.currentUser.getEmail().equalsIgnoreCase("email@email.com"));
	  assertTrue(System1.currentUser.getPassword().equalsIgnoreCase("Password1!"));
    //same account used from RegisterVisitor()
  }

  @Test
  @Order(7)
  public void LoginFaculty()
  {
	  User faculty = System1.signIn("email2@email.com", "Password2!");
	  assertTrue(faculty.getType().equalsIgnoreCase("faculty"));
	  assertTrue(System1.currentUser == faculty);
	  assertTrue(faculty instanceof Faculty);
	  assertTrue(System1.currentUser.getEmail().equalsIgnoreCase("email2@email.com"));
	  assertTrue(System1.currentUser.getPassword().equalsIgnoreCase("Password2!"));
    //same account used from RegisterFaculty()
  }

  @Test 
  public void LoginStudent()
  {
	  
    //same account used from RegisterStudent()
  }

  @Test 
  @Order(8)
  public void LoginCSVAccount()
  {
	  User song = System1.signIn("email4@email.com", "Password4!");
	  assertTrue(song.getType().equalsIgnoreCase("super manager"));
	  assertTrue(System1.currentUser == song);
	  assertTrue(song instanceof SuperManager);
	  assertTrue(System1.currentUser.getEmail().equalsIgnoreCase("email4@email.com"));
	  assertTrue(System1.currentUser.getPassword().equalsIgnoreCase("Password4!"));
    //use an account from csv file
  }
  
  @Test
  @Order(9)
  public void addLot1()
  {
	//Log in with manager
	  Manager song = (Manager) System1.signIn("email4@email.com", "Password4!");
	  song.addParkingLot();
	  assertTrue(System1.getAllLots().size() == 1);
	  assertTrue(System1.getParkingLot(0) != null);
	  assertTrue(System1.getParkingLot(0).getSpaceList().size() == 100);
	  
    //1 lot is added to the system (done by management)
  }

  @Test
  @Order(10)
  public void BookingSpace1()
  {
	  
	  //Sign in first
	  Client visitor = (Client) System1.signIn("email@email.com", "Password1!");
	  //Create start and end time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 5);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 7);
	  calStart.set(Calendar.DAY_OF_MONTH, 5);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 5);
	  calEnd.set(Calendar.MINUTE, 0);
	  calEnd.set(Calendar.HOUR, 10);
	  calEnd.set(Calendar.DAY_OF_MONTH, 5);
		Date end = calEnd.getTime();
	  assertTrue(visitor.bookSpace(start, end, 0, 1, "ABCD-123"));
	  assertTrue(visitor.getBooking() != null);
	  assertTrue(visitor.getBooking().getClient() == visitor);
	  assertTrue(visitor.getBooking().getStartingDate().equals(start));
	  assertTrue(visitor.getBooking().endingDate().equals(end));
	  assertTrue(System1.getParkingSpace(1, 0).isBooked());
    //Visitor books space for x amount of hours (valid date)
  }

  @Test
  @Order(11)
  public void BookingSpace2()
  {
	  //Log in with visitor
	  Client faculty = (Client) System1.signIn("email2@email.com", "Password2!");
	  
	//Create start and end time for the same time as inder in the above test
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 5);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 7);
	  calStart.set(Calendar.DAY_OF_MONTH, 5);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 5);
	  calEnd.set(Calendar.MINUTE, 0);
	  calEnd.set(Calendar.HOUR, 10);
	  calEnd.set(Calendar.DAY_OF_MONTH, 5);
	  Date end = calEnd.getTime();
	  
	  assertTrue(!faculty.bookSpace(start, end, 0, 1, "ZXCV-890"));
	  assertTrue(faculty.getBooking() == null);
	  
    //Visitor tries to book space that is already booked
  }

  @Test
  @Order(12)
  public void BookingSpace3()
  {
	//Log in with student
	  Client student = (Client) System1.signIn("email9@email.com", "Password9!");
	  
	//Create start and end time where end time is before start time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 5);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 7);
	  calStart.set(Calendar.DAY_OF_MONTH, 5);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 5);
	  calEnd.set(Calendar.MINUTE, 0);
	  calEnd.set(Calendar.HOUR, 5);
	  calEnd.set(Calendar.DAY_OF_MONTH, 5);
	  Date end = calEnd.getTime();
	  
	  assertTrue(!student.bookSpace(start, end, 0, 20, "QWER-345"));
	  assertTrue(student.getBooking() == null);
    //User tries to book space with invalid date (ex: date has already passed or ending date is before starting)
  }

  @Test
  @Order(13)
  public void CancelBooking1()
  {
	  // use the same booking from test case  BookSpace1
	  //sign in
	  Client visitor = (Client) System1.signIn("email@email.com", "Password1!");
	  assertTrue(visitor.getBooking() != null);
	  visitor.cancelBooking();
	  assertTrue(visitor.getBooking() == null);
	  //Now check if the space previously booked is no longer booked
	  assertTrue(!System1.getParkingSpace(1, 0).isBooked());
    //user has a valid booking which is cancelled
  }

  @Test
  public void CancelBooking2()
  {
	  //Sign in with random student account
	  Client student = (Client) System1.signIn("daniel@gmail.com", "Dan1!");
	  
    //user doesn't have a valid booking to cancel (ex: booking doesn't even exist)
  }

  @Test
  @Order(14)
  public void EditBooking1()
  {
	//Sign in with random account
	  Client student = (Client) System1.signIn("email@email.com", "Password1!");
	//Create start and end time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 7);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 9);
	  calStart.set(Calendar.DAY_OF_MONTH, 1);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 7);
	  calEnd.set(Calendar.MINUTE, 30);
	  calEnd.set(Calendar.HOUR, 11);
	  calEnd.set(Calendar.DAY_OF_MONTH, 2);
		Date end = calEnd.getTime();
	  assertTrue(student.bookSpace(start, end, 0, 40, "ABCD-234"));
	  
	  //Create new booking
	  Calendar calStart2 = Calendar.getInstance();
	  calStart2.set(Calendar.YEAR, 2023);
	  calStart2.set(Calendar.MONTH, 7);
	  calStart2.set(Calendar.MINUTE, 30);
      calStart2.set(Calendar.HOUR, 10);
	  calStart2.set(Calendar.DAY_OF_MONTH, 2);
	  Date start2 = calStart2.getTime();
	  
	  Calendar calEnd2 = Calendar.getInstance();
	  calEnd2.set(Calendar.YEAR, 2023);
	  calEnd2.set(Calendar.MONTH, 7);
	  calEnd2.set(Calendar.MINUTE, 0);
	  calEnd2.set(Calendar.HOUR, 11);
	  calEnd2.set(Calendar.DAY_OF_MONTH, 3);
		Date end2 = calEnd2.getTime();
	  assertTrue(student.getBooking().Edit(student.getBooking(), start2, end2, 0, 40));
	  assertTrue(student.getBooking() != null);
	  assertTrue(student.getBooking().getStartingDate().equals(start2));
	  assertTrue(student.getBooking().endingDate().equals(end2));
	  assertTrue(System1.getParkingSpace(40, 0).isBooked());
    //User changes starting time and ending time (valid dates, Booking exists, Booking has not yet started)
  }

  @Test 
  @Order(15)
  public void EditBooking2()
  {
	//Sign in with random faculty account
	  Client faculty = (Client) System1.signIn("darklord@gmail.com", "Dl1!");
	  assertTrue(faculty.getBooking() == null);
	//Create start and end time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 7);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 9);
	  calStart.set(Calendar.DAY_OF_MONTH, 1);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 7);
	  calEnd.set(Calendar.MINUTE, 30);
	  calEnd.set(Calendar.HOUR, 11);
	  calEnd.set(Calendar.DAY_OF_MONTH, 2);
	  Date end = calEnd.getTime();
	  
	  try {
		  faculty.getBooking().Edit(faculty.getBooking(), start, end, 0, 44);
	  } catch (Exception e) {
		  //booking is null, so trying to edit it shoul give a null pointer exception
		  assertTrue(e instanceof NullPointerException);
	  }
    //User tries to change booking but doesn't have a valid booking (ex: booking doesn't even exist)
  }

  @Test
  @Order(16)
  public void EditBooking3()
  {
    //User extends EndTime of booking (valid date, Booking exists, Booking has already started)
	  
	//Sign in with random non faculty staff account
	  Client faculty = (Client) System1.signIn("darklord@gmail.com", "Dl1!");
	  assertTrue(faculty.getBooking() == null);
	//Create start and end time
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 7);
	  calEnd.set(Calendar.MINUTE, 30);
	  calEnd.set(Calendar.HOUR, 11);
	  calEnd.set(Calendar.DAY_OF_MONTH, 2);
	  Date end = calEnd.getTime();
	  
	  faculty.bookSpace(new Date(), end, 0, 70, "SDFG-905");
	  
	  //set new end time
	  Calendar calEnd2 = Calendar.getInstance();
	  calEnd2.set(Calendar.YEAR, 2023);
	  calEnd2.set(Calendar.MONTH, 7);
	  calEnd2.set(Calendar.MINUTE, 30);
	  calEnd2.set(Calendar.HOUR, 11);
	  calEnd2.set(Calendar.DAY_OF_MONTH, 2);
	  Date end2 = calEnd.getTime();
	  assertTrue(faculty.getBooking().Edit(faculty.getBooking(), faculty.getBooking().getStartingDate(), end2, 0, 70));
	  //check if new booking is updated
	  assertTrue(faculty.getBooking().endingDate().equals(end2));
	  assertTrue(faculty.getBooking().getParkingSpace().isBooked());
	  assertTrue(faculty.getBooking().getParkingSpace().getSpaceNumber() == 70);
	  assertTrue(faculty.getBooking().getParkingSpace().getParkingLot().getLotNumber() == 0);
	  assertTrue(faculty.getBooking().isStarted());
  }

  @Test
  public void CheckingVacancy1()
  {
    //spot is taken, ex: sensor is returning 1
    //idk if this is even needed or not or how to properly implement
  }

  @Test
  public void CheckingVacancy2()
  {
    //spot is empty: sensor is returning 0
    //idk if this is even needed or not or how to properly implement
  }

  @Test
  public void ValidLicensePlate()
  {
    //a valid license plate is entered (correct format), which system accepts
  }

  @Test 
  @Order(17)
  public void InvalidLicensePlate()
  {
    //an invalid plate is entered (incorrect format), which system denies
	  
	//Sign in with random student account
	  Client student = (Client) System1.signIn("mark", "Mark1!");
	//Create start and end time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 7);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 9);
	  calStart.set(Calendar.DAY_OF_MONTH, 1);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 7);
	  calEnd.set(Calendar.MINUTE, 30);
	  calEnd.set(Calendar.HOUR, 11);
	  calEnd.set(Calendar.DAY_OF_MONTH, 2);
	  Date end = calEnd.getTime();
	  
	  //set booking with invalid license plate
	  assertTrue(!(student.bookSpace(start, end, 0, 90, "invalid")));
  }

  @Test
  public void UserTypeStudent() //idk if this is needed
  {
    //checks student user type is matching their specification (student user account has student type)
    //could be used for possible error checker
  }

  @Test 
  public void UserTypeSuperManager()
  {
    //checks Super Manager user type is matching their specification (super manager account has super manager type)
    //could be used for possible error checker
  }

  @Test
  @Order(18)
  public void Payment()
  {
	//Sign in with random faculty account
	  Client student = (Client) System1.signIn("mark", "Mark1!");
	//Create start and end time
	  Calendar calStart = Calendar.getInstance();
	  calStart.set(Calendar.YEAR, 2023);
	  calStart.set(Calendar.MONTH, 7);
	  calStart.set(Calendar.MINUTE, 30);
      calStart.set(Calendar.HOUR, 5);
	  calStart.set(Calendar.DAY_OF_MONTH, 1);
	  Date start = calStart.getTime();
	  
	  Calendar calEnd = Calendar.getInstance();
	  calEnd.set(Calendar.YEAR, 2023);
	  calEnd.set(Calendar.MONTH, 7);
	  calEnd.set(Calendar.MINUTE, 30);
	  calEnd.set(Calendar.HOUR, 10);
	  calEnd.set(Calendar.DAY_OF_MONTH, 1);
	  Date end = calEnd.getTime();
	 
	  //pay SHOULD be 
	  double totalPay = 30.0; //5 hours times 5 dollars per hour + 5 dollar deposit
	  
	  //add funds to account
	  student.addFunds(100.00, "credit");
	  assertTrue(student.getBalance() == 100.00);
	  
	  //set booking with valid license plate
	  assertTrue((student.bookSpace(start, end, 0, 91, "AXFG-794")));
	  
	  //pay
	  assertTrue(student.payBooking());
	  //check values now
	  assertTrue(student.getBooking().getPaid()); //booking should be paid
	  assertTrue(student.getBalance() == 70.0 || student.getBalance() == 75.0); //either deposit is refunded or not
  }



  ////Parking Lot & Spaces Editing Tests
  @Test 
  @Order(19)
  public void DisableLot1()
  {
    //Specified lot is disabled (valid entry, lot was previously enabled)
	  
	//Sign in with random manager account
	  Manager manager = (Manager) System1.signIn("mario@yorku.ca", "Luffy1!");
	  assertTrue(System1.getParkingLot(0).isEnabled());
	  manager.disableParkingLot(System1.getParkingLot(0));
	  assertTrue(!System1.getParkingLot(0).isEnabled());
  }

  @Test 
  @Order(20)
  public void EnableLot1()
  {
	//Sign in with random manager account
	  Manager manager = (Manager) System1.signIn("mario@yorku.ca", "Luffy1!");
	  assertTrue(!System1.getParkingLot(0).isEnabled());
	  manager.enableParkingLot(System1.getParkingLot(0));
	  assertTrue(System1.getParkingLot(0).isEnabled());
    //Specified lot is enabled (valid entry, lot was previously disabled)
  }


  
  
  @Test
  @Order(21)
 public void DisableSpace1()
 {
   //Specified space is disabled (valid entry, space was previously enabled)
	//Sign in with random manager account
	  Manager manager = (Manager) System1.signIn("mario@yorku.ca", "Luffy1!");
	  assertTrue(System1.getParkingSpace(79, 0).isEnabled());
	  manager.disableParkingSpace(System1.getParkingSpace(79, 0));
	  assertTrue(!System1.getParkingSpace(79, 0).isEnabled());
 }
  

  @Test
  @Order(26)
  public void EnableSpace1()
  {
    //Specified space is enabled (valid entry, space was previously disabled)
	//Sign in with random manager account
	  Manager manager = (Manager) System1.signIn("mario@yorku.ca", "Luffy1!");
	  assertTrue(!System1.getParkingSpace(79, 0).isEnabled());
	  manager.enableParkingSpace(System1.getParkingSpace(79, 0));
	  assertTrue(System1.getParkingSpace(79, 0).isEnabled());
  }



}
