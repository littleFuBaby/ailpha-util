package org.fuys.owndb.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.fuys.owndb.vo.User;
import org.junit.Test;

import junit.framework.TestCase;

public class UserVoTest {
	
	@Test
	public void testInsert() throws Exception{
		
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sqlFactory.openSession();
		
		User user = new User();
		user.setName("james");
		
		int len = session.insert("org.fuys.owndb.vo.mapping.User.insert",user);
		TestCase.assertEquals(len, 1);
		session.commit();
		session.close();
		is.close();
	}

}
