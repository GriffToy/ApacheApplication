package controller;

import java.sql.*;


public class sqliteConnection {
	
	Connection conn = null;
	public static Connection dbConnector() {
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:src/data/ApacheDB.sqlite");
			return conn;
		} catch(Exception e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
}
