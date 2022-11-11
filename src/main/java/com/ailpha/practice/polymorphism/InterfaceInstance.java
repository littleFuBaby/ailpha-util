package com.ailpha.practice.polymorphism;

interface X{
	void print();
	static class XX{
		private String name;
		public XX(){}
		public XX(String name){
			this.name = name;
		}
		@Override
		public String toString() {
			return "name --> " + this.name;
		}
	}
	class XXX{
		public XXX(){
		}
		@Override
		public String toString() {
			return super.toString();
		}
	}
}

interface Y{
	void print();
	interface YY{
		String toStr();
	}
}

class Z extends X.XX implements X, Y, Y.YY{

	@Override
	public void print() {
		System.out.println("Z");
	}

	@Override
	public String toStr() {
		return this.toString();
	}
}

abstract class XX extends Object implements X, Y {
	
}

public class InterfaceInstance {
	
	public static void main(String[] args) {
		// normal use
		X x = new Z();
		Y y = (Y)x;
		y.print();
		System.out.println(x instanceof X);
		System.out.println(x instanceof Y);
		
		// special use
		X.XX xx = new X.XX("inner class of interface");
		System.out.println(xx.toString());
		X.XXX xxx = new X.XXX();
		System.out.println(xxx.toString());
	}

}
