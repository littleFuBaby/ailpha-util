package com.ailpha.redis.data;

import com.ailpha.redis.util.JedisUtil;

import java.util.Set;

public class Keys {

	public static void main(String[] args) {
		Set<String> keys = JedisUtil.keys("*");
		System.out.println("keys:" + keys);
	}

}
