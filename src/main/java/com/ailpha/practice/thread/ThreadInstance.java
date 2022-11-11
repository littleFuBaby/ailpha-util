package com.ailpha.practice.thread;

import com.ailpha.common.util.StringUtils;

class MyThread extends Thread {
	
	private static int threadCount;
	private String threadName;
	
	public MyThread(String threadName){
		this.threadName = "Thread-";
		if(StringUtils.isEmpty(threadName)){
			this.threadName += threadCount++;
		}else {
			this.threadName += threadName;
		}
	}
	
	@Override
	public void run(){
		for(int i=0;i<=9;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+this.threadName + ":" + i);
		}
	}
	
}

public class ThreadInstance {
	public static void main(String[] args) {
		// define and start thread
		new MyThread("a").start();
		new MyThread("c").start();
		new MyThread(null).start();
		new MyThread("  ").start();
		new MyThread("").start();
		new MyThread("b").start();
		
		// name thread
		Thread thread = new MyThread(null);
		thread.setName("name thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
		System.out.println("=============="+thread.getName());
		Thread thr = new Thread("name thread second way");
		thr.start();
		System.out.println("++++++++++++++"+thr.getName());
	}
}
