package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.AbstractJDBCDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.interfaces.ILuggageDao;

public class LuggageDao extends AbstractJDBCDao implements ILuggageDao {
	private ConnectionPool cp = getCp();

	public Luggage getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Luggages where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Luggage(rs.getFloat("weight_in_kg"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	public List<Luggage> getByPassengerId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Luggages join Passengers on Passengers.ID = Luggages.owner_ID where  Passengers.ID=? ";
		List<Luggage> luggages = new ArrayList<Luggage>();
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Luggage luggage = new Luggage(rs.getFloat("weight_in_kg"));
				luggages.add(luggage);
			}
			return luggages;

		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public List<Luggage> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Luggage> luggages = new ArrayList<>();
		String query = "Select * from Luggages";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Luggage luggage = new Luggage(rs.getFloat("weight_in_kg"));
				luggages.add(luggage);
			}
			return luggages;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public void save(Luggage t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Luggage t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Luggage t) {
		// TODO Auto-generated method stub

	}

}
