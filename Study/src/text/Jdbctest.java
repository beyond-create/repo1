package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * jdbc的事务管理
 */
public class Jdbctest {
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
			//设置事物为手动提交
			conn.setAutoCommit(false);
			//创建sql命令对象
			stmt = (Statement) conn.createStatement();			
			//创建sql命令
			String sql1 = "update studentA set money=money-100 where snum=19";
			String sql2 = "update studentA set money=money+100 where snum=20";
			//执行sql命令
			try {
				int i1 = ((java.sql.Statement) stmt).executeUpdate(sql1);
				int i2 = ((java.sql.Statement) stmt).executeUpdate(sql2);
				System.out.println("执行结果："+i1+"----"+i2);
				conn.commit();
			}catch(Exception e){
				conn.rollback();
			}
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
