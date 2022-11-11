package com.ailpha.practice.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeInstance {
	
	private static BlockingQueue<Runnable> bq = new LinkedBlockingDeque<>();
	
	private static class MyThread implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
		
	}
	
	private static CountDownLatch cdl = new CountDownLatch(10);

	public static void main(String[] args) {
		for(int x=0;x<100;x++){
			new Thread(()->{
				try {
					bq.put(new MyThread());
					cdl.countDown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();;
		}
		
		
		try {
			cdl.await();
			System.out.println("+++++++++++++++++++++++++++++++++++");
				for(;;){
					if(bq.size()>0){
						new Thread(bq.poll()).start();
					}else {
						break;
					}
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
