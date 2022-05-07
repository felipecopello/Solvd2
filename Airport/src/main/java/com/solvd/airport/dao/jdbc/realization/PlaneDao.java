package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IPlaneDao;

public class PlaneDao extends abstractJDBCDao implements IPlaneDao {

	public Plane getById(long id) throws SQLException {
		String query = "Select * from Planes where ID = ?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Plane(rs.getString("model"), rs.getInt("capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public Plane getByFlightId(long id) throws SQLException {
		String query = "Select * from Planes join Flights on Flights.plane_ID=Planes.ID where Planes.ID =?";
		try (Connection c = getCp().getConnection(); PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Plane(rs.getString("model"), rs.getInt("capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	@Override
	public List<Plane> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Plane t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Plane t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Plane t) {
		// TODO Auto-generated method stub

	}

}
