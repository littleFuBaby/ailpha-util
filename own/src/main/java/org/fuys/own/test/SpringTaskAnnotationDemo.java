package org.fuys.own.test;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SpringTaskAnnotationDemo {
	
	private Logger logger = LoggerFactory.getLogger(SpringTaskAnnotationDemo.class);
	// 定时调度
	@Scheduled(cron="0/6 * * * * ?")
	public void executeSpringTask(){
		logger.info("$$$ " + new Date().toString() + " $$$");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	// 间隔调度
	@Scheduled(fixedRate=4000)
	public void executeTaskAnnotation(){
		logger.info(">>> " + new Date().toString() + " <<<");
	}

}
