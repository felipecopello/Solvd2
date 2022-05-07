package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.interfaces.IFlightDao;

public class FlightDao extends abstractJDBCDao implements IFlightDao {

	public Flight getById(long id) throws SQLException {
		String query = "Select * from Flights where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Flight(rs.getInt("price_usd"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Flight> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Flight t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Flight t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Flight t) {
		// TODO Auto-generated method stub

	}

}
