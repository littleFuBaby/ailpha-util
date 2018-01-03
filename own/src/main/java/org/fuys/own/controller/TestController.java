package org.fuys.own.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test/*")
public class TestController {
	
	private Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test")
	public ModelAndView test(@RequestParam(value="tid",defaultValue="10") int id){
		logger.info("test id is " + id);
		return null;
	}
	
	@RequestMapping("getTest")
	public ModelAndView getTest(@RequestParam(value="tid",defaultValue="10")int id,
			HttpServletRequest request,HttpServletResponse response){
		logger.info(" *** id ***" + id);
		logger.info(" *** sessionId ***" + request.getSession().getId());
		logger.info(" *** contextPath ***" + request.getContextPath());
		logger.info(" *** realPath ***" + request.getServletContext().getRealPath("/"));
		try {
			response.getWriter().print("request and response object");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping("querytestList")
	public ModelAndView queryTestList(
			@RequestParam(value="cp",defaultValue="1")int currentPage,
			@RequestParam(value="ls",defaultValue="10")int lineSize,
			@RequestParam(value="kw",defaultValue="test")String keyword){
		logger.info("currentPage is " + currentPage);
		logger.info("lineSize is " + lineSize);
		logger.info("keyword is " + keyword);
		return null;
	}
	
}
