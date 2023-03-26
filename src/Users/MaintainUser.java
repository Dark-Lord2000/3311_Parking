package Users;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import GUI.Design2;
import App.System1;

public class MaintainUser {
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception{
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		UserFactory factory = UserFactory.getInstance();
		
		while(reader.readRecord()){  
			//System.out.println(reader.get("email") + reader.get("password") + reader.get("type"));
			User user = factory.createUser(reader.get("email"), reader.get("password"), reader.get("type"));
			users.add(user);
		}
	}
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
				//name,id,email,password
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.write("type");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.write(u.getType());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	public static void main(String [] args) throws Exception{
		String path = "/Users/matt/eclipse-workspace/T007_project_deliverable_II/users.csv";
	
		System1.maintain.load(path);
		for(User u: System1.maintain.users){
			System.out.println(u.toString());
		}
		
	}
}
