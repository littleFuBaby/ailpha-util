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
		if(ac.containsBean("user")){
			logger.info("spring core container is valid");
			logger.info(ac.getBean("user").toString());
			logger.info(ac.getBean("province")==null?"province is null":ac.getBean("province").toString());
			logger.info(ac.getBean("order")==null?"order is null":ac.getBean("order").toString());
			logger.info(ac.getBean("goods")==null?"goods is null":ac.getBean("goods").toString());
			logger.info(ac.getBean("plan")==null?"plan is null":ac.getBean("plan").toString());
		}
		logger.info("test context ends");
	}

}
