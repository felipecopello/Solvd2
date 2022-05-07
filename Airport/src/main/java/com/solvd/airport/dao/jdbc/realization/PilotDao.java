package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Pilot;
import com.solvd.airport.interfaces.IPilotDao;

public class PilotDao extends abstractJDBCDao implements IPilotDao {

	public Pilot getById(long id) throws SQLException {
		String query = "Select * from Pilots where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Pilot(rs.getInt("ID"), rs.getString("pilot_name"), rs.getInt("age"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Pilot getByFlightId(long id) throws SQLException {
		String query = "Select * from Pilots join Flights on Flights.pilot_ID=Pilots.ID where Flights.ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Pilot(rs.getInt("ID"), rs.getString("pilot_name"), rs.getInt("age"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Pilot> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pilot t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Pilot t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Pilot t) {
		// TODO Auto-generated method stub

	}

}
