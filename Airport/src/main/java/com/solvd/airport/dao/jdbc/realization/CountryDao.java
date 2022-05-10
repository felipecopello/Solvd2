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
import com.solvd.airport.entities.Country;
import com.solvd.airport.interfaces.ICountryDao;

public class CountryDao extends abstractJDBCDao implements ICountryDao {
	private static final Logger LOGGER = LogManager.getLogger(CountryDao.class);
	private ConnectionPool cp = getCp();

	public Country getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Countries where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getLong("ID"), rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public Country getByCityId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String getByCityIdQuery = "Select * from Cities join Countries on Countries.ID=Cities.country_ID where Cities.ID=?";
		try (PreparedStatement ps = c.prepareStatement(getByCityIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getLong("ID"), rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public Country getByAirportId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String getByCityIdQuery = "Select * from Airports join Cities on Cities.ID = Airports.city_ID join Countries on Countries.ID = Cities.country_ID where Airports.ID=?";
		try (PreparedStatement ps = c.prepareStatement(getByCityIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Country(rs.getLong("ID"), rs.getString("country_name"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<Country> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Country> countries = new ArrayList<>();
		String query = "Select * from Countries";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Country country = new Country(rs.getLong("ID"), rs.getString("country_name"));
				countries.add(country);
			}
			return countries;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void save(Country country) throws SQLException {
		Connection c = cp.getConnection();
		String query = "INSERT INTO Countries (country_name) VALUES (?)";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, country.getName());
			ps.executeUpdate();
			LOGGER.info("Country: " + country.getName() + " was saved in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
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
