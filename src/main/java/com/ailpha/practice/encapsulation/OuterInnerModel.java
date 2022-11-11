package com.ailpha.practice.encapsulation;

/**
 * Instance of Inner class of outer class 
 * @author ys
 *
 */
class Outer {
	// static code block
	static{
		outerStaticField = "Hello World!!!";
	}
	// private field
	private String outerField;
	// static private field
	private static String outerStaticField;
	
	// constructor method
	public Outer(String outerField){
		this.outerField = outerField;
	}
	
	// normal inner class
	class Inner1{
		public void getOuterField(){
			// access outer class field
			System.out.println(Outer.this.outerField);
		}
	}
	// private inner class
	private class Inner2{
		private String innerField;
		public Inner2(){
		}
		public Inner2(String innerField){
			this();
			this.innerField = innerField;
		}
		public void getOuterField(){
			System.out.println(Outer.this.outerField);
		}
	}
	// static inner class
	static class Inner3{
		public void getOuterField(){
			System.out.println(Outer.outerStaticField);
		}
	}
	
	public void getOuterField(){
		new Inner2().getOuterField();
	}
	
	public static void defineMethodInnerClass(String outerField){
		class Inner{
			public void getOuterField(){
				System.out.println(outerField);
			}
		}
		new Inner().getOuterField();
	}
	
	public void printInner2Field(){
		System.out.println(new Inner2("Inner2 field").innerField);
	}
}

public class OuterInnerModel{
	public static void main(String[] args) {
		new Outer("Inner1").new Inner1().getOuterField();
		new Outer("Inner2").getOuterField();
		new Outer("Inner2Field").printInner2Field();
		new Outer.Inner3().getOuterField();
		Outer.defineMethodInnerClass("MethodInnerClass");
	}
}
