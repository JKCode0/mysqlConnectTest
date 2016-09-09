package test.com.jk.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.Statement;

public class WebDBConnectTest {

	private String url = "jdbc:mysql://1.11.169.27:3336/DEV_DB"; // url 접속 DB name
	private String user = "devuser1";		// User
	private String pwd = "1q2w3e4r5t";		// pwd
	private String query = "show tables";	//
	
	
	
	@Before
	public void setUp(){
		System.out.println("================ setup ===================");
		
	}
	
	@After
	public void endSetUp(){
		System.out.println("==========================================");
	}
	
	//
	@Test
	public void connectWebjdbcTest(){
		System.out.println("========== jdbcConnect start =====================");
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("con=" + con);
			
			Statement st = null;
			ResultSet rs = null;
			
			st = (Statement) con.createStatement();
			rs = st.executeQuery(query);
			
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
	
	//---------------------------------------------------------------
	// Insert, update, delete
	
	
	//-------------------------------------------------------
	@Test
	public void insertTest(){
		Connection conn = null;
		PreparedStatement preStat = null;
		String insertSql = "INSERT INTO TB_MENU (MENU_ID, MENU_NAME, MENU_DESC, MENU_INFO, MENU_TITLE)" 
						 + " VALUES (?, ?, ?, ?, ?)";
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			conn.setAutoCommit(false);
			
			preStat = conn.prepareStatement(insertSql);
			
			preStat.setInt(1, 9);
			preStat.setString(2, "Test5_FFFF" );
			preStat.setString(3, "RRRR" );
			preStat.setString(4, "test005");
			preStat.setString(5, "test5");
			
			//
			boolean bResult = preStat.execute();	//
			System.out.println("sql_result:" + bResult);  // false <- workbench에서 autocommit 설정해야 보임.
			
			conn.commit();
			
			//conn.setAutoCommit(true);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(preStat!=null){preStat.close();}
				if(conn!=null){conn.setAutoCommit(true);conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	@Test
	public void updateTest(){
		//
		Connection conn = null;
		
		PreparedStatement preStat = null;
		
		String updateQuery = "UPDATE TB_MENU SET MENU_DESC = ? WHERE MENU_ID = ? ";
		
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			//
			System.out.println("conn=" + conn);
			
			conn.setAutoCommit(false);
			
			preStat = conn.prepareStatement(updateQuery);
			preStat.setString(1,  "Java_code_ADDDDDD FFFF");
			preStat.setInt(2, 2);
			
			int iResult = preStat.executeUpdate();
			System.out.println("iResult=" + iResult);	// Result{0:failed. 1:success} 
			
			conn.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			try {
				if(preStat!=null){preStat.close();}
				if(conn!=null){conn.setAutoCommit(true);conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Test
	public void deleteTest(){
		Connection conn = null;
		PreparedStatement preStat = null;
		String deleteSql = "DELETE FROM TB_MENU WHERE MENU_ID = ?";
		//String deleteSql = "DELETE TB_MENU WHERE MENU_ID = ?";	// <-- You have an error in your SQL syntax
		
		try {
			conn = DriverManager.getConnection(url, user, pwd);
			
			conn.setAutoCommit(false);
			
			preStat = conn.prepareStatement(deleteSql);
			
			preStat.setInt(1, 9);
			
			//
			int result = preStat.executeUpdate();	//
			System.out.println("sql_result:" + result);  // 1: success, 0:failed 
			
			conn.commit();
			
			//conn.setAutoCommit(true);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			try {
				if(preStat!=null){preStat.close();}
				if(conn!=null){conn.setAutoCommit(true);conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}
	
	
	//Test
	@Test
	public void jdbcConnTest(){
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
			
			System.out.println("conn=" + conn);
			
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
