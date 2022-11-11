package com.ailpha.practice.juc;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

public class CopyOnWriteArrayListInstance {
	
	private static List<String> list = new CopyOnWriteArrayList<>();
	
	private static volatile boolean flag = true;
	
	public static void main(String[] args) {
		
		Thread mainThread = Thread.currentThread();
		
		while(flag){
			new Thread(()->{
				System.out.println(list.size());
				if(list.size()>100){
					flag = false;
					LockSupport.unpark(mainThread);
				}else {
					list.add(Thread.currentThread().getName());
				}
			}).start();
		}
		
		LockSupport.park();
		System.out.println("list size :" + list.size());
		System.out.println("list content:" + list);
		
	}
}

