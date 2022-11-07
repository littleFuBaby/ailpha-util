package com.ailpha.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

	public static final String HOST = "192.168.199.173";

	public static final int PORT = 6379;

	public static final String PASSWORD = "fuys0822";

	public static final int TIMEOUT = 10000;
	
	public static String get(String key) {
		String value = null;
		try {
			Jedis jedis = new Jedis(HOST, PORT, TIMEOUT);
			jedis.auth(PASSWORD);
			value = jedis.get(key);
			jedis.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
