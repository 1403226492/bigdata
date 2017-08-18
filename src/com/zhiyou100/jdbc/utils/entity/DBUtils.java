package com.zhiyou100.jdbc.utils.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static DBEntity entity;
	
	public static void setDBEntity(DBEntity e){
		entity = e;
	}
	
	{
		try {
			Class.forName(entity.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(entity.getUrl(), entity.getUser(), entity.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static boolean closeConnection(Connection conn){
		boolean ret = false;
		
		try {
			if (conn!=null && !conn.isClosed()) {
				conn.close();
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static boolean closeStatement(Statement stmt){
		boolean ret = false;
		
		try {
			if (stmt!=null && !stmt.isClosed()) {
				stmt.close();
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static boolean closeResult(ResultSet rs){
		boolean ret = false;
		
		try {
			if (rs!=null && !rs.isClosed()) {
				rs.close();
				ret = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	public static void executeDDL(String sql){
		Connection connection = getConnection();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
			stmt.execute(sql);
			System.out.println("执行成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行失败！");
		}finally {
			closeStatement(stmt);
			closeConnection(connection);
		}
	}
	
	public static ResultSet executeQuery(String sql){
		ResultSet resultSet = null;
		Connection connection = getConnection();
		Statement stmt = null;
		
		try {
			stmt = connection.createStatement();
			resultSet = stmt.executeQuery(sql);
			System.out.println("执行成功！");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行失败！");
		}finally {
			//closeResult(resultSet);
			//closeStatement(stmt);
			//closeConnection(connection);
		}
		
		return resultSet;
	}
}
