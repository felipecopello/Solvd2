package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.dao.interfaces.IPilotDao;
import com.solvd.airport.entities.Pilot;

public class PilotDao extends abstractJDBCDao implements IPilotDao {
	private String query = "Select * from pilots where id = ?";

	public Pilot getById(long id) throws SQLException {

		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Pilot(rs.getString("pilot_name"), rs.getInt("age"), rs.getString("employed_by_airline"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	// Preguntar que hay que hacer con los metodos heredados de la IEntityDao
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
