package com.ailpha.practice.classLibrary;

import java.math.BigDecimal;

public class BigDecimalInstance {

	public static void main(String[] args) {
		// plus
		BigDecimal max = new BigDecimal(Double.MAX_EXPONENT);
		System.out.println(max.add(max));
		
		// subtract
		BigDecimal min = new BigDecimal(Double.MIN_EXPONENT);
		System.out.println(min.subtract(max));
		
		// multiply
		System.out.println(max.multiply(min));
		
		// divide
		System.out.println(max.divide(new BigDecimal(Integer.MAX_VALUE), 3, BigDecimal.ROUND_HALF_UP));
	}

}
