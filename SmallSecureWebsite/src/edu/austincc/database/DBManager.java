package edu.austincc.database;

import java.util.ArrayList;
import java.util.Collections;

import edu.austincc.domain.User;

public class DBManager {

	
	public static ArrayList<User> getPeople() 
	{
		ArrayList<User> people = new ArrayList();
		people.add(new User("sam@foo.com", "sam"));
        people.add(new User("bob@foo.com", "bob"));
        people.add(new User("jill@foo.com", "jill"));
        people.add(new User("mary@apple.com", "mary"));
        people.add(new User("sam@apple.com", "sam"));
        people.add(new User("melba@ibm.com", "melba"));
        
        
        Collections.sort(people);
        
        return people; 
	}
	
}
