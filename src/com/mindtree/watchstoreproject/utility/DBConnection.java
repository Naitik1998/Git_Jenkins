package com.mindtree.watchstoreproject.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mindtree.watchstoreproject.exception.dao.WatchStoreProjectDaoException;



public class DBConnection {
	private static final String DBURL = "jdbc:mysql://localhost:3306/watchstore";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Welcome123";

	public static Connection getConnection() throws WatchStoreProjectDaoException   {
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

		} catch (ClassNotFoundException e) {
			throw new WatchStoreProjectDaoException(e.getMessage(), e);

		} catch (SQLException e) {
			throw new WatchStoreProjectDaoException("Error in Connection", e);
		}

		return connection;

	}

	public static Connection closeConnection(Connection connection) throws WatchStoreProjectDaoException {

		try {
			connection.close();
		} catch (SQLException e) {
			throw new WatchStoreProjectDaoException("Error in Connection", e);
		}

		return connection;

	}

}
