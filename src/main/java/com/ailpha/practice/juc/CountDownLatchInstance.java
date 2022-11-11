package com.ailpha.practice.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchInstance {

	public static void main(String[] args) throws InterruptedException {

		CountDownLatch sdl = new CountDownLatch(5);

		for (int x = 0; x < 10; x++) {
			new Thread(() -> {
				sdl.countDown();
				System.out.println(Thread.currentThread().getName());
			}).start();
		}

		sdl.await();
		System.out.println("end");

	}

}