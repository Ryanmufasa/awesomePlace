package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class memberDBConn {

	private Connection con;
	 
	public Connection getConnection() {
		return con;
	}
	
	public memberDBConn() throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	}
}
