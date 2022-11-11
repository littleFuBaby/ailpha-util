package com.ailpha.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * common date utility
 * @author ys
 *
 */
public class DateUtils {
	
	private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	
	/**
	 * Current time format of yyyy-MM-dd HH:mm:ss:SSS
	 * @return
	 */
	public static String getNowFormat(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").
				format(Calendar.getInstance().getTime());
	}
	
	/**
	 * Current time format which is given
	 * @param format
	 * @return
	 */
	public static String getNowFormat(String format){
		String nowFormat = null;
		try {
			nowFormat = new SimpleDateFormat(format).
					format(Calendar.getInstance().getTime());
		} catch (Exception e) {
			logger.error("Date Format Exception --> ", e);
		}
		return nowFormat;
	}
	
	/**
	 * compare with ensured hour before
	 * @param hour
	 * @return
	 */
	public static int beforeHH(int hour){
		if(hour > 23 || hour < 0 ){
			return -1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hh = Integer.parseInt(sdf.format(Calendar.getInstance().getTime()));
		if(hh < hour){
			return 1;
		}else if(hh == hour){
			return 0;
		}else {
			return -1;
		}
	}
	
	/**
	 * add days
	 * @param sourceDate
	 * @param days
	 * @return
	 */
	public static Date addTime(Date sourceDate, long num, TimeUnit sourceTimeUnit){
		if(sourceDate == null)
			return null;
		else if(sourceTimeUnit == null)
			return sourceDate;
		else {
			long time = TimeUnit.MILLISECONDS.convert(num, sourceTimeUnit);
			time += sourceDate.getTime();
			return new Date(time);
		}
	}
	
	public static void main(String[] args) {
		try {
			TimeUnit.DAYS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(addTime(new Date(),3, TimeUnit.MINUTES));
		System.out.println(DateUtils.getNowFormat());
		System.out.println(DateUtils.getNowFormat(null));
	}

}
