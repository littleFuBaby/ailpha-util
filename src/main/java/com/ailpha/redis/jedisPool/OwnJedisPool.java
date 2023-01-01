package com.ailpha.redis.jedisPool;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class OwnJedisPool {
	
	private static OwnJedisPool ownJedisPool;
	
	private static final String REDIS_HOST = "192.168.6.128";
	private static final int REDIS_PORT = 6379;
	private static final int REDIS_TIMEOUT = 5000;
	private static final String REDIS_AUTH = "fuys0822";
	private static final int MAX_TOTAL = 1000;
	private static final int MAX_IDLE = 200;
	private static final int MAX_TIMEOUT = 10000;
	private static final boolean TEST_ON_BORROW = true;
	
	private JedisPool jedisPool;
	
	private OwnJedisPool(){
		checkJedisPool();
	}
	
	public static OwnJedisPool getInstance(){
		if(ownJedisPool == null){
			ownJedisPool = new OwnJedisPool();
		}
		return ownJedisPool;
	}
	
	private boolean checkJedisPool(){
		if(jedisPool != null && jedisPool.isClosed() ==false){
			return true;
		}
		if(jedisPool == null || jedisPool.isClosed()){
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_TOTAL);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_TIMEOUT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, REDIS_HOST, REDIS_PORT, REDIS_TIMEOUT, REDIS_AUTH);
			return true;
		}
		return false;
		
	}
	
	public Jedis getJedis(){
		if(checkJedisPool()){
			return jedisPool.getResource();
		}
		return null;
	}
	
	public static void main(String[] args) {
		OwnJedisPool ownJedisPool = OwnJedisPool.getInstance();
		Jedis jedisA = ownJedisPool.getJedis();
		Set<String> keys = jedisA.keys("*");
		System.out.println(keys);
		Jedis jedisB = ownJedisPool.getJedis();
		jedisB.set("new-pool", "hello pool");
		System.out.println(jedisB.get("new-pool"));
	}

}
