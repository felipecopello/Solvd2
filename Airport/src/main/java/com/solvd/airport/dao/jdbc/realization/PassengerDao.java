package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.interfaces.IPassengerDao;

public class PassengerDao extends AbstractJDBCDao implements IPassengerDao {
	private ConnectionPool cp = getCp();

	public Passenger getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Passengers where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Passenger(rs.getString("passenger_name"), rs.getInt("age"), rs.getString("email"),
					rs.getLong("ID"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<Passenger> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Passenger> passengers = new ArrayList<>();
		String query = "Select * from Passengers";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Passenger passenger = new Passenger(rs.getString("passenger_name"), rs.getInt("age"),
						rs.getString("email"), rs.getLong("ID"));
				passengers.add(passenger);
			}
			return passengers;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public void save(Passenger t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Passenger t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Passenger t) {
		// TODO Auto-generated method stub

	}

}
