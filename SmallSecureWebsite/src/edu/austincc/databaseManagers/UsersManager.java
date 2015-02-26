package edu.austincc.databaseManagers;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.sql.DataSource;

import org.apache.derby.client.am.DateTime;
import org.apache.tomcat.dbcp.dbcp.SQLNestedException;

import edu.austincc.domain.User;
import edu.austincc.exceptions.DBErrorException;

public class UsersManager {

	DataSource ds;

	public UsersManager(DataSource ds) {
		this.ds = ds;
	}

	public ArrayList<User> getUsers() throws DBErrorException {
		ArrayList<User> users = new ArrayList<>();

		Connection connection = null;
		try {
			
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement("select ID, UUID, NAME, PASSWORD, EMAIL from ACC_USER");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				users.add(new User( resultSet.getString("uuid"),
									resultSet.getString("name"),
									resultSet.getString("password"),
									resultSet.getString("email")));
			}

			resultSet.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBErrorException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return users;
	}

	

	public boolean addUser(User aUser) throws DBErrorException  {
		// TODO - Put the user in the user db
		// FIXME - This has a bug

		// Example with data from SQL Script
		// insert into users (name, password) values ('sam', 'abcd');
		boolean added = false;
		Connection connection = null;
		
		try {
			
			connection = ds.getConnection();

			String uname = aUser.getName();
			String upass = aUser.getPassword();
			String uemail = aUser.getEmail();
			String uUUID = aUser.getID().toString();
			Calendar rightNow = Calendar.getInstance();
			long id = rightNow.getTimeInMillis();
			
			PreparedStatement prepStatement = connection.prepareStatement("insert into ACC_USER (id, uuid, name, password, email) values (?, ?, ?, ?, ?)");

			prepStatement.setLong(1, id);
			prepStatement.setString(2, uUUID);
			prepStatement.setString(3, uname);
			prepStatement.setString(4, upass);
			prepStatement.setString(5, uemail);
			

			prepStatement.execute();


			prepStatement.close();

			added = true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBErrorException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return added;
	}

	public User getUserWithID(String theUserID) throws DBErrorException {
		User foundUser = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement("select ID, UUID, NAME, PASSWORD, EMAIL from ACC_USER where UUID = ?");
			ps.setString(1, theUserID);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				foundUser = new User( resultSet.getString("uuid"),
									resultSet.getString("name"),
									resultSet.getString("password"),
									resultSet.getString("email"));
			}

			resultSet.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBErrorException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return foundUser;
	}

	public User findUserWithNameAndPassword(String name, String password) throws DBErrorException {
		User foundUser = null;
		Connection connection = null;
		
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement("select ID, UUID, NAME, PASSWORD, EMAIL from ACC_USER where NAME = ? AND PASSWORD = ?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				foundUser = new User( resultSet.getString("uuid"),
									resultSet.getString("name"),
									resultSet.getString("password"),
									resultSet.getString("email"));
			}

			resultSet.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBErrorException();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return foundUser;
	}

	
}
