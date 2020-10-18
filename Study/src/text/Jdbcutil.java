package text;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbcutil {
	private static String driver;
	private static String url;
	private static String uname;
	private static String password;
	static {
		Properties p = new Properties();
		//��ȡ�����ļ��Ķ�ȡ������
		try {
			InputStream is = Jdbcutil.class.getResourceAsStream("/db.properties");
			p.load(is);
			//��ȡjdbc����
			driver = p.getProperty(driver);
			url = p.getProperty(url);
			uname = p.getProperty(uname);
			password = p.getProperty(password);
			//��������
			Class.forName(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��ȡConnection����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url,uname,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static PreparedStatement getPreparedStatement(Connection conn ,String sql) {
		PreparedStatement ps = null;
		try {
			ps  = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
		
	}
}
