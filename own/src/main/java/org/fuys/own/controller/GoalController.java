package org.fuys.own.controller;

import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.servlet.http.HttpServletRequest;

import org.fuys.own.util.FilesUtil;
import org.fuys.own.vo.Goal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/goal/*")
public class GoalController extends AbstractController{
	
	private Logger logger = LoggerFactory.getLogger(GoalController.class);
	
	@RequestMapping("addGoalAndFile")
	public ModelAndView addGoalAndFile(Goal goal,MultipartFile file,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("addGoalAndFile");
		logger.info("Goal is " + goal);
		if(file!=null){
			logger.info("原文件名稱 :" + file.getOriginalFilename());
			logger.info("文件名稱 :" + file.getName());
			logger.info("文件大小 :" + file.getSize());
			logger.info("文件類型 :" + file.getContentType());
			// save file
			String newFileName = null;
			String newFilePath = null;
			boolean savingResult = false;
			try {
				newFileName = FilesUtil.createFileNameToSave(file.getOriginalFilename());
				newFilePath = request.getServletContext().getRealPath(super.getValue("own.file.diretory")) 
						+ newFileName;
				savingResult = FilesUtil.saveFile(file.getInputStream(), newFilePath);
			} catch (Exception e) {
				logger.error("save file exception." + e);
			}
			logger.info("newFileName=" + newFileName );
			logger.info("newFilePath=" + newFilePath );
			logger.info("saving result is " + savingResult );
		}
		return mav;
	}

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
		Map<String, Object> map = new WeakHashMap<String, Object>();
		map.put("goalId", UUID.randomUUID());
		map.put("name", name);
		ModelAndView mav = new ModelAndView("goal");
		mav.addAllObjects(map);
		mav.addObject("goal", "okay");
		logger.info("GoalId is " + map);
		return mav;
	}
	
}
