package test.com.jk.db.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jk.xteam.conn.SingleMyBatisSessionFactory;
import com.jk.xteam.domain.User;

public class MyBatisMapperTest {

	@Before
	public void setUp(){
		System.out.println("======================== setUp ============================");
	}
	
	@After
	public void end(){
		System.out.println("======================== end ============================");
	}
	
	
	@Test
	public void selectUserInfo() {
		//
		SqlSessionFactory factory = SingleMyBatisSessionFactory.getIns().getSqlSessionFactory();
		
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		
		User param = new User();
		List<User> userList =  session.selectList("selectUsers", param);
		
		if(!userList.isEmpty()){
			for(int i=0;i<userList.size();i++){
				
				System.out.println("["+i+"]" + userList.get(i).getUserNm());
			}
		}
		
		List<User> userList2 = session.selectList("selectUsers", param);
		System.out.println(">List len:" + userList2.size());
		
		
		session.close();
		
	}

}
