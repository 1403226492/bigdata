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
				pstmt.setString(1, "������"+i);
				pstmt.setString(2, "��ԥ��"+i);
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
			System.out.println("���ݲ���ɹ�!");
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
		
		System.out.println("����ʱ��" + (end - start) +"���룡");
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
				sql ="insert into t_bigdata2(name,teacher) values(" +("'������" +i +"'")+(",'��ԥ��" + i +"'") +");";
 				stmt.execute(sql);
			}
			
			conn.commit();
			System.out.println("���ݲ���ɹ�!");
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
		
		System.out.println("ֱ��ִ��sql����ʱ��" +(end - start) +"���룡");
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
				pstmt.setString(1, "������"+i);
				pstmt.setString(2, "��ԥ��"+i);
				//pstmt.addBatch();
				pstmt.execute();
			}
			
			//pstmt.executeBatch();
			conn.commit();
			System.out.println("���ݲ���ɹ�!");
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
		
		System.out.println("ִ��Ԥ���빲��ʱ��" +(end - start) +"���룡");
	}

	public static void test7() {
		try {
			Class.forName(MYSQL_DRIVER);//ע������
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
		sql.append("'������107��',");
		sql.append("'��ԥ��',");
		sql.append("'2016-07-12',");
		sql.append("'2016-08-29 14:57:12'");
		sql.append(");");
		
		System.out.println(sql);
		try {
			/*
			 * ���������ݿ������
			 */
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
			
			/*
			 * ����ִ�����
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
		 * 1.��ȡ���ݿ������
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
			 * 2.��������
			 */
		    stmt = conn.createStatement();
			boolean result = stmt.execute(sql.toString());
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			/*
			 * 3.�ر���������
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
			 *1.ע������ 
			 */
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		DatabaseMetaData dbMetaData = null;
		/*
		 * 2.��ȡ���ݿ�����
		 */
		try {
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USER, MYSQL_PASSWORD);
			
			/*
			 * 3.�������ݿ�
			 */
			dbMetaData = conn.getMetaData();
			System.out.println("���ݿ�汾��" +dbMetaData.getDatabaseMajorVersion() +"." + dbMetaData.getDatabaseMinorVersion());
			System.out.println("���ݲ�Ʒ�����ƣ�" +dbMetaData.getDatabaseProductName());
			System.out.println("���ݿ��Ʒ�汾��" + dbMetaData.getDatabaseProductVersion());
			System.out.println("char���͵���󳤶ȣ�" + dbMetaData.getMaxCharLiteralLength());
			System.out.println("select�������Բ���ֶ����� " + dbMetaData.getMaxColumnsInSelect());
			System.out.println("һ�������������У�" + dbMetaData.getMaxColumnsInTable());
			System.out.println("group by���������У�" + dbMetaData.getMaxColumnsInGroupBy());
			System.out.println("������󳤶ȣ�" + dbMetaData.getMaxColumnNameLength());
			System.out.println("order by�����������" + dbMetaData.getMaxColumnsInOrderBy());
			System.out.println("���������������" + dbMetaData.getMaxColumnsInIndex());
			System.out.println("���ɴ���������" + dbMetaData.getMaxConnections());
			System.out.println("����г��ȣ�" + dbMetaData.getMaxRowSize());
			System.out.println("��������󳤶ȣ� " + dbMetaData.getMaxTableNameLength());
			System.out.println("��ȡ�ַ���������" + dbMetaData.getStringFunctions());
			System.out.println("��ȡ���ں�����" + dbMetaData.getTimeDateFunctions());
			System.out.println("��ȡ��ѧ������" + dbMetaData.getNumericFunctions());
			System.out.println("��ȡϵͳ������" + dbMetaData.getSystemFunctions());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn !=null && !conn.isClosed()){
					/*
					 * �ر����ݿ�����
					 */
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
