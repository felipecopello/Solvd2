package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.entities.City;
import com.solvd.airport.interfaces.ICityDao;

public class CityDao extends AbstractJDBCDao implements ICityDao {
	private static final Logger LOGGER = LogManager.getLogger(CityDao.class);
	private ConnectionPool cp = getCp();

	public City getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Cities where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new City(rs.getLong("ID"), rs.getString("city_name"), rs.getInt("pupulation"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	public City getByAirportId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airports join Cities on Cities.ID=Airports.city_ID where Airports.ID=?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new City(rs.getLong("ID"), rs.getString("city_name"), rs.getInt("pupulation"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<City> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<City> cities = new ArrayList<>();
		String query = "Select * from Cities";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				City city = new City(rs.getLong("ID"), rs.getString("city_name"), rs.getInt("pupulation"));
				cities.add(city);
			}
			return cities;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void save(City city) throws SQLException {
		Connection c = cp.getConnection();
		String query = "INSERT INTO Cities (city_name, country_ID, pupulation) VALUES (?,?,?)";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, city.getName());
			ps.setLong(2, city.getCountry().getCountryId());
			ps.setInt(3, city.getPopulation());
			ps.executeUpdate();
			LOGGER.info("City: " + city.getName() + " was saved in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void update(City t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(City t) {
		// TODO Auto-generated method stub

	}

}
