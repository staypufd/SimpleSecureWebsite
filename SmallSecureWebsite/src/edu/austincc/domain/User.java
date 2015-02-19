package edu.austincc.domain;

import java.util.UUID;



public class User implements Comparable<User> {
	private String email;
	private String name;
	private UUID	ID;
	private String password;



	public User(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.ID = UUID.randomUUID();
		this.password = password;
	}

	public User(String email, String name, UUID ID, String password) {
		super();
		this.email = email;
		this.name = name;
		this.ID = ID;
		this.password = password;
	}
	
	public User(String UUIDString, String name, String password, String email) {
		super();
		this.email = email;
		this.name = name;
		this.ID = UUID.fromString(UUIDString);
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the iD
	 */
	public UUID getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(UUID iD) {
		ID = iD;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", ID=" + ID
				+ ", password=" + password + "]";
	}

	// Implements the Comparable Interface
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}


	// Helper methods
	public String getCapitalizedUserName()
	{
		String sString = this.name.toLowerCase();
		sString = Character.toString(sString.charAt(0)).toUpperCase() + sString.substring(1);

		return sString;
	}

}
