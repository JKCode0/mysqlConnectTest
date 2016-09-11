package test.com.jk.db.test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jk.xteam.entity.SchemaEntity;

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
	// show full columns from 'tb_menu' <-- 호출안됨.
	@Test
	public void getTableColumns(){
		SqlSession sqlSession = null;
		try {
			
			sqlSession = dbConn.getSession();
			Map result = sqlSession.selectMap("selectShowColumns", "TB_MENU");
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
	// columns 확인
	@Test
	public void getColumns(){
		SqlSession sqlSession = null;
		try {
			
			sqlSession = dbConn.getSession();
			
			SchemaEntity schemaEntity = new SchemaEntity();
			schemaEntity.setDatabase("DEV_DB");
			schemaEntity.setTableName("TB_MENU");
			
			List<Map> list = sqlSession.selectList("selectColumns", schemaEntity);
			//
			System.out.println("list len:" + list.size());
			
			int cnt = 0;
			for(Map m: list){
				++cnt;
				System.out.println("["+cnt+"]" + m);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
		}
		
	} 
	
	
}
