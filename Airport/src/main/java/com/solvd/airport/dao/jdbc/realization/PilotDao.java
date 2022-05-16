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
import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.interfaces.IPilotDao;

public class PilotDao extends AbstractJDBCDao implements IPilotDao {
	private static final Logger LOGGER = LogManager.getLogger(CountryDao.class);
	private ConnectionPool cp = getCp();

	public Pilot getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Pilots where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Pilot(rs.getInt("ID"), rs.getString("pilot_name"), rs.getInt("age"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	public Pilot getByFlightId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Pilots join Flights on Flights.pilot_ID=Pilots.ID where Flights.ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Pilot(rs.getInt("ID"), rs.getString("pilot_name"), rs.getInt("age"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public List<Pilot> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Pilot> pilots = new ArrayList<>();
		String query = "Select * from Pilots";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pilot pilot = new Pilot(rs.getInt("ID"), rs.getString("pilot_name"), rs.getInt("age"));
				pilots.add(pilot);
			}
			return pilots;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public void save(Pilot t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pilot pilot, String[] params) throws SQLException {
		// takes a String[] to update ONLY age, and employer, in that order
		Connection c = cp.getConnection();
		String query = "UPDATE Pilots SET pilot_name=?, age=?, employed_by_airline=? where ID =?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, pilot.getName());
			ps.setInt(2, Integer.parseInt(params[0]));
			ps.setLong(3, Integer.parseInt(params[1]));
			ps.setLong(4, pilot.getPilotId());
			ps.executeUpdate();
			LOGGER.info("Pilot named: " + pilot.getName() + " was updated in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void delete(Pilot t) {
		// TODO Auto-generated method stub

	}

}
