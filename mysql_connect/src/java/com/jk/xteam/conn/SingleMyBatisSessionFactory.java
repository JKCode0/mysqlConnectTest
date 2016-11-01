package com.jk.xteam.conn;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SingleMyBatisSessionFactory {
	
	private final String CONFIG_PATH = "com/jk/xteam/config/testDB_config.xml";
	
	private static SingleMyBatisSessionFactory factory = null;
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	private SingleMyBatisSessionFactory(){
		
		
	}
	
	public static SingleMyBatisSessionFactory getIns(){
		if(factory==null){
			factory = new SingleMyBatisSessionFactory();
			
		}
		return factory;
	}

	
	public SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream input = null;
			try {
				input = Resources.getResourceAsStream(CONFIG_PATH);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
			} catch (IOException e) {
				throw new RuntimeException(e.getCause());
			}finally{
				if(input!=null){
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		return sqlSessionFactory;
	}
	
	//
	public SqlSession getSession(){
		return sqlSessionFactory.openSession();
	}
}
