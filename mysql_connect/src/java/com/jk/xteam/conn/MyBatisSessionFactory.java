package com.jk.xteam.conn;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSessionFactory {

	private static SqlSessionFactory sqlSessionFactory = null;
	//private static final Properties proPerties = new Properties();
	
	private static final String resource = "com/jk/xteam/config/testDB_config.xml";
	
	// properties Load
	/*
	static{
		try{
			//
			InputStream is = DataSourceFactory.class.getResourceAsStream("/");
			proPerties.load(is);
		}catch(IOException ie){
			ie.printStackTrace();	
		}
		
	}
	*/
	
	//
	public static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e.getCause());
				
			}finally{
				if(inputStream != null){
					//
					try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		}
		return sqlSessionFactory;
	}

	public static SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
	
	
}
