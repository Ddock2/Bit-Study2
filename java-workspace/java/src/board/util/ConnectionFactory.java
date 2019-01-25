package board.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// 싱글톤 패턴은 적합하지 않으니,
	// 팩토리를 활용(사용시에만 받아오기)
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "hr";
			String password = "hr";
			
			con = DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return con;
	}
}
