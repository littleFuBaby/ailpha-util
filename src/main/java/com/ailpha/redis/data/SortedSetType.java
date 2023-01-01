package com.ailpha.redis.data;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.fuys.ownredis.util.JedisUtil;

import redis.clients.jedis.Tuple;

public class SortedSetType {

	public static void main(String[] args) {
		
		JedisUtil.del("org-sortedset");
		
		Map<String, Double> map = new Hashtable<String, Double>();
		map.put("fu", 99.0);
		map.put("yun", 82.0);
		map.put("song", 79.3);
		map.put("ying", 93.2);
		map.put("ran", 78.4);
		map.put("feng", 78.3);
		long res = JedisUtil.zadd("org-sortedset", map);
		System.out.println("sortedset number;" + res);
		
		Set<String> set = JedisUtil.zrangeByScore("org-sortedset", 80.0, 99.9);
		System.out.println("sortedset:" + set);
		
		Set<Tuple> newSet = JedisUtil.zrangeByScoreWithScores("org-sortedset", 80.0, 99.9);
		System.out.println("new sortedset:" + newSet);
		Iterator<Tuple> iter = newSet.iterator();
		System.out.println("iterator new sortedset");
		while(iter.hasNext()){
			Tuple tuple = iter.next();
			System.out.println(tuple.getElement() + ":" + tuple.getScore());
		}
	}

}
