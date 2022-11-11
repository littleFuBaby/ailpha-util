package com.ailpha.practice.polymorphism;

import java.util.Calendar;

/**
 * static abstract inner class in abstract class
 * @author ys
 *
 */
abstract class A {
	
	static abstract class B {
		public abstract void print();
		public String toStr(){
			return this.toString();
		}
	}
}

class C extends A.B {
	@Override
	public void print() {
		System.out.println("C");
	}
	public String toStr(){
		return this.toString();
	}
}

/**
 * static method in abstract class
 * @author ys
 *
 */
abstract class D{
	public static void print(){
		System.out.println("D");
	}
}

/**
 * private static inner class in abstract class
 * @author ys
 *
 */
abstract class F{
	private static class G extends F {
		@Override
		public void print() {
			System.out.println("G");
		}
	}
	public abstract void print();
	public static F getInstance(){
		return new G();
	}
}

/**
 * abstract class contractor method
 * @author ys
 *
 */
abstract class H{
	public H(){
		this.print();
	}
	public abstract void print();
}

class I extends H {
	private String info = "HELLO";
	public I(String info){
		this.info = info;
	}
	@Override
	public void print() {
		System.out.println(this.info);
	}
}

public class AbstractClassInstance {
	public static void main(String[] args) {
		
		// static abstract inner class
		C c = new C();
		System.out.println(c.toStr());
		c.print();
		A.B ab = c;
		System.out.println(ab.toStr());
		ab.print();
		C cc = (C)ab;
		System.out.println(cc.toStr());
		cc.print();
		System.out.println("*******************************");
		
		// private static inner class
		F.getInstance().print();
		Calendar.getInstance().getTimeInMillis();
		
		// contractor method
		new I("WORLD").print();
		
	}
}
