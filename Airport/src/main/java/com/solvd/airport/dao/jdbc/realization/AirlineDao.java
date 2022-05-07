package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.interfaces.IAirlineDao;

public class AirlineDao extends abstractJDBCDao implements IAirlineDao {

	public Airline getById(long id) throws SQLException {
		String query = "Select * from Airlines where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Airline getByPilotId(long id) throws SQLException {
		String getByPilotIdQuery = "Select * from Pilots join Airlines on Airlines.ID=Pilots.employed_by_airline where Pilots.ID=?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(getByPilotIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Airline> getAll() throws SQLException {
		List<Airline> airlines = new ArrayList<>();
		String query = "Select * from Airlines";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Airline airline = new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
				airlines.add(airline);
			}
			return airlines;
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public void save(Airline t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Airline t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Airline t) {
		// TODO Auto-generated method stub

	}

}
