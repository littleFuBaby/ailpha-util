package com.ailpha.common.util;

import java.sql.*;
import java.util.Arrays;

/**
 * JDBC Utility
 * 
 * @author ys
 *
 */
public class JDBCUtils {

	private static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/owndb?useSSL=false&serverTimezone=UTC";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";

	private static Connection connection;

	private static Connection getConnection() {
		try {
			if(connection !=null && connection.isClosed()){
				connection = null;
			}
			if (connection == null) {
				Class.forName(DBDRIVER);
				connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
				// not auto commit
				connection.setAutoCommit(false);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return connection;
	}

	private static void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	public static Object[][] query(String sql){
		getConnection();
		Object[][] objectArray = null;
		try {
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			if(set!=null){
				if(set.last()){
					objectArray = new Object[set.getRow()][set.getMetaData().getColumnCount()];
					for(int x=1;x<=set.getMetaData().getColumnCount();x++){
						objectArray[set.getRow()-1][x-1] = set.getObject(x);
					}
				}
				while(set.previous()){
					for(int x=1;x<=set.getMetaData().getColumnCount();x++){
						objectArray[set.getRow()-1][x-1] = set.getObject(x);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			close();
		}
		return objectArray;
	}

	public static int execute(String sql) {
		getConnection();
		int result = 0;
		try {
			Statement statement = connection.createStatement();
			result = statement.executeUpdate(sql);
			connection.commit();
		} catch (Exception e) {
			System.err.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println(e1);
			}
		} finally {
			close();
		}
		return result;
	}
	
	public static int[] executeBatch(String[] sqls){
		if(sqls == null ){
			return null;
		}
		getConnection();
		int[] result = null;
		try {
			Statement statement = connection.createStatement();
			for (String sql : sqls) {
				statement.addBatch(sql);
			}
			result = statement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			System.err.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println(e1);
			}
		} finally {
			close();
		}
		return result;
	}
	
	public static Object[][] preQuery(String sql, Object[] parameters){
		if(sql == null || parameters == null){
			return null;
		}
		getConnection();
		Object[][] objectArray = null;
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			for(int x=1;x<=parameters.length;x++){
				Object obj = parameters[x-1];
				preStatement.setObject(x, obj);
			}
			ResultSet set = preStatement.executeQuery();
			if(set!=null){
				if(set.last()){
					objectArray = new Object[set.getRow()][set.getMetaData().getColumnCount()];
					for(int x=1;x<=set.getMetaData().getColumnCount();x++){
						objectArray[set.getRow()-1][x-1] = set.getObject(x);
					}
				}
				while(set.previous()){
					for(int x=1;x<=set.getMetaData().getColumnCount();x++){
						objectArray[set.getRow()-1][x-1] = set.getObject(x);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			close();
		}
		return objectArray;
	}
	
	public static int preExecute(String sql) {
		getConnection();
		int result = 0;
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			result = preStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			System.err.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println(e1);
			}
		} finally {
			close();
		}
		return result;
	}
	
	public static int[] preExecuteBatch(String sql, Object[][] parameters) {
		if(sql == null || parameters == null){
			return null;
		}
		getConnection();
		int[] result = null;
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			for(int x=0;x<parameters.length;x++){
				for(int y=0;y<parameters[x].length;++y){
					preStatement.setObject(y+1, parameters[x][y]);
				}
				preStatement.addBatch();
			}
			result = preStatement.executeBatch();
			connection.commit();
		} catch (Exception e) {
			System.err.println(e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.err.println(e1);
			}
		} finally {
			close();
		}
		return result;
	}
	
	public static void main(String[] args) {
		// insert
		String sql = "INSERT INTO USER(name,sex) values ('spicy_0',2)";
		System.out.println(execute(sql));
		
		System.out.println("*******************************************");
		
		// batch
		String[] sqls = new String[]{
				"INSERT INTO USER(name,sex) values ('spicy_1',2)",
				"INSERT INTO USER(name,sex) values ('spicy_2',2)",
				"INSERT INTO USER(name,sex) values ('spicy_3',2)"
		};
		int[] result = executeBatch(sqls);
		System.out.println(Arrays.toString(result));
		
		System.out.println("*******************************************");
		
		String str = "INSERT INTO USER(name,sex) values (?,?)";
		Object[][] parameters = new Object[][]{{"spicy_8",2},{"spicy_9",2},{"spicy_7",2}};
		int []res = preExecuteBatch(str,parameters);
		System.out.println(Arrays.toString(res));
		
		System.out.println("*******************************************");
		
		String sqlQuery = "select * from user;";
		Object[][] objects = query(sqlQuery);
		if(objects!=null){
			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					System.out.print(object + "\t");
				}
				System.out.println();
			}
		}
		
		System.out.println("*******************************************");
		
		String sqlQry = "select * from user where uid > ? and name like concat('%',concat(?,'%')) and sex = ? ";
		Object[] parameter = new Object[]{2,"sp",2};
		Object[][] objs = preQuery(sqlQry,parameter);
		if(objs!=null){
			for (Object[] objects2 : objs) {
				for (Object object : objects2) {
					System.out.print(object + "\t");
				}
				System.out.println();
			}
		}
		
	}

}
