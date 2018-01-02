package org.fuys.own.test;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * test QuartzJobBean class to execute time task
 * @author ys
 *
 */
public class QuartzJob extends QuartzJobBean{
	
	private Logger logger = LoggerFactory.getLogger(QuartzJob.class); 

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info(new Date().toString());
	}
	
	public static void main(String[] args) {
		// test JobDetailsBean
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
	
}