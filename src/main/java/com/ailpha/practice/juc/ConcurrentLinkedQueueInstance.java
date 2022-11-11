package com.ailpha.practice.juc;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueInstance {
	
	private static Queue<Runnable> queue = new ConcurrentLinkedQueue<>();
	
	public static void main(String[] args) {
		
		int count = 0;
		
		for(;;count++){
			queue.add(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
			if(count>1000){
				break;
			}
		}
		
		while(queue.size()>0){
			new Thread(queue.poll()).start();
		}
		
	}

}

