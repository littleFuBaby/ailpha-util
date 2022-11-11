package com.ailpha.practice.basicSyntax;

import java.util.Calendar;

public class BasicSyntaxInstance {
	
	public static void main(String[]args){
		// data type
		// part 1 
		byte b = 1;
		short s = 1;
		int i = 1;
		long l = 1l;
		float f = 1.1f;
		double d = 1.1d;
		boolean bo = false;
		char c = '\u0000';
		// part 2
		s = b;
		i = (int)l;
		f = (float)d;
		b = (byte)c;
		// part 3
		byte[] bytes = "stream".getBytes();
		i = 100;
		l = Calendar.getInstance().getTime().getTime();
		d = 19.9;
		c = '��';
		
		// operate 
		f = i * b / s;
		d = f + 11.3;
		i -= 1;
		i++;
		d--;
		++f;
		--c;
		
		if(i>0 && bo){
			System.out.println(b);
		}
		if(d>20 || c>20){
			System.out.println(c);
		}
		
		d = i << 2;
		b >>= 2;
		c ^= c;
		i = ~i;
		b = 1 & 2;
		l = 3 | 4;
		
		i = 12 % 5;
		
		/*
		 * multiple arrows statement
		 */
		for(int x = 0;x<bytes.length;x++){
			print(bytes[x]);
		}
		for(byte bt:bytes){
			print(bt);
		}
		while(i>10){
			i--;
		}
		
	}
	
	/**
	 * print data
	 * @param obj
	 */
	public static void print(Object obj){
		System.out.println(obj);
	}
	
}
