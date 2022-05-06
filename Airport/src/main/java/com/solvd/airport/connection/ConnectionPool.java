package com.solvd.airport.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements IConnectionPool {
	private static String url = "jdbc:mysql://127.0.0.1:3306/airport?user=root";
	private String user;
	private String password;
	private static int INITIAL_POOL_SIZE = 10;
	private static List<Connection> connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
	private List<Connection> usedConnections = new ArrayList<>();

	private static ConnectionPool INSTANCE = null;

	private ConnectionPool() {
	}

	private ConnectionPool(String url, String user, String password, List<Connection> pool) {
		ConnectionPool.url = url;
		this.user = user;
		this.password = password;
		ConnectionPool.connectionPool = pool;
	}

	private ConnectionPool(String url, List<Connection> pool) {
		ConnectionPool.url = url;
		ConnectionPool.connectionPool = pool;
	}

	public static ConnectionPool getInstance() throws SQLException {
		if (INSTANCE == null) {
			INSTANCE = new ConnectionPool();
			initializeConnections();
		}
		return INSTANCE;
	}

	public static void initializeConnections() throws SQLException {
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			connectionPool.add(createConnection(url));
		}
	}

	public static ConnectionPool create(String url, String user, String password) throws SQLException {
		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url, user, password));
		}
		return new ConnectionPool(url, user, password, pool);
	}

	@Override
	public Connection getConnection() {
		Connection connection = connectionPool.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}

	@Override
	public boolean releaseConnection(Connection connection) {
		connectionPool.add(connection);
		return usedConnections.remove(connection);
	}

	public static Connection createConnection(String url) throws SQLException {
		return DriverManager.getConnection(url);
	}

	private static Connection createConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public int getSize() {
		return connectionPool.size() + usedConnections.size();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		ConnectionPool.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
