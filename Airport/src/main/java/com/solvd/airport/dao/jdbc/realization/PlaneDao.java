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
import com.solvd.airport.entities.Plane;
import com.solvd.airport.interfaces.IPlaneDao;

public class PlaneDao extends AbstractJDBCDao implements IPlaneDao {
	private static final Logger LOGGER = LogManager.getLogger(PlaneDao.class);
	private ConnectionPool cp = getCp();

	public Plane getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Planes where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Plane(rs.getLong("ID"), rs.getString("model"), rs.getInt("capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	public Plane getByFlightId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Planes join Flights on Flights.plane_ID=Planes.ID where Planes.ID =?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Plane(rs.getLong("ID"), rs.getString("model"), rs.getInt("capacity"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public List<Plane> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Plane> planes = new ArrayList<>();
		String query = "Select * from Planes";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Plane plane = new Plane(rs.getLong("ID"), rs.getString("model"), rs.getInt("capacity"));
				planes.add(plane);
			}
			return planes;
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	@Override
	public void save(Plane t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Plane plane) throws SQLException {
		Connection c = cp.getConnection();
		String query = "UPDATE Planes SET model=?, capacity=? where ID =?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, plane.getModel());
			ps.setInt(2, plane.getCapacity());
			ps.setLong(3, plane.getPlaneId());
			ps.executeUpdate();
			LOGGER.info("Plane with ID: " + plane.getPlaneId() + " was updated in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void delete(Plane t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Plane t, String[] params) {
		// TODO Auto-generated method stub

	}

}
