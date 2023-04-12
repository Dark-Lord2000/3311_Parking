import org.junit.Test;

public class ParkingAppWrittenTestCases
{
  @Test
  public void RegisterVisitor()
  {
    
    
  }
  
  @Test
  public void RegisterFaculty()
  {

    
  }
  
  @Test 
  public void RegisterStudent()
  {
    //acount neeeds validation
  }
  
  @Test
  public void RegisterManager()
  {
    
  }
  
  @Test 
  public void RegisterSuperManager()
  {
    //auto account generation here or in separate test?
  }
  
  @Test 
  public void LoginVisitor()
  {
    //same account used from RegisterVisitor()
  }
  
  @Test
  public void LoginFaculty()
  {
    //same account used from RegisterFaculty()
  }
  
  @Test 
  public void LoginStudent()
  {
    //same account used from RegisterStudent()
  }
  
  @Test 
  public void LoginCSVAccount()
  {
    //use an account from csv file
  }
  
  @Test
  public void BookingSpace1()
  {
    //Visitor books space for x amount of hours (valid date)
  }
  
  @Test
  public void BookingSpace2()
  {
    //Visitor tries to book space that is already booked
  }
  
  @Test
  public void BookingSpace3()
  {
    //User tries to book space with invalid date (ex: date has already passed or ending date is before starting)
  }
  
  @Test
  public void CancelBooking1()
  {
    //user has a valid booking which is cancelled
  }
  
  @Test
  public void CancelBooking2()
  {
    //user doesn't have a valid booking to cancel (ex: booking doesn't even exist)
  }
  
  @Test
  public void EditBooking1()
  {
    //User changes starting time and ending time (valid dates, Booking exists, Booking has not yet started)
  }
  
  @Test 
  public void EditBooking2()
  {
    //User tries to change booking but doesn't have a valid booking (ex: booking doesn't even exist)
  }
  
  @Test
  public void EditBooking3()
  {
    //User extends EndTime of booking (valid date, Booking exists, Booking has already started)
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
  public void InvalidLicensePlate()
  {
    //an invalid plate is entered (incorrect format), which system denies
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
  public void Payment()
  {
    //
  }
  
  
  
  ////Parking Lot & Spaces Editing Tests
  
  @Test
  public void addLot1()
  {
    //1 lot is added to the system (done by management)
  }
  
  @Test 
  public void EnableLot1()
  {
    //Specified lot is enabled (valid entry, lot was previously disabled)
  }
  
  @Test 
  public void EnableLot2()
  {
    //Specified lot is already enabled (invalid entry, lot was previously enabled)
  }
  
  @Test 
  public void DisableLot1()
  {
    //Specified lot is disabled (valid entry, lot was previously enabled)
  }
  
  @Test 
  public void DisableLot2()
  {
    //Specified lot is already disabled (invalid entry, lot was previously disabled)
  }
  
  @Test
  public void EnableSpace1()
  {
    //Specified space is enabled (valid entry, space was previously disabled)
  }
  
  @Test
 public void EnableSpace2()
 {
    //Specified space is already enabled (invalid entry, space was previously enabled)
 }
   @Test
  public void DisableSpace1()
  {
    //Specified space is disabled (valid entry, space was previously enabled)
  }
  
  @Test
 public void DisableSpace2()
 {
    //Specified space is already disabled (invalid entry, space was previously disabled)
 }
  
}
