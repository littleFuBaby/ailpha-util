package com.ailpha.practice.polymorphism;

abstract class Templet{
	
	public abstract void work();
	public abstract void think();
	public abstract void supply();
}

class Human extends Templet {

	@Override
	public void work() {
		System.out.println("human work");
	}

	@Override
	public void think() {
		System.out.println("human think");
	}

	@Override
	public void supply() {
		System.out.println("human supply");
	}
	
}

class Kindle extends Templet {

	@Override
	public void work() {
		System.out.println("kindle work");
	}

	@Override
	public void think() {
	}

	@Override
	public void supply() {
		System.out.println("kindle supply");
	}
	
}

public class TempletInstance {

	public static void main(String[] args) {

	}

}
