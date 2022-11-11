package com.ailpha.practice.thread;

import java.util.Arrays;
import java.util.Random;

class Kettle {
	
	private String action;
	private double content;
	private boolean flag;
	
	public synchronized void set(String action, double content){
		if(this.flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.action = action;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.content = content;
		this.flag=true;
		this.notifyAll();
	}
	public synchronized void get(){
		if(!this.flag){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"\t"+this.action + "\t" + this.content);
		this.flag=false;
		this.notifyAll();
	}
	@Override
	public String toString() {
		return "Action=" + this.action + ",content="+this.content;
	}
}

class Pool {
	
	private int size;
	private volatile Kettle[] kettles;
	private volatile int foot;
	public Pool(int size){
		this.size = size;
		this.kettles = new Kettle[size];
	}
	public synchronized void set(String action, double content){
		if(this.foot>= this.size){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("------------------------------------------");
			System.out.println(this.foot + "==" + Arrays.toString(kettles));
			Kettle kettle = new Kettle();
			kettle.set(action, content);
			kettles[this.foot++] = kettle;
			this.notify();
//			this.notifyAll();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			if(this.foot<0){
				this.foot++;
			}
			this.set(action, content);
		}
	}
	public synchronized void get(){
		if(this.foot<=0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("===========================================");
		System.out.println(this.foot + "==" + Arrays.toString(kettles));
		try {
			Kettle kettle = kettles[this.foot-1];
			kettles[--this.foot] = null;
			kettle.get();
			this.notify();
//			this.notifyAll();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			if(this.foot>this.size){
				this.foot--;
			}
			this.get();
		}
	}
	
}

class Producer implements Runnable {

	private Kettle kettle;
	private Pool pool;
	
	public Producer(Kettle kettle){
		this.kettle = kettle;
	}
	public Producer(Pool pool){
		this.pool = pool;
	}
	
	@Override
	public void run() {
		for(int x=0;x<99;x++){
			if(x%2==0){
				if(this.kettle!=null){
					this.kettle.set("sub -10 ml water",-10);
				}else {
					this.pool.set("sub -10 ml water",-10);
				}
			}else {
				if(this.kettle!=null){
					this.kettle.set("add 10 ml water",10);
				}else {
					this.pool.set("add 10 ml water",10);
				}
			}
		}
	}
	
}

class Consumer implements Runnable {
	
	private Kettle kettle;
	private Pool pool;
	
	public Consumer(Kettle kettle){
		this.kettle = kettle;
	}
	public Consumer(Pool pool){
		this.pool = pool;
	}
	
	@Override
	public void run() {
		for(int x=0;x<99;x++){
			if(this.kettle!=null){
				this.kettle.get();
			}else {
				this.pool.get();
			}
		}
	}
}


public class ProducerConsumerModelInstance {

	public static void main(String[] args) {
		// way 1
		// Producer consumer model
		// just one Producer and one consumer
//		Kettle kettle = new Kettle();
//		new Thread(new Producer(kettle)).start();
//		new Thread(new Consumer(kettle)).start();
		
		// way 2
		// thread pool model
		Pool pool = new Pool(100);
		new Thread(new Producer(pool)).start();
		new Thread(new Producer(pool)).start();
		new Thread(new Producer(pool)).start();
		new Thread(new Producer(pool)).start();
		new Thread(new Producer(pool)).start();
		new Thread(new Producer(pool)).start();
		new Thread(new Consumer(pool)).start();
		new Thread(new Consumer(pool)).start();
		new Thread(new Consumer(pool)).start();
		new Thread(new Consumer(pool)).start();
		new Thread(new Consumer(pool)).start();
		new Thread(new Consumer(pool)).start();
		
	}

}
