package com.ailpha.practice.classLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatInstance {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		Date date = new Date();
		System.out.println(sdf.format(date));
		System.out.println(sdf.toLocalizedPattern());
		System.out.println(sdf.getTimeZone().getDisplayName());
		System.out.println(sdf.getCalendar().getTimeInMillis());
		
	}

}
