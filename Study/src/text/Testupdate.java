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
			//��������
			Class.forName(driver);
			//�������Ӷ���
			conn = DriverManager.getConnection(url,uname,password);
			//����sql�������
			stmt = (Statement) conn.createStatement();
			String sname = "������";
			//����sql����
			String sql = "delete from studentA where sumn=1";
			//ִ��sql����
			int i = ((java.sql.Statement) stmt).executeUpdate(sql);
			System.out.println("ִ�н����"+i);
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
