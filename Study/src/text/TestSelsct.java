package text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * jdbc�Ĳ�ѯ
 */
public class TestSelsct {
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
			//����sql�������
			stmt = (Statement) conn.createStatement();
			//����sql����
			String sql = "select * from studentA";
			//ִ��sql����
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
			list = getStudentInfo(rs);
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
	public static ArrayList<Stu> getStudentInfo(ResultSet rs){
		ArrayList<Stu> list = new ArrayList<>();
		try {
			while(rs.next()) {
				Stu stu = new Stu();
				stu.setSnumber(rs.getInt("snum"));
				stu.setSname(rs.getString("sname"));
				stu.setMoney(rs.getDouble("money"));
				stu.setAge(rs.getInt("sage"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
