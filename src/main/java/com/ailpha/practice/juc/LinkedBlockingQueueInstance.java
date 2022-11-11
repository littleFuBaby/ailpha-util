package com.ailpha.practice.juc;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LinkedBlockingQueueInstance {
	
	public static class MyThread implements Runnable {
		
		public MyThread(String name){
			this.name = name;
		}
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			System.out.println("exec:" + name);
			count++;
		}
		
	}

	private static BlockingQueue<Runnable> bq = new LinkedBlockingQueue<>();
	
	private static volatile int count = 0;

	private static CyclicBarrier cb = new CyclicBarrier(5, () -> {
		System.out.println("m-" + Thread.currentThread().getName());
		System.out.println("Ʊ��:" + count);
		for (int x = 0; x < 5; x++) {
			if(bq.size()>0){
				new Thread(bq.poll()).start();
			}
		}
	});
	
	private static final Random random = new Random();

	public static void main(String[] args) throws InterruptedException {

		for (;;) {
			new Thread(() -> {
				try {
					TimeUnit.SECONDS.sleep(random.nextInt(9));
					bq.put(new MyThread("p-"+ Thread.currentThread().getName()));
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}

	}

}
