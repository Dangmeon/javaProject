package ex1;

import java.sql.Connection;
import java.sql.DriverManager;

public class PrdJDBCConn {
	
	public Connection getPrdJDBCConn() {
		
		Connection con = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:29889/freepdb1";
			String user = "sql_user";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, user, pwd);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
}
