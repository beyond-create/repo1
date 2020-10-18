package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDao {
	public static void main(String[] args){
		ArrayList<Stu> list = new ArrayList<>();
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
			//����sql����
			String sql = "select * from studentA where uname=? and upwd=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			//��ռλ����ֵ��������
			ps.setString(1, uname);
			ps.setString(2, " ");
			
			ResultSet rs =  ps.executeQuery();
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
