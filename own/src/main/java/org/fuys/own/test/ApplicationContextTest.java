package org.fuys.own.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Test spring core container whether valid
 * @author ys
 *
 */
public class ApplicationContextTest {
	
	public static Logger logger = LoggerFactory.getLogger(ApplicationContextTest.class);
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(ac.containsBean("beanInstance")){
			logger.info("spring core container is valid");
		}
		logger.info("test context ends");
	}

}
