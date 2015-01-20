package edu.austincc.domain;

public class User implements Comparable<User> {
	private String email;
	private String name;
	
	
	
	public User(String email, String name) {
		super();
		this.email = email;
		this.name = name;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + "]";
	}

	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	
	
}
