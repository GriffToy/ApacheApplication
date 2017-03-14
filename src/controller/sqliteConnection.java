package controller;

import java.sql.*;
import java.time.LocalDate;

import model.Category;
import model.WeaveEvent;


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
	
	public static ResultSet getData(Connection conn, String query){
		
		ResultSet result = null;
		try{
    		
    		PreparedStatement pst = conn.prepareStatement(query);
    		result = pst.executeQuery();
    		
    		pst.close();
    		return result;
    		
    	}catch (Exception e){
    		System.out.println("Error connection!" + e.getMessage());
    	}
		return result;
	}
	
	
}
