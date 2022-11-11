package com.ailpha.practice.juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MixedJuice {
	private String name;
	private double content;
	private double maxContent;
	private ReadWriteLock rwl = new ReentrantReadWriteLock();

	public MixedJuice(String name, double content, double maxContent) {
		this.name = name;
		if (content <= 0 || maxContent <= 0) {
			this.content = 0.0;
			this.maxContent = 100.0;
		}
		if (content > maxContent) {
			this.content = maxContent;
		} else {
			this.content = content;
		}
		this.maxContent = maxContent;
	}

	public boolean addJuice(double content) {
		this.rwl.writeLock().lock();
		boolean flag = false;
		try {
			System.out.println(Thread.currentThread().getName() + " add juice before ## " + this.name + " add content:" + content);
			if (this.content < this.maxContent) {
				if ((this.content + content) <= this.maxContent) {
					this.content += content;
					flag = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " add juice end ## " + this.name + " totalContent:" + this.content);
			this.rwl.writeLock().unlock();
		}
		return flag;
	}

	public double drinkJuice(double content) {
		this.rwl.readLock().lock();
		double dj = 0;
		try {
			System.out.println(Thread.currentThread().getName() + " drink juice before ## " + this.name + " totalcontent:+++++++" + this.content);
			if (this.content > 0) {
				if (this.content >= content) {
					dj = content;
					this.content -= content;
				} else {
					dj = this.content;
					this.content = 0;
				}
				System.out.println(Thread.currentThread().getName() + " drink juice ing ## " + this.name + " drink content:----------------------------" + dj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + " drink juice end ## " + this.name + " totalContent:=======" + this.content);
			this.rwl.readLock().unlock();
		}
		return dj;
	}
}

public class ReadWriteLockInstance {

	public static void main(String[] args) {
		MixedJuice mj = new MixedJuice("ζȫ��֭", 0, 100);
		for(int x=0;x<4;x++){
			new Thread(()->{
				mj.addJuice(new Random().nextInt(100));
			},"������-" + x).start();
		}
		
		for(int y=0;y<20;y++){
			new Thread(()->{
				mj.drinkJuice(new Random().nextInt(20));
			}, "�ͻ�-"+y).start();
		}
		
	}

}
