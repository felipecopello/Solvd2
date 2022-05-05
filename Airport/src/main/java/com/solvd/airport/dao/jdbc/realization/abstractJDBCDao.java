package com.solvd.airport.dao.jdbc.realization;

import java.sql.SQLException;

import com.solvd.airport.connection.ConnectionPool;

public abstract class abstractJDBCDao {

	private static ConnectionPool cp = setConnection("jdbc:mysql://127.0.0.1:3306/airport?user=root");

	public static ConnectionPool setConnection(String url) {
		ConnectionPool conn = new ConnectionPool();

		try {
			conn = ConnectionPool.create(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public ConnectionPool getCp() {
		return cp;
	}

	public static void setCp(ConnectionPool Cp) {
		cp = Cp;
	}

}
