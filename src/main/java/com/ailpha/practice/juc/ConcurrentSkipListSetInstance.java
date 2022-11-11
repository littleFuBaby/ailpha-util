package com.ailpha.practice.juc;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetInstance {
	
	
	private static Set<String> set = new ConcurrentSkipListSet<>();
	private static volatile boolean flag = true;

	public static void main(String[] args) {
		
		while(flag){
			new Thread(()->{
				if(set.size()>100){
					System.out.println(set.size());
					System.out.println(set);
					System.out.println(((ConcurrentSkipListSet<String>)set).first());
					System.out.println(((ConcurrentSkipListSet<String>)set).last());
					flag = false;
				}else {
					set.add(Thread.currentThread().getName());
				}
			}).start();
		}	
	}
}
