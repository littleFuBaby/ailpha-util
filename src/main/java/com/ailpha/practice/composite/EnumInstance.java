package com.ailpha.practice.composite;

import java.util.Arrays;

enum Life {
	Baby("baby", 1), Child("child", 2), Teenage("teenage", 3), Adult("adult", 4), Old("old", 5);

	private String name;
	private int index;

	private Life(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public int getIndex() {
		return this.index;
	}
	public String getName() {
		return this.name;
	}
}

public class EnumInstance {

	public static void main(String[] args) {
		
		System.out.println(Life.Adult.getIndex());
		System.out.println(Arrays.toString(Life.values()));
		
	}

}
