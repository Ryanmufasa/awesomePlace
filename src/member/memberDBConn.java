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
        con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.140:1521:xe", "hr",
            "hr");

    }
}
 
	  
/*
	  String url = "jdbc:oracle:thin:@192.168.1.140:1521:xe";
	  String user = "hr", pw = "hr";

	  Connection con = null;
	  PreparedStatement pstmt = null;
	  ResultSet rs = null;

	  public Connection getConnection() {
		  return con;
	  }

	  public memberDBConn() throws ClassNotFoundException, SQLException {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  con = DriverManager.getConnection(url, user, pw);
*/



//192.168.1.140