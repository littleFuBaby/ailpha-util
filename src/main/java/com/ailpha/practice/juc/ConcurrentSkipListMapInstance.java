package com.ailpha.practice.juc;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.LockSupport;

public class ConcurrentSkipListMapInstance {

	public static Map<String, String> map = new ConcurrentSkipListMap<>();

	public static volatile boolean flag = true;

	public static void main(String[] args) {

		Thread mainthread = Thread.currentThread();

		while (flag) {
			new Thread(() -> {
				if (map.size() > 100) {
					LockSupport.unpark(mainthread);
					flag = false;
				} else {
					map.put(Thread.currentThread().getName(), String.valueOf(Thread.currentThread().getId()));
				}
			}).start();
		}

		LockSupport.park();

		System.out.println("size:" + map.size());
		System.out.println("map:" + map);
	}

}

