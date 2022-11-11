package com.ailpha.practice.juc;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteArraySetInstance {
	
	private static Set<String> set = new CopyOnWriteArraySet<>();
	
	private static CountDownLatch countDown = new CountDownLatch(100);

	public static void main(String[] args) {
		
		for(int x=0;x<100;x++){
			new Thread(()->{
				set.add(Thread.currentThread().getName());
				set.add(Thread.currentThread().getName());
				countDown.countDown();
			}).start();;
		}
		
		try {
			countDown.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("set size:" + set.size());
		System.out.println("set content:" + set);
		
	}

}

