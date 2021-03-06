package test.com.jk.db.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMyBatisConfig {
	
	// 
	private String str_res = "com/jk/xteam/config/testDB_config.xml";	// 실행되어지는 bin 으로 들어 가서 확인 해볼것.
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp(){
		System.out.println("============= start ============================");
	}
	
	@After
	public void end(){
		System.out.println("================================================");
	}
	
	@Test
	public void configTest(){
		
		
		try {
			//config 파일 read
			Reader reader = Resources.getResourceAsReader(str_res);
			System.out.println(reader);
			
			//SqlSession sqlSession = MyBatisConnectionFactory.getSql
			
		}catch(FileNotFoundException fe){	
			fe.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// 
	// step_1
	@Test
	public void sessionDBTest() {
		InputStream input = null;
		try {
			//
			input = Resources.getResourceAsStream(str_res);
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//
			SqlSession session = factory.openSession();
			
			System.out.println("session=" + session);
			//
			
			session.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// select 1 from dual <-- query 
	//step_2
	@Test
	public void queryExecuteTest(){
		InputStream input = null;
		SqlSession sqlSession = null;
		try {
			//
			input = Resources.getResourceAsStream(str_res);
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			//
			sqlSession = factory.openSession();
			
			System.out.println("sqlSession=" + sqlSession);
			//
			
			int result = sqlSession.selectOne("selectEmpty");
			System.out.println("result:" + result);
		
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		
	}
	
	
	// query
	@Test
	public void getSelectCnt(){
		InputStream input = null;
		SqlSession sqlSession = null;
		
		try {
			input = Resources.getResourceAsStream(str_res);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
			System.out.println("factory:" + factory);
			
			sqlSession = factory.openSession();
			System.out.println(" sqlSession:" + sqlSession);
			
			int result = sqlSession.selectOne("selectEmpty100");
			System.out.println(" result:" + result);
			
			//
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			//
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	
	// select <-- List map
	
	
	
	// insert 
	
	// update 

}
