package com.solvd.airport.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool implements IConnectionPool {
	private String url;
	private String user;
	private String password;
	private List<Connection> connectionPool;
	private List<Connection> usedConnections = new ArrayList<>();
	private static int INITIAL_POOL_SIZE = 10;

	public ConnectionPool() {
	}

	public ConnectionPool(String url, String user, String password, List<Connection> pool) {
		this.url = url;
		this.user = user;
		this.password = password;
		this.connectionPool = pool;
	}

	public ConnectionPool(String url, List<Connection> pool) {
		this.url = url;
		this.connectionPool = pool;
	}

	public static ConnectionPool getInstance() {
		return new ConnectionPool();
	}

	public static ConnectionPool create(String url) throws SQLException {
		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url));
		}
		return new ConnectionPool(url, pool);
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
		this.url = url;
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
