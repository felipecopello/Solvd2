package com.solvd.airport.dao.jdbc.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.solvd.airport.connection.ConnectionPool;
import com.solvd.airport.connection.abstractJDBCDao;
import com.solvd.airport.entities.Airline;
import com.solvd.airport.interfaces.IAirlineDao;

public class AirlineDao extends abstractJDBCDao implements IAirlineDao {
	private ConnectionPool cp = getCp();

	public Airline getById(long id) throws SQLException {
		Connection c = cp.getConnection();
		String query = "Select * from Airlines where ID = ?";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}

	}

	public Airline getByPilotId(long id) throws SQLException {
		Connection c = cp.getConnection();
		String getByPilotIdQuery = "Select * from Pilots join Airlines on Airlines.ID=Pilots.employed_by_airline where Pilots.ID=?";
		try (PreparedStatement ps = c.prepareStatement(getByPilotIdQuery);) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public List<Airline> getAll() throws SQLException {
		Connection c = cp.getConnection();
		List<Airline> airlines = new ArrayList<>();
		String query = "Select * from Airlines";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Airline airline = new Airline(rs.getString("airline_name"), rs.getInt("working_planes"));
				airlines.add(airline);
			}

		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
		return airlines;
	}

	@Override
	public void save(Airline airline) throws SQLException {
		Connection c = cp.getConnection();
		String query = "INSERT INTO Airlines (airline_name, working_planes) VALUES (?,?)";
		try (PreparedStatement ps = c.prepareStatement(query);) {
			ps.setString(1, airline.getName());
			ps.setInt(2, airline.getWorkingPlanes());
			ps.executeUpdate();
			System.out.println("Airline: " + airline.getName() + " was saved in the database");
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			cp.releaseConnection(c);
		}
	}

	@Override
	public void update(Airline airline, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Airline airline) {
		// TODO Auto-generated method stub

	}

}
