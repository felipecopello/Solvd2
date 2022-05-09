package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.interfaces.IPassengerDao;

public class PassengerDao extends abstractJDBCDao implements IPassengerDao {

	public Passenger getById(long id) throws SQLException {
		String query = "Select * from Passengers where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Passenger(rs.getString("passenger_name"), rs.getInt("age"), rs.getString("email"),
					rs.getLong("ID"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Passenger> getAll() throws SQLException {
		List<Passenger> passengers = new ArrayList<>();
		String query = "Select * from Passengers";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Passenger passenger = new Passenger(rs.getString("passenger_name"), rs.getInt("age"),
						rs.getString("email"), rs.getLong("ID"));
				passengers.add(passenger);
			}
			return passengers;
		} catch (SQLException e) {
			throw new SQLException();
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
