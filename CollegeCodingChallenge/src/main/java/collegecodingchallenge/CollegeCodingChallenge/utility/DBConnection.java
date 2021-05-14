package collegecodingchallenge.CollegeCodingChallenge.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static String JDBCURL = "jdbc:mysql://127.0.0.1:3306/codingchallenge";
	private static String USERNAME = "root";
	private static String PASS = "9909";

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(JDBCURL, USERNAME, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return con;

	}

}
