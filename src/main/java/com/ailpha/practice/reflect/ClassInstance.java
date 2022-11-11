package com.ailpha.practice.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

class CreditCard {
	public String bank;
	protected double money;
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public CreditCard() {
		super();
	}

	public CreditCard(String bank) {
		this();
		this.bank = bank;
	}

	public CreditCard(String bank, String user) {
		this(bank);
		this.user = user;
	}

}

public class ClassInstance {

	public static void main(String[] args) {
		Class<Object> cls = Object.class;
		System.out.println(cls.getName());
		try {
			Object obj = cls.newInstance();
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constructor<?>[] con = cls.getConstructors();
		try {
			Object obj = con[0].newInstance();
			System.out.println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// methods
		try {
			Method method = cls.getMethod("toString");
			System.out.println(method.invoke(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// all fields
		try {
			Date date = new Date();
			Class<?> clss = date.getClass();
			Field[] fields = clss.getDeclaredFields();
			for(int x=0;x<fields.length;x++){
				if("fastTime".equals(fields[x].getName())){
					// just set different object access
					fields[x].setAccessible(true);
					System.out.println(fields[x].get(date));
					fields[x].set(date, 1122832952843l);
					System.out.println(fields[x].get(date));
				}
			}
			date = new Date();
			clss = date.getClass();
			fields = clss.getDeclaredFields();
			for(int x=0;x<fields.length;x++){
				if("fastTime".equals(fields[x].getName())){
					System.out.println(fields[x].get(date));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// public fields
		Class<?> clsss;
		try {
			clsss = Class.forName("com.ailpha.practice.reflect.CreditCard");
			Field[] fds = clsss.getFields();
			System.out.println(Arrays.toString(fds));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
