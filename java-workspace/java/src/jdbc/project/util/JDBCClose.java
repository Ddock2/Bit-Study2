package jdbc.project.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCClose {
	
	public static void closeConnection(Connection con) {
		if(con == null)
			return;
		
		try {
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closPreparedStatement(PreparedStatement pstmt) {
		if(pstmt == null)
			return;
		
		try {
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
