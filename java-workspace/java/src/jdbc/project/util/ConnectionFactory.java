package jdbc.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "c##bit";
			String password = "bit";
			
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
}
