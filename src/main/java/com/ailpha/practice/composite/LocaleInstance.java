package com.ailpha.practice.composite;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleInstance {
	
	public static void main(String[] args) {
		print();
		print(Locale.US);
	}
	
	public static void print(){
		print(null);
	}
	
	public static void print(Locale locale){
		if(locale==null){
			locale = Locale.getDefault();
		}
		ResourceBundle rb = ResourceBundle.getBundle("Message");
		if(!Locale.getDefault().getCountry().equals(locale.getCountry())){
			rb = ResourceBundle.getBundle("Message" ,locale);
		}
		String value = rb.getString("Own.Country");
		System.out.println(value);
		value = rb.getString("Own.Welcome");
		String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date());
		System.out.println("format before--"+value);
		value = MessageFormat.format(value, currentTime , 
				Locale.getDefault().getCountry().equals(locale.getCountry())?"����":"andy");
		System.out.println("format after---"+value);
	}

}
