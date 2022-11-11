package com.ailpha.practice.encapsulation;

public class StringInstance {
	
	public static void main(String[] args) {
		// new object
		String str = "Hello World!";
		str = new String(str);
		System.out.println(str);
		// intern()
		String a = "Hello World!!!";
		String b = a;
		String c = new String(a);
		String d = new String(a);
		d.intern();
		String e = new String(a).intern();
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a == d);
		System.out.println(a == e);
		// reference
		a = "m";
		b = "n";
		c = a + b;
		d = a + "n";
		e = "m" + b;
		String f = "mn";
		String g = "m"+"n";
		System.out.println(c==d); // false
		System.out.println(c==e); // false
		System.out.println(c==f); // false
		System.out.println(c==g); // false
		System.out.println(d==e); // false
		System.out.println(d==f); // false
		System.out.println(d==g); // false
		System.out.println(f==g); // true
		// operate method
		String[]stringArrays = "Hello World!!!!".split("");
		for(String s:stringArrays){
			System.out.println(s);
		}
		System.out.println("a".compareTo("b"));
	}

}
