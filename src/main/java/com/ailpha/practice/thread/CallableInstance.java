package com.ailpha.practice.thread;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyCallable implements Callable<Date> {
	
	private String activity;
	private int count;

	public MyCallable(String activity, int count){
		this.activity = activity;
		this.count = count;
	}
	
	@Override
	public Date call() throws Exception {
		for(int x=1;x<=9999;x++){
			String threadName = Thread.currentThread().getName();
			try {
				System.out.println(threadName + " waiting Please -- " + this.activity);
				Thread.sleep(new Random().nextInt(9999));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(this.count>0){
				System.out.println(threadName + " sells '" + this.activity + "' tickets : ticket-" + this.count--);
			}else {
				System.out.println(threadName + " sells '" + this.activity + "' tickets out");
				break;
			}
		}
		return Calendar.getInstance().getTime();
	}
	
}

public class CallableInstance {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Date> ft = new FutureTask<>(new MyCallable("Jay World Concert start", 9));
		new Thread(ft).start();
		new Thread(ft).start();
		new Thread(ft).start();
		System.out.println("Stop Selling Time : " + ft.get());
	}

}
