package test.com.jk.connect;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MySQLConnectTest {

	private String res_path = "com/jk/xteam/config";
	private String configFile = "/testDB_config.xml";
	
	@Before
	public void setUp(){
		System.out.println("==================== setUp ========================");
		
	}
	
	@After
	public void endSetUp(){
		System.out.println("==================== end ===========================");
	}
	
	
	@Test
	public void connectMyBatisConfig() {
		System.out.println("+++++++++++++++++++++ ");
		//
		
		
	}

}
