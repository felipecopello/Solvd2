package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Passenger;
import com.solvd.airport.interfaces.IPassengerDao;

public class PassengerDao extends abstractJDBCDao implements IPassengerDao {

	public Passenger getById(long id) throws SQLException {
		String query = "Select * from passengers where id = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Passenger(rs.getString("passenger_name"), rs.getInt("age"), rs.getString("email"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Passenger> getAll() {
		// TODO Auto-generated method stub
		return null;
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
