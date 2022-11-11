package com.ailpha.practice.inheritance;

class WrapperBoolean{
	private boolean flag;
	public WrapperBoolean(boolean flag){
		this.flag = flag;
	}
	public boolean booleanValue(){
		return this.flag;
	}
}

public class WrapperTypeInstance {
	
	public static void main(String[] args) {
		// Wrapper Type Rule
		WrapperBoolean flag = new WrapperBoolean(true);
		System.out.println(flag.booleanValue());
		
		// jdk1.5 new characters
		// auto wrap and unwrap
		Integer a = 10;
		Integer b = 10;
		Integer c = new Integer(10);
		System.out.println(a==b);		// true
		System.out.println(a==c);		// false
		System.out.println(b==c);		// false
		System.out.println(b.equals(c));// true
		
		// object transfer with Number
		Object obj = 10;
		int num = (int) obj;
		System.out.println(num * 2);
		
		// number transfer to string
		System.out.println(String.valueOf(12));
	}

}
