package com.ailpha.practice.composite;

import java.util.Calendar;

public class ForeachInstance {

	public static void main(String[] args) {
		
		Object[] objects = new Object[]{0,0l,0.0f,0.0d,'\u0000',
				false,null,"Hello World", Calendar.getInstance().getTime()};
		for (Object object : objects) {
			System.out.println(object);
		}
		
	}

}
