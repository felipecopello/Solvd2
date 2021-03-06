package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.entities.AirlineInAirport;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.interfaces.IAirlineInAirportDao;

public class AirlineInAirportDao extends AbstractJDBCDao implements IAirlineInAirportDao {
	private ConnectionPool cp = getCp();

	public AirlineInAirport getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airlines_In_Airports where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new AirlineInAirport(rs.getInt("airline_ID"), rs.getInt("airport_ID"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public List<Airport> getAirportsByAirlineId(long id) throws SQLException {
		Connection c = cp.getConnection();
		List<Airport> airports = new ArrayList<>();
		String query = "Select * from Airlines_In_Airports join Airports on Airports.ID = Airlines_In_Airports.airport_ID where airline_ID=?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Airport airport = new Airport(rs.getString("airport_name"), rs.getInt("planes_capacity"));
				airports.add(airport);
			}
			return airports;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<AirlineInAirport> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(AirlineInAirport t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(AirlineInAirport t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(AirlineInAirport t) {
		// TODO Auto-generated method stub

	}

}
