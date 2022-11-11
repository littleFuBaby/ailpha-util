package com.ailpha.practice.juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerInstance {

	public static void main(String[] args) {
		Exchanger<String> ec = new Exchanger<>();
		for (int x = 0; x < 3; x++) {
			new Thread(() -> {
				try {
					TimeUnit.SECONDS.sleep(3);
					System.out.println("product:" + ec.exchange(Thread.currentThread().getName()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}, "p-" + x).start();
		}
		for (int y = 0; y < 3; y++) {
			new Thread(() -> {
				try {
					TimeUnit.SECONDS.sleep(2);
					System.out.println("consumer:" + ec.exchange(null));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}, "c-" + y).start();
		}
	}

}
