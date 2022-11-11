package com.ailpha.practice.classLibrary;

import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerInstance {

	public static void main(String[] args) {
		// plus
		BigInteger max = new BigInteger(String.valueOf(Integer.MAX_VALUE));
		System.out.println(max.add(max));
		
		// sub
		BigInteger min = new BigInteger(String.valueOf(Integer.MIN_VALUE));
		System.out.println(min.subtract(max));
		
		// mutilply
		System.out.println(max.multiply(min));
		
		// divide
		System.out.println(max.divide(min));
		System.out.println(Arrays.toString(max.divideAndRemainder(min)));
		
	}

}
