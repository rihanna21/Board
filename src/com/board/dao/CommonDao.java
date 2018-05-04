package com.board.dao;

import java.sql.*;

public class CommonDao {
	private final String driverName = "org.postgresql.Driver";
	private final String url = "jdbc:postgresql:db_board";
	private final String db_id = "postgres";
	private final String db_pw = "new1234!";
	
	private Connection conn = null;
	private Statement stmt = null;
	
	public Statement openConnection() {
		try{
		    Class.forName(driverName);
		    
		    conn = DriverManager.getConnection(url, db_id, db_pw);
		    
		    stmt = conn.createStatement();
		}catch(Exception e) {
			System.err.println("Database Connection Something Problem.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return stmt;
	}
	
	public void closeConnection() {
		try {
			if(!conn.isClosed())
				conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
