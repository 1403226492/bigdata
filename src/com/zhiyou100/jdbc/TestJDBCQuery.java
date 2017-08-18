package com.zhiyou100.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.jdbc.utils.entity.ConfigUtil;
import com.zhiyou100.jdbc.utils.entity.DBEntity;
import com.zhiyou100.jdbc.utils.entity.DBUtils;

public class TestJDBCQuery {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement("select * from t_bigdata where id=?");
			
			pstmt.setInt(1, 999998);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1) +"," + rs.getString(2));
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
