package org.fuys.own.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * define interceptor by HandlerInterceptor of spring-web module 
 * @author ys
 *
 */
public class InterceptorSys implements HandlerInterceptor{
	
	private Logger logger = LoggerFactory.getLogger(InterceptorSys.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("<<<<<< before method of controller >>>>>>" + handler.getClass());
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("<<<<<< post method of controller >>>>>>" + handler.getClass());
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("<<<<<< after method of controller >>>>>>" + handler.getClass());
	}

}
