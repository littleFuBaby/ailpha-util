package com.ailpha.redis.data;

import java.util.Set;

import org.fuys.ownredis.util.JedisUtil;

public class Keys {

	public static void main(String[] args) {
		Set<String> keys = JedisUtil.keys("*");
		System.out.println("keys:" + keys);
	}

}
