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

	public boolean updateVehicle(Vehicle v) {
		// TODO Auto-generated method stub
		return false;
	}
}
