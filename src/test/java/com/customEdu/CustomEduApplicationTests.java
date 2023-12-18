package com.customEdu;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CustomEduApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Test
	void contextLoads() {
	}
	@Test
	public void testBySqlSessionFactory(){
		try {
			System.out.println("============================");
			System.out.println(sqlSessionFactory.toString());
			System.out.println("============================");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
