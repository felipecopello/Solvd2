package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.entities.Airport;
import com.solvd.airport.interfaces.IAirportDao;

public class AirportDao extends AbstractJDBCDao implements IAirportDao {
	private ConnectionPool cp = getCp();

	public Airport getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airports where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airport(rs.getLong("ID"), rs.getString("airport_name"), rs.getInt("planes_capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public Airport getDepartureAirportByRouteId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airports join Routes on Routes.departure_airport_ID=Airports.ID where Routes.ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airport(rs.getLong("ID"), rs.getString("airport_name"), rs.getInt("planes_capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public Airport getArrivalAirportByRouteId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airports join Routes on Routes.arrival_airport_ID=Airports.ID where Routes.ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airport(rs.getLong("ID"), rs.getString("airport_name"), rs.getInt("planes_capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<Airport> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Airport> airports = new ArrayList<>();
		String query = "Select * from Airports";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Airport airport = new Airport(rs.getInt("ID"), rs.getString("airport_name"),
						rs.getInt("planes_capacity"));
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
	public void save(Airport airport) throws SQLException {
		Connection c = cp.getConnection();
		String query = "INSERT INTO Airports (airport_name, planes_capacity, city_ID) VALUES (?,?,?)";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, airport.getName());
			ps.setInt(2, airport.getPlanesCapacity());
			ps.setLong(3, airport.getCity().getCityId());
			ps.executeUpdate();
			System.out.println("Airport: " + airport.getName() + " was saved in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
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
