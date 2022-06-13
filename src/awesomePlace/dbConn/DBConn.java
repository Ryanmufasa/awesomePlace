package awesomePlace.dbConn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConn {

	private Connection con;
	private DataSource ds;
	
	public DBConn() {
		
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
		}catch(NamingException ne){
			ne.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		try {
			con = ds.getConnection();
			System.out.println("DBCP 연동 성공 ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	

}
