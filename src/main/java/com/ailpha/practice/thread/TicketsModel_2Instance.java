package com.ailpha.practice.thread;

import java.util.Random;

class TicketsModel_2 implements Runnable {
	
	private String ticketPort;
	private static int count;
	
	public TicketsModel_2(String ticketPort){
		this.ticketPort = "port-" + ticketPort;
	}
	
	public static void setCount(int totalCount){
		count = totalCount;
	}
	
	@Override
	public void run() {
		for(int x=1;x<=9999;x++){
			try {
				System.out.println(this.ticketPort + " waiting Please ");
				Thread.sleep(new Random().nextInt(9999));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(count>0){
				System.out.println(this.ticketPort + " sells tickets : ticket-" + count--);
			}else {
				System.out.println(this.ticketPort + " sold out ");
				break;
			}
		}
	}
}

public class TicketsModel_2Instance {

	public static void main(String[] args) {
		// init count
		TicketsModel_2.setCount(9);
		// sell ticket
		new Thread(new TicketsModel_2("1")).start();
		new Thread(new TicketsModel_2("2")).start();
		new Thread(new TicketsModel_2("3")).start();
		new Thread(new TicketsModel_2("4")).start();
	}

}
