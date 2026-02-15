package com.umfrancisco.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String USER = "francisco";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection(String databaseName) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL+databaseName, USER, PASSWORD);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return connection;
	}
}
