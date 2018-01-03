package org.fuys.own.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * define public abstract class for controller 
 * to get public method
 * @author ys
 *
 */
public abstract class AbstractController {
	
	@Resource
	private MessageSource messageSource;

	/*public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}*/
	
	public String getValue(String key,Object ...args){
		return this.messageSource.getMessage(key, args, Locale.getDefault());
	}

	/**
	 * format date parameter
	 * @param data
	 */
	@InitBinder
	public void initBinder(WebDataBinder data) {
		data.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

}
