package com.kiosk.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	/**
	 * 로드
	 */
	static {
		try {
			Class.forName(DBProperties.DRIVER_NAME);
		}catch(ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(DBProperties.URL,
											DBProperties.USER_ID,
											DBProperties.USER_PASSWORD);
	}
	
	
	/**
	 * 닫기
	 */
	public static void closeDb(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null)  rs.close();
			if(st != null)  st.close();
			if(con != null) con.close();
			
		}catch (SQLException e) {
			e.printStackTrace();		}
	}
	
	
	
	
}
