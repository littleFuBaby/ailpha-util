package com.ailpha.practice.classLibrary;

import java.util.Arrays;

public class ArraysInstance {

	public static void main(String[] args) {
		Long[]longs = new Long[]{12l,45l,5l,234l,43l,67l};
		Long[]newLongs = new Long[]{11l,45l,5l,234l,43l,67l};
		
		System.out.println(Arrays.equals(longs, newLongs));
		
		Arrays.sort(longs);
		
		System.out.println(Arrays.toString(longs));
		
		System.out.println(Arrays.binarySearch(longs, 45l));
		
		Arrays.fill(newLongs, 23l);
		
		System.out.println(Arrays.toString(newLongs));
		
		
	}

}
