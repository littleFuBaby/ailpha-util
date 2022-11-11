package com.ailpha.practice.classLibrary;

public class CharSequenceInstance {
	
	public static void main(String[] args) {
		// synchronized CharSequence
		StringBuffer sbf = new StringBuffer("hello");
		System.out.println(sbf.insert(0, "--"));
		System.out.println(sbf.reverse());
		System.out.println(sbf.delete(0, 1));
		
		// asynchronous CharSequence
		StringBuilder sbu = new StringBuilder("world");
		System.out.println(sbu.insert(0, "++"));
		System.out.println(sbu.reverse());
		System.out.println(sbu.delete(0, 1));
		
		// StringBuffer append with StringBuilder
		System.out.println(sbf.reverse().append(sbu.reverse()));
		
	}

}
