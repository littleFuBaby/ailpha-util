package com.ailpha.redis.data;

import com.ailpha.redis.util.JedisUtil;

public class SetType {

	public static void main(String[] args) {
		JedisUtil.del("org-set");
		long len = JedisUtil.sadd("org-set", "a","b","o","p","q","c");
		System.out.println("first set number:" + len);
		System.out.println("first set:" + JedisUtil.smembers("org-set"));
		len = JedisUtil.sadd("org-set", "x","y");
		System.out.println("second set number:" + len);
		System.out.println("second set:" + JedisUtil.smembers("org-set"));
		
		len = JedisUtil.sadd("org-set2", "a","c","o","x");
		System.out.println("new set number:" + len);
		System.out.println("new set:" + JedisUtil.smembers("org-set2"));
		
		System.out.println("sinter:" + JedisUtil.sinter("org-set","org-set2"));
		System.out.println("sdiff:" + JedisUtil.sdiff("org-set","org-set2"));
		System.out.println("sunion:" + JedisUtil.sunion("org-set","org-set2"));
		
	}

}
