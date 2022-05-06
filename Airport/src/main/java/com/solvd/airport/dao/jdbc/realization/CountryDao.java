package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICountryDao;

public class CountryDao extends abstractJDBCDao implements ICountryDao {

	public Country getById(long id) throws SQLException {
		String query = "Select * from countries where id = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Country t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Country t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Country t) {
		// TODO Auto-generated method stub

	}

}
