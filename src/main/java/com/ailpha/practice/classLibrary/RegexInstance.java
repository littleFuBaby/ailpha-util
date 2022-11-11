package com.ailpha.practice.classLibrary;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexInstance {

	public static void main(String[] args) {
		
		// pattern
		// matcher
		Pattern pattern = Pattern.compile("\\d+");
		System.out.println(pattern.pattern());
		Matcher matcher = pattern.matcher("44");
		if(matcher.matches()){
			System.out.println("correct");
		}else {
			System.out.println("uncorrect");
		}
		
		// string
		String[] strs = "776518824@qq.com".split("\\.");
		System.out.println(Arrays.toString(strs));
		if("375983479".matches("\\d+")){
			System.out.println("match");
		}
		
		System.out.println("520fys008@163.com".replaceFirst("[a-zA-Z]{3}", "---"));
		System.out.println("520fys008@163.com".replaceAll("\\d{3}", "++"));
		
	}

}
