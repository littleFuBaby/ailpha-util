package com.ailpha.practice.juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportInstance {

	public static String msg = null;

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();

		new Thread(() -> {
			msg = "Hello world";
			LockSupport.unpark(mainThread);
		}).start();
		
		LockSupport.park(mainThread);
		System.out.println("msg:" + msg);
	}

}

