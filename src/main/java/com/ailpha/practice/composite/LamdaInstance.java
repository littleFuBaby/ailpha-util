package com.ailpha.practice.composite;

interface Lamp {
	void turnOn(String str);
	default void eat(String str){
		System.out.println("eat " + str);
	}
}

class SmallLamp implements Lamp {

	@Override
	public void turnOn(String str) {
		System.out.println(" --> " + str);
	}
	public void eat(String str){
		System.out.println("Small Lamp eat " + str);
	}
	
}

interface Sheep extends Lamp {
	void turnOff();
}

public class LamdaInstance {

	public static void main(String[] args) {
		
		new SmallLamp().eat("grass");
		
		// original method
		lightOn(new Sheep() {
			@Override
			public void turnOn(String str) {
				System.out.println("The sheep light on " + str);
			}
			@Override
			public void turnOff() {
				System.out.println("The sheep light off");
			}
		},"Hello World");
		// lamda method
		lightOn((s) -> System.out.println(s),"light on");
		// new interface and lamda
		eat((str) -> {},"nihao");
	}
	public static void lightOn(Lamp lamp, String str){
		lamp.turnOn(str);
	}
	public static void eat(Lamp lamp, String str){
		lamp.eat(str);
	}

}
