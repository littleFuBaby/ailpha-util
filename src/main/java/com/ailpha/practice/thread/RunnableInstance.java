package com.ailpha.practice.thread;

import com.ailpha.util.StringUtils;

class MyRunnable implements Runnable {
	
	private String threadName;
	private static int threadCount;
	
	public MyRunnable(String threadName){
		this.threadName = "thread-";
		if(StringUtils.isEmpty(threadName)){
			this.threadName += threadCount;
		}else {
			this.threadName += threadName;
		}
	}
	
	@Override
	public void run(){
		for(int x=0;x<=9;x++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.threadName + ":" + x);
		}
	}
	
}

public class RunnableInstance {

	public static void main(String[] args) {
		new Thread(new MyRunnable("x")).start();
		new Thread(new MyRunnable(" ")).start();
		new Thread(new MyRunnable("")).start();
		new Thread(new MyRunnable(null)).start();
		new Thread(new MyRunnable("y")).start();
		new Thread(new MyRunnable("z")).start();
	}

}
