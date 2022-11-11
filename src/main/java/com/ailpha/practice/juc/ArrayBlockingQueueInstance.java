package com.ailpha.practice.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueInstance {

	private static BlockingQueue<Runnable> bq = new ArrayBlockingQueue<>(100, false);

	private static CyclicBarrier cb = new CyclicBarrier(5, () -> {
		System.out.println("main-"+ Thread.currentThread().getName());
		for (int x=0;x<5;x++) {
			if (bq.size() > 0) {
				Thread thread = (Thread)bq.poll();
				System.out.println(thread.getName());
				//thread.start();
			}
		}
	});

	public static void main(String[] args) {

		for (int x = 1; x <= 20; x++) {
			new Thread(() -> {
				try {
					TimeUnit.SECONDS.sleep(3);
					bq.put(Thread.currentThread());
					cb.await();
				} catch (Exception e) {
					e.printStackTrace();
				}
			},"t-"+x).start();
		}

	}

}
