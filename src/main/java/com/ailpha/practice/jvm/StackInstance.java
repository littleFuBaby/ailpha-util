package com.ailpha.practice.jvm;

// Method Area
class PapeBook{
	
	private String name ;
	private int count ;
	private double price;
	private double total;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public PapeBook() {
		super();
	}
	// stack frame 2
	public PapeBook(String name, int count, double price) {
		// stack frame 3
		super();
		// local variables
		this.name = name;
		this.count = count;
		this.price = price;
		// operand stack
		this.total = count * price;
	}
	// stack frame 4
	@Override
	public String toString() {
		// reference to runtime constant pool --> String
		// local variables --> name,count,price,total
		return "PapeBook [name=" + name + ", count=" + count + ", price=" + price + ", total=" + total + "]";
	}
}

// Method Area
public class StackInstance {
	// stack frame 1 --> main
	// local variables --> args
	public static void main(String[] args) {
		// local variables --> pageBook,1,30.0
		// reference to runtime constant pool --> THE LONG VIEW
		PapeBook papeBook = new PapeBook("THE LONG VIEW", 1, 30.0);
		// reference to runtime constant pool --> System.out
		// stack frame 4 --> toString()
		// stack frame 5 --> println()
		System.out.println(papeBook.toString());
	}
}
