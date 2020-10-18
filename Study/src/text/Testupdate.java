package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Testupdate {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String uname = "C##SCOTT";
		String password = "qazwsx123";
		try {
			//加载驱动
			Class.forName(driver);
			//创建连接对象
			conn = DriverManager.getConnection(url,uname,password);
			//创建sql命令对象
			stmt = (Statement) conn.createStatement();
			String sname = "张三三";
			//创建sql命令
			String sql = "delete from studentA where sumn=1";
			//执行sql命令
			int i = ((java.sql.Statement) stmt).executeUpdate(sql);
			System.out.println("执行结果："+i);
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
