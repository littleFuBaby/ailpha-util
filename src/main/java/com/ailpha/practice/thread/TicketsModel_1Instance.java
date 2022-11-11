package com.ailpha.practice.thread;

import java.util.Random;

class TicketsModel_1 implements Runnable {

	private int count;
	public TicketsModel_1(int count){
		this.count = count;
	}
	
	@Override
	public void run() {
		for(int x=1;x<=99999;x++){
			String CurrentThreadName = Thread.currentThread().getName();
			try {
				System.out.println(CurrentThreadName + " waiting Please ");
				Thread.sleep(new Random().nextInt(9999));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(this.count>0){
				System.out.println(CurrentThreadName + " Sells Ticket : ticket-" + this.count--);
			}else {
				System.out.println(CurrentThreadName + " Tickets sold out ");
				break;
			}
		}
	}
	
}

public class TicketsModel_1Instance {

	public static void main(String[] args) {
		TicketsModel_1 tm = new TicketsModel_1(2);
		new Thread(tm).start();
		new Thread(tm).start();
		new Thread(tm).start();
		new Thread(tm).start();
	}

}
