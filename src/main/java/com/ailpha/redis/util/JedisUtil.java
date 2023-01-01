package com.ailpha.redis.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

public class JedisUtil {

	private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

	public static final String REDIS_HOST = "192.168.6.128";
	public static final int REDIS_PORT = 6379;
	public static final int REDIS_TIMEOUT = 5000;
	public static final String REDIS_AUTH = "fuys0822";
	public static Jedis jedis;

	public static boolean isConnect() {
		boolean flag = false;
		try {
			if (jedis == null) {
				// 1,connect redis
				jedis = new Jedis(REDIS_HOST, REDIS_PORT, REDIS_TIMEOUT);
				// 2,auth redis
				// JedisException extends RuntimeException
				jedis.auth(REDIS_AUTH);
			}
			// 3,validate connection
			if ("pong".equalsIgnoreCase(jedis.ping())) {
				flag = true;
			}
		} catch (RuntimeException e) {
			jedis = null;
			logger.error("Exception:", e);
		}
		return flag;
	}

	public static void closeJedis() {
		if (jedis != null) {
			jedis.close();
		}
	}

	public static Jedis getJedis() {
		if (isConnect()) {
			return jedis;
		}
		return null;
	}

	public static boolean exists(String key) {
		boolean flag = false;
		if (isConnect()) {
			flag = jedis.exists(key);
		}
		return flag;
	}
	
	public static Set<String> keys(String pattern){
		Set<String> set = null;
		if(isConnect()){
			set = jedis.keys(pattern);
		}
		return set;
	}

	public static long del(String key) {
		long res = 0;
		if (isConnect()) {
			res = jedis.del(key);
		}
		return res;
	}

	public static String setString(String key, String value) {
		String res = null;
		if (isConnect()) {
			res = jedis.set(key, value);
			closeJedis();
		}
		return res;
	}

	public static String setexString(String key, String value, int seconds) {
		String res = null;
		if (isConnect()) {
			res = jedis.setex(key, seconds, value);
			closeJedis();
		}
		return res;
	}

	public static String getString(String key) {
		String res = null;
		if (isConnect()) {
			res = jedis.get(key);
			closeJedis();
		}
		return res;
	}

	public static long hset(String key, String field, String value) {
		long res = 0;
		if (isConnect()) {
			res = jedis.hset(key, field, value);
			closeJedis();
		}
		return res;
	}

	public static String hget(String key, String field) {
		String res = null;
		if (isConnect()) {
			res = jedis.hget(key, field);
			closeJedis();
		}
		return res;
	}

	public static long lpush(String key, String... values) {
		long res = 0;
		if (isConnect()) {
			res = jedis.lpush(key, values);
		}
		return res;
	}

	public static long rpush(String key, String... values) {
		long res = 0;
		if (isConnect()) {
			res = jedis.rpush(key, values);
		}
		return res;
	}

	public static String lpop(String key) {
		String res = null;
		if (isConnect()) {
			res = jedis.lpop(key);
		}
		return res;
	}

	public static String rpop(String key) {
		String res = null;
		if (isConnect()) {
			res = jedis.rpop(key);
		}
		return res;
	}

	public static Long llen(String key) {
		Long res = null;
		if (isConnect()) {
			res = jedis.llen(key);
		}
		return res;
	}

	public static List<String> lrange(String key, long start, long end) {
		List<String> res = null;
		if (isConnect()) {
			res = jedis.lrange(key, start, end);
		}
		return res;
	}

	public static long sadd(String key, String... values) {
		long res = 0;
		if (isConnect()) {
			res = jedis.sadd(key, values);
		}
		return res;
	}

	public static Set<String> sinter(String... keys) {
		Set<String> set = null;
		if (isConnect()) {
			set = jedis.sinter(keys);
		}
		return set;
	}

	public static Set<String> sunion(String... keys) {
		Set<String> set = null;
		if (isConnect()) {
			set = jedis.sunion(keys);
		}
		return set;
	}

	public static Set<String> sdiff(String... keys) {
		Set<String> set = null;
		if (isConnect()) {
			set = jedis.sdiff(keys);
		}
		return set;
	}

	public static Set<String> smembers(String key) {
		Set<String> set = null;
		if (isConnect()) {
			set = jedis.smembers(key);
		}
		return set;
	}

	public static long zadd(String key, Map<String, Double> scoreMembers) {
		long res = 0;
		if (isConnect()) {
			res = jedis.zadd(key, scoreMembers);
		}
		return res;
	}

	public static Set<String> zrangeByScore(String key, double min, double max) {
		Set<String> set = null;
		if (isConnect()) {
			set = jedis.zrangeByScore(key, min, max);
		}
		return set;
	}
	
	public static Set<Tuple> zrangeByScoreWithScores(String key, double min, double max){
		Set<Tuple> set = null;
		if(isConnect()){
			set = jedis.zrangeByScoreWithScores(key, min, max);
		}
		return set;
	}

	public static void main(String[] args) {
		System.out.println(JedisUtil.isConnect());
	}

}
