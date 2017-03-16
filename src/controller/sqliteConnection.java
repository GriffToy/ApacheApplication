package controller;

import java.sql.*;

/**
 * Method to set-up and establish database connection.
 * @author Jorie Fernandez
 *
 */
public class sqliteConnection {
	/** Connection variable */
	Connection conn = null;
	
	/** Method to communicate with the existing database. */
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
