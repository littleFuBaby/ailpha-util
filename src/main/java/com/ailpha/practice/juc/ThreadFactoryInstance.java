package com.ailpha.practice.juc;
import java.util.Random;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

class SimpleThreadFactory implements ThreadFactory {
	private static volatile int count = 0;
	public Thread newThread(Runnable r) {
		return new Thread(r, "Thread-" + count++);
	}
	public Thread newThread(Runnable r, String name){
		return new Thread(r, name + "-" + count++);
	}
}

public class ThreadFactoryInstance {
	public static void main(String[] args) {
		new SimpleThreadFactory().newThread(() -> {
			for (int x = 0; x < 10; x++) {
				try {
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ",x = " + x);
			}
		},"myThread").start();
		new SimpleThreadFactory().newThread(() -> {
			for (int x = 0; x < 10; x++) {
				try {
					TimeUnit.SECONDS.sleep(new Random().nextInt(10));
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ",x = " + x);
			}
		}).start();
	}
}
