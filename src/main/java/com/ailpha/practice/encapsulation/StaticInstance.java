package com.ailpha.practice.encapsulation;

class StaticClass{
	
	public static String INFO = "static";
	
	public static String getInfo(){
		return INFO;
	}
	
	static class StaticInnerClass{
		
		public int aMethod(){
			// illegal
			// static int i = 0;
			int i = 0;
			i++;
			return i;
		}
		
	}
	
}

public class StaticInstance {

}
