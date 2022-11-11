package com.ailpha.practice.juc;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsInstance {

	static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "  " + this.name);
			System.out.println(poolInfo());
		}
	}

	public static String poolInfo() {
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) pool;
		return "corepoolsize=" + tpe.getCorePoolSize() + ",MaximumPoolSize=" + tpe.getMaximumPoolSize()
				+ ",CompletedTaskCount=" + tpe.getCompletedTaskCount() + ",TaskCount=" + tpe.getTaskCount()
				+ ",isShutdown=" + tpe.isShutdown() + ",isTerminated=" + tpe.isTerminated() + ",isTerminating"
				+ tpe.isTerminating();
	}

	public static ExecutorService pool = null;

	static {
		pool = Executors.newFixedThreadPool(5);
		ThreadPoolExecutor tpe = (ThreadPoolExecutor) pool;
		tpe.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
	}

	public static void main(String[] args) {

		int i = 0;
		while (i++ < 1000) {
			pool.execute(new Task("t-" + i));
		}
	}

}
