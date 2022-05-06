package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.City;
import com.solvd.airport.interfaces.ICityDao;

public class CityDao extends abstractJDBCDao implements ICityDao {

	public City getById(long id) throws SQLException {
		String query = "Select * from cities where id = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new City(rs.getString("city_name"), rs.getInt("pupulation"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public City getByAirportId(long id) throws SQLException {
		String query = "Select * from airports join cities on cities.ID=airports.city_ID where airports.id=?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new City(rs.getString("city_name"), rs.getInt("pupulation"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<City> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(City t) {
		// TODO Auto-generated method stub

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
