package com.ailpha.practice.reflect;

import java.util.Date;

public class ReflectInstance {
	
	public static void main(String[] args) throws Exception {
		
		// 1,
		Class<?> class1 = Date.class;
		System.out.println(class1);
		
		// 2,
		Object obj = new Object();
		Class<?> class2 = obj.getClass();
		System.out.println(class2);
		
		// 3,
		Class<?> class3 = Class.forName("java.util.regex.Pattern");
		System.out.println(class3);
		
	}

}
