package com.ailpha.redis.data;

import com.ailpha.redis.util.JedisUtil;

import java.util.List;

public class ListType {

	public static void main(String[] args) {
		
		if(JedisUtil.exists("org-list")){
			
			JedisUtil.del("org-list");
			
			long res = JedisUtil.lpush("org-list", "0","1","2","3");
			List<String> list = JedisUtil.lrange("org-list", 0, res);
			
			System.out.println("first lpush length:" + res);
			System.out.println("first list:" + list);
			System.out.println("first lpop:" + JedisUtil.lpop("org-list"));
			
			res = JedisUtil.rpush("org-list", "9","8","7");
			list = JedisUtil.lrange("org-list", 0, res);
					
			System.out.println("second rpush length:" + res);
			System.out.println("second list:" + list);
			System.out.println("second lpop:" + JedisUtil.lpop("org-list"));
			
			System.out.println("third rpop" + JedisUtil.rpop("org-list"));
			
		}
	}

}
