package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICountryDao;

public class CountryDao extends abstractJDBCDao implements ICountryDao {

	public Country getById(long id) throws SQLException {
		String query = "Select * from Countries where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Country getByCityId(long id) throws SQLException {
		String getByCityIdQuery = "Select * from Cities join Countries on Countries.ID=Cities.country_ID where Cities.ID=?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(getByCityIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Country getByAirportId(long id) throws SQLException {
		String getByCityIdQuery = "Select * from Airports join Cities on Cities.ID = Airports.city_ID join Countries on Countries.ID = Cities.country_ID where Airports.ID=?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(getByCityIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Country> getAll() throws SQLException {
		List<Country> countries = new ArrayList<>();
		String query = "Select * from Countries";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Country country = new Country(rs.getString("country_name"));
				countries.add(country);
			}
			return countries;
		} catch (SQLException e) {
			throw new SQLException();
		}
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
