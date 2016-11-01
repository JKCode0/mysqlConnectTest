package test.com.jk.db.test;

import java.util.List;
import java.util.Random;

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
				
				System.out.println("["+i+"]Name:" + userList.get(i).getUserNm() + " ID:" + userList.get(i).getUserId());
			}
		}
		
		List<User> userList2 = session.selectList("selectUsers", param);
		System.out.println(">List len:" + userList2.size());
		
		
		session.close();
		
	}
	
	// Insert
	@Test
	public void adduser(){
		//
		Random r = new Random();
		
		User user = new User();
		user.setUserNm("Tester1" + r.nextInt(100));
		user.setUserAddr("FFFFFF sdfljksdlkfjskldjfklsdjfsdf");
		user.setUserEmail("testtest@ggmail.com");
		user.setUserType(1);
		
		//
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		int result = session.insert("insertUser", user);
		System.out.println(">> result:" + result);
		//
		session.commit();
		
		session.close();
		
		System.out.println("@@@ UserId:" + user.getUserId());
		
	}
	
	
	// update
	@Test
	public void updateTest(){
		
		Random r = new Random();
		User user = new User();
		user.setUserId(1);
		user.setUserNm("reName_Tester" + r.nextInt(100));
		user.setUserAddr("FFFFFF sdfljksdlkfjskldjfklsdjfsdf");
		user.setUserEmail("testtest@ggmail.com");
		user.setUserType(1);
		
		//
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		
		int result = session.update("updateUser", user);
		
		session.commit();
		
		//
		System.out.println("SQL Result:" + result);
		
	}
	
	//delete
	@Test
	public void deleteUser(){
		
		User user = new User();
		user.setUserId(13);
		
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		
		int result = session.delete("deleteUser", user);
		
		session.commit();
		
		//
		System.out.println("SQL Result:" + result);
		
	}

}
