package com.ailpha.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorInstance {

	public static ThreadPoolExecutor pool = null;

	public static int POOLSIZE = 5;

	public static int CAPACITY = 2;

	static {
		pool = new ThreadPoolExecutor(POOLSIZE, POOLSIZE, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(CAPACITY));
		pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
	}

	public static void main(String[] args) {

		int i = 0;
		while (i++ < 100) {
			pool.execute(() -> {
				System.out.println(Thread.currentThread().getName());
			});
		}

	}

}
