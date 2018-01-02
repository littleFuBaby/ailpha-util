package org.fuys.own.test;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTaskDemo {
	
	private Logger logger = LoggerFactory.getLogger(SpringTaskDemo.class);
	
	public void executeTask(){
		logger.info("===>" + new Date().toString() + "<===");
	}
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

}
