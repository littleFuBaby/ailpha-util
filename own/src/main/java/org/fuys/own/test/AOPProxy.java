package org.fuys.own.test;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AOPProxy {
	
	private Logger logger = LoggerFactory.getLogger(AOPProxy.class);
	
	public void sayHiBefore(){
		logger.info(" ****** before advice ****** This is complexible world. You need to pay your attention to yourself.");
	}
	
	public void sayHiBeforeWithArg(Object obj){
		logger.info(" -----> before advice with arg <----- " + obj);
	}
	
	public void sayGoodByeAfter(){
		logger.info(" ****** after advice ****** Time to say goodbye.");
	}
	
	public void sayGoodBysAfterReturning(Object obj){
		logger.info(" -----> after returning advice <----- " + obj);
	}
	
	public void sayAfterthrowing(Exception e){
		logger.error(" >>>> after throwing <<<<" + e.toString());
	}
	
	/**
	 * 环绕通知
	 * @param point 传递参数的对象
	 * @throws Throwable 
	 */
	public void arroundAdvice(ProceedingJoinPoint point) throws Throwable{
		// 通过ProceedingJoinPoint对象进行参数的传递
		logger.info("++++++++ args is " + Arrays.toString(point.getArgs()));
		Object obj = point.proceed(point.getArgs());
		logger.info("Result is " + obj);
	}

}
