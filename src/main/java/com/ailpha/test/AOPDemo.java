package com.ailpha.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AOPDemo {
	
	private Logger logger = LoggerFactory.getLogger(AOPDemo.class);
	
	public void execute(){
		logger.info("Must be a great executer");
	}
	
	public boolean execute(String str) throws Exception{
		logger.info(str);
		return true;
	}
	
	public void executeException() throws Exception{
		logger.info("Test Exception");
		throw new Exception("?????????????????????????????????");
	}
	
	public void catchException(){
		logger.info("Test Exception");
		try {
			throw new Exception("~~~~~~~~~~~~~~~~~~~~~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executeArround(String str1,String str2){
		logger.info(str1 + str2); 
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(context.containsBean("AOPDemo")){
//			context.getBean("AOPDemo",AOPDemo.class).execute();
//			context.getBean("AOPDemo",AOPDemo.class).execute("I love you!");;
//			context.getBean("AOPDemo",AOPDemo.class).executeException();
//			context.getBean("AOPDemo",AOPDemo.class).catchException();
			context.getBean("AOPDemo",AOPDemo.class).executeArround(" study ", " research ");
		}
	}

}
