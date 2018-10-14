package br.com.cast.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static String port;
	private static String db;
	private static String user;
	private static String pass;
	
	private ConnectionFactory() {
		
	}
	
	static {
		Properties prop = new Properties();
		
		InputStream in = ConnectionFactory.class.getResourceAsStream("persistence.properties");
		
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		port = prop.getProperty("jdbc.port");
		db = prop.getProperty("jdbc.database");
		user = prop.getProperty("jdbc.user");
		pass = prop.getProperty("jdbc.password");
		
	}
	
	public static Connection getConnection() {
		
		String url = "jdbc:postgresql://localhost:"+port+"/"+db;
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
