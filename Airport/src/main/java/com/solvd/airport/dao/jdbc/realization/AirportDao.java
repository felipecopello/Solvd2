package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.interfaces.IAirportDao;

public class AirportDao extends abstractJDBCDao implements IAirportDao {

	public Airport getById(long id) throws SQLException {
		String query = "Select * from Airports where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airport(rs.getString("airport_name"), rs.getInt("planes_capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Airport> getAll() throws SQLException {
		List<Airport> airports = new ArrayList<>();
		String query = "Select * from Airports";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Airport airport = new Airport(rs.getInt("ID"), rs.getString("airport_name"),
						rs.getInt("planes_capacity"));
				airports.add(airport);
			}
			return airports;
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public void save(Airport t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Airport t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Airport t) {
		// TODO Auto-generated method stub

	}

}
