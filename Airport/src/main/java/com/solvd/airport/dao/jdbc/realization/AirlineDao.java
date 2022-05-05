package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.dao.interfaces.IAirlineDao;
import com.solvd.airport.entities.Airline;

public class AirlineDao extends abstractJDBCDao implements IAirlineDao {
	private String query = "Select * from airlines where id = ?";

	public Airline getById(long id) throws SQLException {

		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Airline> getAll() {
		// TODO Auto-generated method stub
		return null;
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
