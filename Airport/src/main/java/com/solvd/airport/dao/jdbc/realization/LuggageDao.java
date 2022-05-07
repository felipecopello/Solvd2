package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Luggage;
import com.solvd.airport.interfaces.ILuggageDao;

public class LuggageDao extends abstractJDBCDao implements ILuggageDao {

	public Luggage getById(long id) throws SQLException {
		String query = "Select * from Luggages where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Luggage(rs.getFloat("weight_in_kg"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public List<Luggage> getByPassengerId(long id) throws SQLException {
		String query = "Select * from Luggages join Passengers on Passengers.ID = Luggages.owner_ID where  Passengers.ID=? ";
		List<Luggage> luggages = new ArrayList<Luggage>();
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Luggage luggage = new Luggage(rs.getFloat("weight_in_kg"));
				luggages.add(luggage);
			}
			return luggages;

		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Luggage> getAll() {
		// TODO Auto-generated method stub
		return null;
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
