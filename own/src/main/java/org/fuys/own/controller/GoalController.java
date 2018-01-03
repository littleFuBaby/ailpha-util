package org.fuys.own.controller;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import org.fuys.own.vo.Goal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/goal/*")
public class GoalController extends AbstractController{
	
	private Logger logger = LoggerFactory.getLogger(GoalController.class);

	// 1、從類到方法上的整體請求路徑的簡易設置
	@RequestMapping("/goal")
	// 2、開發者自定義返回數據類型，若爲空，則頁面顯示http狀態為404
	// 3、可以直接定義傳遞參數
	public void goal(Goal goal){
		logger.info("Goal is " + goal);
		logger.info("log4j.rootLogger=" + super.getValue("log4j.rootLogger"));
	}
	
	// ModelAndView負責頁面跳轉和參數傳遞
	@RequestMapping("queryGoalList")
	public ModelAndView queryQoalList(String name){
		logger.info("Goals' name is " + name);
		return null;
	}
	
	@RequestMapping("updateGoal")
	public ModelAndView updateGoal(String goalId){
//		ModelAndView mav = new ModelAndView("/WEB-INF/pages/goal.jsp");
		ModelAndView mav = new ModelAndView("goal");
		mav.addObject("goal", goalId);
		logger.info("GoalId is " + goalId);
		return mav;
	}
	
	@RequestMapping("addGoal")
	public ModelAndView addGoal(String name){
		Map<String, Object> map = new WeakHashMap<>();
		map.put("goalId", UUID.randomUUID());
		map.put("name", name);
		ModelAndView mav = new ModelAndView("goal");
		mav.addAllObjects(map);
		mav.addObject("goal", "okay");
		logger.info("GoalId is " + map);
		return mav;
	}
	
}
