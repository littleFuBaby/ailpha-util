package org.fuys.owndb.test;

import org.fuys.owndb.model.JDBCModel;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Testing JDBC Model class by JUnit
 * @author ys
 *
 */
public class JDBCModelTest {
	
	@Test
	public void testInsert(){
		String sql = "insert user(name,sex) values(?,?)";
		String[] parameters = {"jay","1"};
		TestCase.assertEquals(JDBCModel.insert(sql, parameters), 1);
	}
	
	@Test
	public void testUpdate(){
		String sql = "update user set sex=? where name=?";
		String[] parameters = {"2","jolin"};
		TestCase.assertTrue(JDBCModel.update(sql, parameters)>0);		
	}
	
	@Test
	public void testDelete(){
		String sql = "delete from user where name=?";
		String[] parameters = {"jay"};
		TestCase.assertTrue(JDBCModel.delete(sql, parameters)>0);
	}
	
	@Test
	public void testQuery(){
		String sql = "select * from user where name<>?";
		String[] parameters = {"yunsong"};
		TestCase.assertTrue(JDBCModel.query(sql, parameters)>-1);
	}

}
