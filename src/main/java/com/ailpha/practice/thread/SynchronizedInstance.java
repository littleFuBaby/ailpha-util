package com.ailpha.practice.thread;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Tickets implements Callable<String> {
	
	private static int count = 10;
	
	@Override
	public String call() throws Exception {
		Thread current = Thread.currentThread();
		for(int x=0;x<9999;x++){
			synchronized (this){
				if(count>0){
					System.out.println(current.getName() + ": sell tickets: ticket-" + count--);
				}else {
					System.out.println(current.getName() + ": sell tickets out");
					break;
				}
			}
		}
		return current.getName() + " stop selling time : " + Calendar.getInstance().getTime();
	}
}

public class SynchronizedInstance {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String> task1 = new FutureTask<>(new Tickets());
		FutureTask<String> task2 = new FutureTask<>(new Tickets());
		FutureTask<String> task3 = new FutureTask<>(new Tickets());
		new Thread(task1).start();
		new Thread(task2).start();
		new Thread(task3).start();
		System.out.println(task1.get());
		System.out.println(task2.get());
		System.out.println(task3.get());
	}

}
