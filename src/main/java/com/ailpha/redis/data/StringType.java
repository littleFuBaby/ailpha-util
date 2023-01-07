package com.ailpha.redis.data;

import com.ailpha.redis.util.JedisUtil;

public class StringType {
	public static void main(String[] args) {
		// 1,normal way
		String value = JedisUtil.getString("org-own-redis");
		System.out.println(value);
		if(value == null || "".equals(value.trim())){
			System.out.println(JedisUtil.setString("org-own-redis", "hello redis"));
		}
		
		// 2,use time limit
		System.out.println(JedisUtil.setexString("SMS-CODE", "387665", 10));
		try {
			Thread.sleep(5000);
			System.out.println("5 seconds:" + JedisUtil.getString("SMS-CODE"));
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("10 seconds:" + JedisUtil.getString("SMS-CODE"));
	}
}
