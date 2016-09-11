package test.com.jk.db.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.com.jk.util.DBSimpleConnector;

// spring 3.x
public class QueryManagerTest {

	private DBSimpleConnector dbConn = null;
	
	@Before
	public void setup() {
		System.out.println("============ setup =======================");
		if( dbConn == null ){
			dbConn = new DBSimpleConnector();
			
		}
	}

	
	@After
	public void end(){
		System.out.println("===========================================");
	}
	
	@Test
	public void getEmpty100(){
		SqlSession sqlSession = null;
		try {
			sqlSession = dbConn.getSession();
			int result = sqlSession.selectOne("selectEmpty100");
			//
			System.out.println("result:" + result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
	
	}

	//
	
	
}
