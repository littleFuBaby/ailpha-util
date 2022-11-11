package com.ailpha.practice.encapsulation;

import java.util.Arrays;
import java.util.Random;

class Mouse{
	private String brand;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Mouse(String brand) {
		super();
		this.brand = brand;
	}
}

public class ArrayInstance {
	public static void main(String[] args) {
		// 1 dimensional array
		char []chars = new char[]{'a','n','d','y'};
		System.out.println(chars);
		System.out.println(chars.length);
		chars = new char[2];
		for(int x=0;x<chars.length;x++){
			chars[x] = String.valueOf(new Random().nextInt(9)).charAt(0);
			System.out.println((int)chars[x]);
		}
		System.out.println(chars);
		// object array
		Mouse[] mouses = new Mouse[]{new Mouse("logitech")};
		for(int x = 0;x<mouses.length;x++){
			System.out.println(mouses[x].getBrand());
		}
		// 2 dimensional array
		int[][] ints = new int[][]{{1,4},{3,2}};
		for(int x=0;x<ints.length;x++){
			for(int y=0;y<ints[x].length;y++){
				System.out.println(ints[x][y]);
			}
		}
		// array operate method
		int [][] newInts = new int[2][2];
		System.arraycopy(ints, 0, newInts, 0, 2);
		for(int x=0;x<newInts.length;x++){
			for(int y=0;y<newInts[x].length;y++){
				System.out.println(newInts[x][y]);
			}
		}
		Arrays.sort(chars);
		System.out.println(chars);
	}
}
