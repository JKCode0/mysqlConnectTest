package test.com.jk.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Statement;

public class LocalConnectorTest {

	private String conn = "jdbc:mysql://localhost";
	private String user = "root";
	private String pwd = "speedDev";
	
	@Before
	public void setUp(){
		System.out.println("@@@@ setup ");
		
		
	}
	
	@Test
	public void connect1() {
		//fail("Not yet implemented");
		
		System.out.println("===== connect1 =========");
		
	}
	
	@Test
	public void jdbcConnect(){
		System.out.println("========== jdbcConnect start =====================");
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(conn, user, pwd);
			
			System.out.println("con=" + con);
			
			Statement st = null;
			ResultSet rs = null;
			
			st = (Statement) con.createStatement();
			rs = st.executeQuery("SHOW DATABASES");
			
			rs = st.getResultSet();
			
			while(rs.next()){
				System.out.println(rs.getNString(1));
			}
			rs.close();
			st.close();
			con.close();
			
			System.out.println("=================================================");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
