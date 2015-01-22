package edu.austincc.database;

import java.util.ArrayList;
import java.util.Collections;

import edu.austincc.domain.User;

public class DBManager {

	public static ArrayList<User> getPeople() {
		ArrayList<User> people = new ArrayList();
		people.add(new User("sam@foo.com", "sam", 1, "abc"));
		people.add(new User("bob@foo.com", "bob", 2, "def"));
		people.add(new User("jill@foo.com", "jill", 3, "hij"));
		people.add(new User("mary@apple.com", "mary", 4, "klm"));
		people.add(new User("sam@apple.com", "sam", 5, "nop"));
		people.add(new User("melba@ibm.com", "melba", 6, "qrs"));

		Collections.sort(people);

		return people;
	}

	public static User findUserWithNameAndEmail(String name, String email) {

		ArrayList<User> thePeople = getPeople();

		// Loop thru the users and find the one who has
		// the name and email we are looking for and return it.
		// If they are not found return null.
		for (User user : thePeople) {
			if ((user.getName().equalsIgnoreCase(name))
					&& (user.getEmail().equalsIgnoreCase(email))) {
				return user;
			}
		}
		// No user found matching name and email
		return null;
	}
	
	public static User findUserWithNameAndPassword(String name, String password) {

		ArrayList<User> thePeople = getPeople();

		// Loop thru the users and find the one who has
		// the name and email we are looking for and return it.
		// If they are not found return null.
		for (User user : thePeople) {
			if ((user.getName().equalsIgnoreCase(name))
					&& (user.getPassword().equalsIgnoreCase(password))) {
				return user;
			}
		}
		// No user found matching name and email
		return null;
	}

	public static User findUserWithID(String theUserID) {
		
		int id = new Integer(theUserID);

		return findUserWithID(id);
		
	}
	
	public static User findUserWithID(int theUserID) {
		
		ArrayList<User> thePeople = getPeople();
		
		int id = theUserID;

		// Loop thru the users and find the one who has
		// the name and email we are looking for and return it.
		// If they are not found return null.
		for (User user : thePeople) {
			if ( user.getID() == id ) {
				return user;
			}
		}
		// No user found matching name and email
		return null;
		
	}

}
