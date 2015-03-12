/**
 * 
 */
package edu.austincc.databaseManagers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import edu.austincc.domain.User;
import edu.austincc.domain.Vehicle;
import edu.austincc.exceptions.DBErrorException;

/**
 * @author javauser
 *
 */
public class VehiclesManager {

	DataSource ds;

	public VehiclesManager(DataSource ds) {
		super();
		this.ds = ds;
	}
	
	public ArrayList<Vehicle> getVehicles() throws DBErrorException {
		ArrayList<Vehicle> vehicles = new ArrayList<>();

		Connection connection = null;
		try {
			
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement("select * from vehicles");
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				vehicles.add(new Vehicle( resultSet.getInt("id"),
									resultSet.getString("make"),
									resultSet.getString("model"),
									resultSet.getString("color"),
									resultSet.getInt("theYear"),
									resultSet.getInt("mileage")
									));
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

		return vehicles;
	}

	public Vehicle getVehicleWithID(int id) throws DBErrorException {
		Connection connection = null;
		Vehicle vehicle = null;
		
		try {
			
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement("select * from vehicles where id = ?");
			ps.setInt(1, id);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {
				vehicle = new Vehicle( resultSet.getInt("id"),
									resultSet.getString("make"),
									resultSet.getString("model"),
									resultSet.getString("color"),
									resultSet.getInt("theYear"),
									resultSet.getInt("mileage")
									);
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

		return vehicle;
	}

	public boolean updateVehicle(Vehicle v) throws DBErrorException {
		
		boolean updateSuccessful = false;
		
		Connection connection = null;
		
		try {
			
			connection = ds.getConnection();

			String theSqlQueryString = "update VEHICLES set make = ?, "
					+ "model = ?, theYear = ?, mileage = ?, color = ? where id = ?";
			
			PreparedStatement ps = connection.prepareStatement(theSqlQueryString);
			ps.setString(1, v.getMake());
			ps.setString(2, v.getModel());
			ps.setInt(3, v.getYear());
			ps.setInt(4, v.getMileage());
			ps.setString(5, v.getColor());
			ps.setInt(6, v.getId());
			
			int theUpdatedCount = ps.executeUpdate();
			if (theUpdatedCount >= 1) {
				updateSuccessful = true;
			}
			
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
		
	
		return updateSuccessful;
	}

	public boolean addVehicleForValues(String make, String model, String color,
			int year, int mileage) throws DBErrorException {
		
		// INSERT INTO VEHICLES (make, model, theYear, mileage, color)  values ('Lincoln', 'Navigator', 1978, 300000, 'Silver');
		boolean updateSuccessful = false;
		Connection connection = null;
		
		try {
			
			connection = ds.getConnection();

			String theSqlQueryString = "INSERT INTO VEHICLES (make, model, theYear, mileage, color)  values (?, ?, ?, ?, ?)";
			
			PreparedStatement ps = connection.prepareStatement(theSqlQueryString);
			ps.setString(1, make);
			ps.setString(2, model);
			ps.setInt(3, year);
			ps.setInt(4, mileage);
			ps.setString(5, color);
			
			int theUpdatedCount = ps.executeUpdate();
			if (theUpdatedCount >= 1) {
				updateSuccessful = true;
			}
			
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

		return updateSuccessful;
	}

	public boolean deleteVehicleWithID(int id) throws DBErrorException {
		boolean updateSuccessful = false;
		Connection connection = null;
		
		try {
			
			connection = ds.getConnection();

			String theSqlQueryString = "DELETE FROM VEHICLES WHERE ID = ?";
			
			PreparedStatement ps = connection.prepareStatement(theSqlQueryString);
			ps.setInt(1, id);
			
			int theUpdatedCount = ps.executeUpdate();
			if (theUpdatedCount >= 1) {
				updateSuccessful = true;
			}
			
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

		return updateSuccessful;
	}
}
