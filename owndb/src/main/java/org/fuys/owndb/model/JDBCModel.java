package org.fuys.owndb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDBC model from java original code
 * @author ys
 *
 */
public class JDBCModel {
	
	private static Logger logger = LoggerFactory.getLogger(JDBCModel.class);
	
	/**
	 * MySql-connector-java 6.0.6 version<br>
	 * It is different from the formal versions<br>
	 * It depends on MySql database
	 * 
	 */
	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	/**
	 * MySql 5.7 requirement<br>
	 * It is different from the formal version<br>
	 * It depends on MySql database<br>
	 * Be careful of SSL in the MySql 5.7.+
	 */
	private static String url = "jdbc:mysql://localhost:3306/owndb?useSSL=false&serverTimezone=UTC";
	private static String userName = "root";
	private static String password = "admin";
	
	/**
	 * database connection class
	 */
	private static Connection connect = null;
	/**
	 * static code block has highest priority execution<br>
	 * in this class
	 */
	static {
		try {
			// loading database driver class
			Class.forName(driverClass);
			// get database connection
			connect = DriverManager.getConnection(url, userName, password);
		} catch (Exception e) {
			logger.error("DriverManager getConnection Exception", e);
		}
	}
	
	/**
	 * define insert method
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int insert(String sql ,String[]parameters){
		logger.info("Sql --> {}", sql);
		logger.info("Parameters --> {}", Arrays.toString(parameters));
		int result = 0;
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			for(int x=1;x<=parameters.length;x++){
				pre.setString(x, parameters[x-1]);
			}
			result = pre.executeUpdate();
			logger.info("Result --> {}", result);
		} catch (Exception e) {
			logger.error("Insert operate exception -->", e);
		}
		return result;
	}
	
	/**
	 * define update method
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int update(String sql ,String[]parameters){
		logger.info("Sql --> {}" ,sql);
		logger.info("parameters --> {}", Arrays.toString(parameters));
		int result = 0;
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			for(int x=1;x<=parameters.length;x++){
				pre.setString(x, parameters[x-1]);
			}
			result = pre.executeUpdate();
			logger.info("Result --> {}",result);
		} catch (Exception e) {
			logger.error("Update operate exception -->", e);
		}
		return result;
	}
	
	/**
	 * define delete method
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int delete(String sql,String[]parameters){
		logger.info("Sql --> {}" ,sql);
		logger.info("parameters --> {}", Arrays.toString(parameters));
		int result = 0;
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			for(int x=1;x<=parameters.length;x++){
				pre.setString(x, parameters[x-1]);
			}
			result = pre.executeUpdate();
			logger.info("Result --> {}",result);
		} catch (Exception e) {
			logger.error("Delete operate exception -->", e);
		}
		return result;
	}
	
	/**
	 * define query method
	 * @param sql
	 * @param parameters
	 * @return
	 */
	public static int query(String sql,String[]parameters){
		logger.info("Sql --> {}" ,sql);
		logger.info("parameters --> {}", Arrays.toString(parameters));
		int result = 0;
		try {
			PreparedStatement pre = connect.prepareStatement(sql);
			for(int x=1;x<=parameters.length;x++){
				pre.setString(x, parameters[x-1]);
			}
			ResultSet resultSet = pre.executeQuery();
			logger.info("Result ------------------------->");
			String strResult = null;
			while(resultSet.next()){
				result++;
				strResult = "";
				for(int y=1;y<=resultSet.getMetaData().getColumnCount();y++){
					strResult += resultSet.getMetaData().getColumnName(y)
							+ "=" + resultSet.getString(y) + " ,";
				}
				logger.info("MetaData {} --> {}",resultSet.getRow(),strResult.substring(0, strResult.lastIndexOf(",")));
			}
			if(strResult == null){
				logger.info("MetaData is NULL");
			}
		} catch (Exception e) {
			result = -1;
			logger.error("Query operate exception -->", e);
		}
		logger.info("Total row --> {}", result);
		return result;
	}
	
}
