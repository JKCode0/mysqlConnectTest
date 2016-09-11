package test.com.jk.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//
public class DBSimpleConnector {

	private String res_path = "com/jk/xteam/config"; 
	private String str_res = "/testDB_config.xml";
	
	private InputStream input = null;
	private SqlSessionFactory factory = null;
	
	
	// 
	public SqlSession getSession() throws IOException{
		
		if(factory==null){
			input = Resources.getResourceAsStream(res_path + str_res);
			factory = new SqlSessionFactoryBuilder().build(input);
		}
		
		return factory.openSession();
	}
	
	
	
}
