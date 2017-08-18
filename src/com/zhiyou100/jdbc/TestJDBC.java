package com.zhiyou100.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zhiyou100.jdbc.utils.entity.ConfigUtil;
import com.zhiyou100.jdbc.utils.entity.DBEntity;
import com.zhiyou100.jdbc.utils.entity.DBUtils;

public class TestJDBC {
	private static final String MYSQL_DRIVER="com.mysql.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://192.168.7.182:3306/baobao?useUnicode=true&characterEncoding=utf-8";
	private static final String MYSQL_USER="baobao";
	private static final String MYSQL_PASSWORD="123456";

	
	private static final String MYSQL_URL_FINAL = "jdbc:mysql://192.168.7.182:3306/baobao?user=baobao&password=123456&useUnicode=true&characterEncoding=utf-8&useServerPrepStmts=true&cachePrepStmts=true";
	public static void main(String[] args) {
//		insertStmt();
//		insertPstmt();
		createTable("t_bigdata3");
		insertReal("t_bigdata3");
	}

	public static void query1() {
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		ResultSet rs = DBUtils.executeQuery("select * from t_bigdata");
		try {
			while(rs.next()){
				System.out.print(rs.getString("name")+",");
				System.out.println(rs.getString("teacher"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeResult(rs);
		}
	}

	public static void insertReal(String tableName) {
		long start = System.currentTimeMillis();
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into "+ tableName + " (name,teacher) values (?,?)";
		boolean autoCommit = false;
		try {
			conn = DriverManager.getConnection(MYSQL_URL_FINAL);
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			for(int i=1;i<1000000;i++){
				pstmt.setString(1, "大数据"+i);
				pstmt.setString(2, "韩豫博"+i);
				pstmt.addBatch();
				if(i % 1000 == 0){
					try {
						pstmt.executeBatch();
						conn.commit();
					} catch (Exception e) {
						conn.rollback();
						e.printStackTrace();
					}
				}
			}
			
			pstmt.executeBatch();
			conn.commit();
			System.out.println("数据插入成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(autoCommit);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(pstmt != null && !pstmt.isClosed()){
					pstmt.close();
				}
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("共用时：" + (end - start) +"毫秒！");
	}

	public static void insertStmt() {
		long start = System.currentTimeMillis();
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		Statement stmt = null;
		
		boolean autoCommit = false;
		try {
			conn = DriverManager.getConnection(MYSQL_URL_FINAL);
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			String sql = "";
			for(int i=1;i<1000000;i++){
				sql ="insert into t_bigdata2(name,teacher) values(" +("'大数据" +i +"'")+(",'韩豫博" + i +"'") +");";
 				stmt.execute(sql);
			}
			
			conn.commit();
			System.out.println("数据插入成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(autoCommit);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(stmt != null && !stmt.isClosed()){
					stmt.close();
				}
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("直接执行sql共耗时：" +(end - start) +"毫秒！");
	}
	public static void insertPstmt() {
		long start = System.currentTimeMillis();
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into t_bigdata(name,teacher) values (?,?)";
		boolean autoCommit = false;
		try {
			conn = DriverManager.getConnection(MYSQL_URL_FINAL);
			autoCommit = conn.getAutoCommit();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			
			for(int i=1;i<1000000;i++){
				pstmt.setString(1, "大数据"+i);
				pstmt.setString(2, "韩豫博"+i);
				//pstmt.addBatch();
				pstmt.execute();
			}
			
			//pstmt.executeBatch();
			conn.commit();
			System.out.println("数据插入成功!");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.setAutoCommit(autoCommit);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if(pstmt != null && !pstmt.isClosed()){
					pstmt.close();
				}
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("执行预编译共耗时：" +(end - start) +"毫秒！");
	}

	public static void test7() {
		try {
			Class.forName(MYSQL_DRIVER);//注册驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;
		Statement stmt = null;
		
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("insert into t_bigdata(");
		sql.append("name,");
		sql.append("teacher,");
		sql.append("start_date,");
		sql.append("start_time");
		sql.append(")");
		sql.append(" values(");
		sql.append("'大数据107班',");
		sql.append("'韩豫博',");
		sql.append("'2016-07-12',");
		sql.append("'2016-08-29 14:57:12'");
		sql.append(");");
		
		System.out.println(sql);
		try {
			/*
			 * 建立和数据库的连接
			 */
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
			
			/*
			 * 处理执行语句
			 */
			stmt = conn.createStatement();
			
			boolean ret = stmt.execute(sql.toString());
			System.out.println(ret);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null && !stmt.isClosed()){
					stmt.close();
				}
				if(conn != null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test6() {
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		DBUtils.executeDDL("drop table t_bigdata;");
	}

	public static void test5() {
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		StringBuffer sql = new StringBuffer();
		sql.append("create  table t_bigdata2(");
		sql.append(" id int primary key auto_increment, ");
		sql.append(" name varchar(200) not null, ");
		sql.append(" teacher varchar(200), ");
		sql.append(" start_date date, ");
		sql.append(" start_time timestamp ");
		sql.append(");");
		DBUtils.executeDDL(sql.toString());
	}

	public static void createTable(String tableName) {
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		
		/*
		 * 1.获取数据库的连接
		 */
		Connection conn = DBUtils.getConnection();
		Statement stmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("create table ");
		sql.append(tableName);
		sql.append(" (");
		sql.append(" id int primary key auto_increment, ");
		sql.append(" name varchar(200) not null, ");
		sql.append(" teacher varchar(200), ");
		sql.append(" start_date date, ");
		sql.append(" start_time timestamp ");
		sql.append(");");
		try {
			/*
			 * 2.操作数据
			 */
		    stmt = conn.createStatement();
			boolean result = stmt.execute(sql.toString());
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			/*
			 * 3.关闭语句和连接
			 */
			DBUtils.closeStatement(stmt);
			DBUtils.closeConnection(conn);
		}
	}

	public static void test3() {
		DBEntity entity = ConfigUtil.getInstance().getEntity("mysql");
		DBUtils.setDBEntity(entity);
		Connection conn = DBUtils.getConnection();
		try {
			System.out.println(conn.getAutoCommit());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtils.closeConnection(conn);
	}

	public static void test2() {
		Connection conn = null;
		System.setProperty("jdbc.drivers", MYSQL_DRIVER);
		Properties properties = new Properties();
		properties.setProperty("user", MYSQL_USER);
		properties.setProperty("password", MYSQL_PASSWORD);
		try {
			conn = DriverManager.getConnection(MYSQL_URL,properties);
			System.out.println(conn.getMetaData().getMaxColumnsInTable());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void test1() {
		try {
			/*
			 *1.注册驱动 
			 */
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		DatabaseMetaData dbMetaData = null;
		/*
		 * 2.获取数据库连接
		 */
		try {
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
			
			/*
			 * 3.操作数据库
			 */
			dbMetaData = conn.getMetaData();
			System.out.println("数据库版本：" +dbMetaData.getDatabaseMajorVersion() +"." + dbMetaData.getDatabaseMinorVersion());
			System.out.println("数据产品的名称：" +dbMetaData.getDatabaseProductName());
			System.out.println("数据库产品版本：" + dbMetaData.getDatabaseProductVersion());
			System.out.println("char类型的最大长度：" + dbMetaData.getMaxCharLiteralLength());
			System.out.println("select中最多可以查的字段数： " + dbMetaData.getMaxColumnsInSelect());
			System.out.println("一个表中最多多少列：" + dbMetaData.getMaxColumnsInTable());
			System.out.println("group by中最多多少列：" + dbMetaData.getMaxColumnsInGroupBy());
			System.out.println("列名最大长度：" + dbMetaData.getMaxColumnNameLength());
			System.out.println("order by中最大列数：" + dbMetaData.getMaxColumnsInOrderBy());
			System.out.println("索引中最大列数：" + dbMetaData.getMaxColumnsInIndex());
			System.out.println("最大可打开连接数：" + dbMetaData.getMaxConnections());
			System.out.println("最大行长度：" + dbMetaData.getMaxRowSize());
			System.out.println("表名的最大长度： " + dbMetaData.getMaxTableNameLength());
			System.out.println("获取字符串函数：" + dbMetaData.getStringFunctions());
			System.out.println("获取日期函数：" + dbMetaData.getTimeDateFunctions());
			System.out.println("获取数学函数：" + dbMetaData.getNumericFunctions());
			System.out.println("获取系统函数：" + dbMetaData.getSystemFunctions());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null && !conn.isClosed()){
					/*
					 * 关闭数据库连接
					 */
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
