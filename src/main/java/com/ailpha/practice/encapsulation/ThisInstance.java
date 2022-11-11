package com.ailpha.practice.encapsulation;

class Keyboard{
	private String brand;

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Keyboard() {
		super();
	}

	public Keyboard(String brand) {
		this();
		this.brand = brand;
	}
	public String toString() {
		return "Brand is " + this.brand;
	}
}

public class ThisInstance {

	public static void main(String[] args) {
		Keyboard keyboard = new Keyboard("logitech");
		System.out.println(keyboard.toString());
	}

}
