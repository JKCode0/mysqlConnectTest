package test.com.jk.db.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jk.xteam.conn.SingleMyBatisSessionFactory;
import com.jk.xteam.domain.TbCategory;

public class CategoryMapperTest {

	
	@Before
	public void setup(){
		System.out.println("--------------------------------- setup --------------------------");
	}
	
	@After
	public void end(){
		System.out.println("--------------------------------- end --------------------------");
	}
	
	//-----------------------------------
	// spring
	// Mapper
	@Test
	public void addCategory(){
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		
		TbCategory category = new TbCategory();
		category.setName("의류");
		category.setParentSeq(0);
		
		int result = session.insert("insertCategory", category);
		
		session.commit();
		session.close();
		
		System.out.println(" result:" + result + " seq:" + category.getCaSeq());
	}
	
	//
	@Test
	public void updateCategory(){
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		
		TbCategory category = new TbCategory();
		category.setCaSeq(2);
		category.setName("Update 분류표");
		
		int result = session.update("updateCategory", category);
		
		session.commit();
		session.close();
		
		System.out.println(" result:" + result + " seq:" + category.getCaSeq());
	}
	
	//
	@Test
	public void deleteCategory(){
		SqlSession session = SingleMyBatisSessionFactory.getIns().getSession();
		TbCategory category = new TbCategory();
		category.setCaSeq(2);
		
		int result = session.delete("deleteCategory", category);
		
		session.commit();
		session.close();
		
		System.out.println(" result:" + result + " seq:" + category.getCaSeq());
	}
	
}
