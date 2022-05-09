package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Route;
import com.solvd.airport.interfaces.IRouteDao;

public class RouteDao extends abstractJDBCDao implements IRouteDao {

	public Route getById(long id) throws SQLException {
		String query = "Select * from Routes where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Route(rs.getInt("departure_airport_ID"), rs.getInt("arrival_airport_ID"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Route getByFlightId(long id) throws SQLException {
		String query = "Select * from Routes join Flights on Flights.route_ID=Routes.ID where Routes.ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Route(rs.getInt("departure_airport_ID"), rs.getInt("arrival_airport_ID"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Route> getAll() throws SQLException {
		List<Route> routes = new ArrayList<>();
		String query = "Select * from Routes";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Route route = new Route(rs.getInt("departure_airport_ID"), rs.getInt("arrival_airport_ID"));
				routes.add(route);
			}
			return routes;
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public void save(Route t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Route t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Route t) {
		// TODO Auto-generated method stub

	}

}
