package com.ailpha.practice.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

class ResourcePool {

	private int max_num;
	private Semaphore sema;
	private List<String> list = new ArrayList<>();

	public ResourcePool() {
		this.max_num = 10;
		this.sema = new Semaphore(this.max_num);
	}

	public ResourcePool(int max_num) {
		this.max_num = max_num;
		this.sema = new Semaphore(max_num);
	}

	public void set(String str, Thread thread) {
		try {
			this.sema.acquire(2);
			System.out.println(Thread.currentThread().getName() + "--" + str);
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
			this.list.add(str);
			this.sema.release(2);
			if (!this.sema.hasQueuedThreads()) {
				LockSupport.unpark(thread);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<String> get() {
		return list;
	}

}

public class SemaphoreInstance {

	public static void main(String[] args) {

		ResourcePool pool = new ResourcePool(5);
		Thread mainThread = Thread.currentThread();

		for (int x = 0; x < 30; x++) {
			new Thread(() -> {
				pool.set(Thread.currentThread().getName() + "==", mainThread);
			}, "Thread-" + x).start();
		}
		LockSupport.park(mainThread);
		System.out.println(pool.get());

	}

}

