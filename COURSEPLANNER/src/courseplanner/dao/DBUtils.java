package courseplanner.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtils {
	final static String url;
	final static String name;
	final static String password;
	
	// code to load driver class
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Unable to load driver class");
		}
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		url = bundle.getString("url");
		name = bundle.getString("name");
		password = bundle.getString("password");
		//System.out.println("loaded");
		
	}
	
	/**
	 * It creates a connection to the database
	 * @return it returns a Connection Object
	 * @throws SQLException
	 */
	static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url, name, password);
		return conn;
	}
	
	/**
	 * It closes the connection to database
	 * @param conn(It accepts Connection obj as a parameter)
	 */
	static void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
