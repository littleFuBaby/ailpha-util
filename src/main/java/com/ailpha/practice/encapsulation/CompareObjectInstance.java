package com.ailpha.practice.encapsulation;

class Computer{
	
	private String name;
	private double price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Computer() {
		super();
	}
	public Computer(String name, double price) {
		this();
		this.name = name;
		this.price = price;
	}
	
	public int compareTo(Computer computer){
		// 1,null
		if(computer == null)
			return 1;
		// 2,address
		if(this == computer)
			return 0;
		// 3,fields
		if(this.price > computer.price){
			return 1;
		}else if(this.price < computer.price){
			return -1;
		}else {
			return 0;
		}
	}
	
	public int compareTo(Object obj){
		// 1,null
		if(obj == null)
			return 1;
		// 2,address
		if(this == obj)
			return 0;
		// 3,instanceof
		if((obj instanceof Computer)==false){
			return -1;
		}
		Computer computer = (Computer) obj;
		// 4,fields
		if(this.price > computer.price){
			return 1;
		}else if(this.price < computer.price){
			return -1;
		}else {
			return 0;
		}		
	}
	
}


public class CompareObjectInstance {
	public static void main(String[] args) {
		Computer computerA = new Computer("dell inpiron14", 4599.0);
		Computer computerB = new Computer("dell", 3599.0);
		System.out.println(computerA.compareTo(computerB));
		Object obj = new Computer("mac", 12300.0);
		System.out.println(computerA.compareTo(obj));
		obj = "Hello World!";
		System.out.println(computerA.compareTo(obj));
	}
}
