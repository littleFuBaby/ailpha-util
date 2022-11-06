package org.fuys.own.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Timer and TimerTask class instance
 * @author ys
 *
 */
public class TimerDemo{
	
	public void executeTimer(){
		// Timer and TimerTask class instance
		new Timer().scheduleAtFixedRate(new TimerTask() {
			private Logger logger = LoggerFactory.getLogger(TimerTask.class);
			@Override
			public void run() {
				logger.info("----->"+new Date().toString());
			}
		}, new Date(), 2000);
	}
	
	public static void main(String[] args) {
		// test Timer and TimerTask class
//		new TimerDemo().executeTimer();
		
		// test JobDetailsBean
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
}
