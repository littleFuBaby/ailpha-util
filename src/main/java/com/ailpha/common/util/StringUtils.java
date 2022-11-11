package com.ailpha.common.util;

/**
 * String utility
 * @author ys
 *
 */
public class StringUtils {
	
	/**
	 * if string is null or "" or "  "
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str ==null || "".equals(str.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * If string is number , return true
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		if(str==null ||str.length()==0){
			return false;
		}
		char[] numberChars = str.toCharArray();
		for(int x=0;x<numberChars.length;x++){
			if(numberChars[x]<'0' || numberChars[x]>'9'){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Judge string is number by using regex
	 * @param str
	 * @return
	 */
	public static boolean isNumberWithRegex(String str){
		if(str ==null ||str.length()==0){
			return false;
		}
		return str.matches("\\d+");
	}
	
	/**
	 * initial first character
	 * @param str
	 * @return
	 */
	public static String initcap(String str){
		if(str == null || str.length()==0){
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
