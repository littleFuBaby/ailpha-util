package com.ailpha.redis.data;

import org.fuys.ownredis.util.JedisUtil;

public class HashType {

	public static void main(String[] args) {
		// set hash data
		System.out.println(JedisUtil.hset("org-own-hash", "name", "hash"));
		// get hash value
		System.out.println(JedisUtil.hget("org-own-hash", "name"));
	}

}
