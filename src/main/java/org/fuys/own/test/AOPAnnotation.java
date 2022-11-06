package org.fuys.own.test;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPAnnotation {
	
	private Logger logger = LoggerFactory.getLogger(AOPAnnotation.class);
	
	@Before(value="execution(public * org.fuys.own..*.*(..))")
	public void sayBefore(){
		logger.info(" ****** before advice ****** This is complexible world. You need to pay your attention to yourself.");
	}
	
	@Before(value="execution(public * org.fuys.own..*.*(..)) and args(id)",argNames="id")
	public void sayBeforeWithArg(Object obj){
		logger.info(" -----> before advice with arg <----- " + obj);
	}
	
//	@After(value="execution(public * org.fuys.own..*.*(..))")
//	public void sayAfter(){
//		logger.info(" ****** after advice ****** Time to say goodbye.");
//	}
	
//	@AfterReturning(value="execution(public * org.fuys.own..*.*(..))",returning="r",argNames="r")
//	public void sayAfterReturning(Object obj){
//		//logger.info(" -----> after returning advice <----- " + obj);
//	}
	
//	@AfterThrowing(value="execution(public * org.fuys.own..*.*(..))",throwing="e",argNames="e")
//	public void sayAfterthrow(Exception e){
//		//logger.error(" >>>> after throwing <<<<" + e.toString());
//	}
	
	/**
	 * 鐜粫閫氱煡
	 * @param point 浼犻�掑弬鏁扮殑瀵硅薄
	 * @throws Throwable 
	 */
//	@Around("execution(public * org.fuys.own..*.*(..))")
//	public void sayArroundAdvice(ProceedingJoinPoint point) throws Throwable{
//		// 閫氳繃ProceedingJoinPoint瀵硅薄杩涜鍙傛暟鐨勪紶閫�
//		//logger.info("++++++++ args is " + Arrays.toString(point.getArgs()));
//		//Object obj = point.proceed(point.getArgs());
//		//logger.info("Result is " + obj);
//	}

}
