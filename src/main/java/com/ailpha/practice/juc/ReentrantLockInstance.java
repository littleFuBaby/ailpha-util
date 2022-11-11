package com.ailpha.practice.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket {
	private int count;
	private Lock lock = new ReentrantLock();

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Ticket(int count) {
		super();
		this.count = count;
	}

	public void sale() {
		lock.lock();
		try {
			if (this.count > 0) {
				System.out.println(Thread.currentThread().getName() + " --> " + this.count--);
			}
		} finally {
			lock.unlock();
		}
	}
}

public class ReentrantLockInstance {

	public static void main(String[] args) {
		Ticket ticket = new Ticket(20);
		for(int x=0;x<5;x++){
			new Thread(()->{
				for(int y=0;y<4;y++){
					ticket.sale();
				}
			}, "Thread-" + x).start();
		}
	}

}
	