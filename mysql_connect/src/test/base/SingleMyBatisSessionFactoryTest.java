package base;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jk.xteam.conn.MyBatisSessionFactory;
import com.jk.xteam.conn.SingleMyBatisSessionFactory;

public class SingleMyBatisSessionFactoryTest {

	@Before
	public void setUp(){
		System.out.println("========================= setUp ========================");
	}
	
	@After
	public void endSetUp(){
		System.out.println("========================= end ========================");
	}
	
	
	// service call
	@Test
	public void serviceCallTest() {
		//fail("Not yet implemented");
		SqlSessionFactory factory = SingleMyBatisSessionFactory.getIns().getSqlSessionFactory();
		System.out.println("@ factory:" + factory);
		
		SqlSession session = MyBatisSessionFactory.getSession();
		System.out.println("@ session:" + session);
		
		
		
		
		
			
	}

}
