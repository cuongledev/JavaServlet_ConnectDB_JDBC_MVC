package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection createConnection() {
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/incomplete_test";
		String username = "root";
		String password ="";
		
		
		try {
			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			conn = DriverManager.getConnection(url, username, password);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		return conn;
	}
}
