package com.zhiyou100.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zhiyou100.jdbc.utils.entity.DBUtils;

public class TestGeneratedKey {
	private static final String MYSQL_URL_FINAL = "jdbc:mysql://192.168.7.182:3306/baobao?user=baobao&password=123456&useUnicode=true&characterEncoding=utf-8&useServerPrepStmts=true&cachePrepStmts=true";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		
		try {
			conn = DriverManager.getConnection(MYSQL_URL_FINAL);
			pstmt = conn.prepareStatement("insert into t_bigdata(name) values(?)", Statement.RETURN_GENERATED_KEYS) ;
			
			pstmt.setString(1, "ÄãºÃ°¡");
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeResult(rs);
			DBUtils.closeStatement(pstmt);
			DBUtils.closeConnection(conn);
		}
	}

}
