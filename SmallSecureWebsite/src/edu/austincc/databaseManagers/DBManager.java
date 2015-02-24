package edu.austincc.databaseManagers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import edu.austincc.domain.User;

public class DBManager {

	// Static variables aka Class variables
	// sharedInstnace is a Singelton
	private static DBManager sharedInstance;

	// Instance Variables
	ArrayList<User> people = new ArrayList<User>();

	private DBManager() {
		// Intialize the people into the instance
		this.addUser(new User("sam@foo.com", "sam", UUID.randomUUID(), "abc"));
		this.addUser(new User("bob@foo.com", "bob", UUID.randomUUID(), "def"));
		this.addUser(new User("jill@foo.com", "jill", UUID.randomUUID(), "hij"));
		this.addUser(new User("mary@apple.com", "mary", UUID.randomUUID(), "klm"));
		this.addUser(new User("sam@apple.com", "sam", UUID.randomUUID(), "nop"));
		this.addUser(new User("melba@ibm.com", "melba", UUID.randomUUID(), "qrs"));
	}

	// Initialize the sharedInstance singleton here
	public static DBManager sharedInstance() {
		if (sharedInstance == null) {
			sharedInstance = new DBManager();
		}

		return sharedInstance;
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		people.add(user);
	}

	public ArrayList<User> getPeople() {

		Collections.sort(people);

		return people;
	}

	public User findUserWithNameAndEmail(String name, String email) {

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

	public User findUserWithNameAndPassword(String name, String password) {

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

	public User findUserWithID(String theUserID) {

		return findUserWithID(UUID.fromString(theUserID));

	}

	public User findUserWithID(UUID theUserID) {

		ArrayList<User> thePeople = getPeople();

		UUID id = theUserID;

		// Loop thru the users and find the one who has
		// the name and email we are looking for and return it.
		// If they are not found return null.
		for (User user : thePeople) {
			if ( user.getID().equals(id) ) {
				return user;
			}
		}
		// No user found matching name and email
		return null;

	}

}
