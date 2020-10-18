package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Text {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uname = "C##SCOTT";
		String password = "qazwsx123";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,uname,password);
			stmt = (Statement) conn.createStatement();
			String sql = "insert into dept values(50,'stiven',5)";
			int i = ((java.sql.Statement) stmt).executeUpdate(sql);
			System.out.println("Ö´ÐÐ½á¹û£º"+i);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
