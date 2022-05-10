package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Flight;
import com.solvd.airport.interfaces.IFlightDao;

public class FlightDao extends abstractJDBCDao implements IFlightDao {
	private static final Logger LOGGER = LogManager.getLogger(FlightDao.class);
	private ConnectionPool cp = getCp();

	public Flight getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Flights where ID = ?";

		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Flight(rs.getLong("ID"), rs.getInt("price_usd"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<Flight> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Flight> flights = new ArrayList<>();
		String query = "Select * from Flights";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Flight flight = new Flight(rs.getLong("ID"), rs.getInt("price_usd"));
				flights.add(flight);
			}
			return flights;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
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
	public void delete(Flight flight) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Delete from Flights where ID = ?";

		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, flight.getFlightId());
			ps.executeUpdate();
			LOGGER.info("Flight: " + flight.getFlightId() + " was deleted from the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

}
