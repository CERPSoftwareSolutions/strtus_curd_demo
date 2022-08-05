package com.centris.campus.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class JDBCConnection {
	private static final Logger logger = Logger.getLogger(JDBCConnection.class);

	private static String DriverName = null;
	private static String protocal = null;
	private static String portno = null;
	private static String database = null;
	private static String ipaddress = null;
	private static String username = null;
	private static String password = null;
	
	static {
		try {
			ResourceBundle res = ResourceBundle.getBundle("application");
			DriverName = res.getString("mySqlDriver");
			protocal = res.getString("protocal");
			portno = res.getString("portno");
			database = res.getString("database");
			ipaddress =res.getString("ipaddress");
			username =res.getString("username");
			password =res.getString("password");
			
			logger.info("Starting Database Connection");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		
		Connection conn = null;
		 
		try {
			String driverName = DriverName;
			String hostName = protocal + "://" + ipaddress + ":" + portno+"/";
			String dbName = database;
			String dbuserName = username;
			String dbpassword = password;

			Class.forName(driverName).newInstance();
			Properties props = new Properties();
			props.put("user", dbuserName);
			props.put("password", dbpassword);
			props.put("useSSL", "false");
			props.put("noAccessToProcedureBodies", "true");
			conn = DriverManager.getConnection(hostName + dbName,props);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
