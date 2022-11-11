package com.ailpha.practice.jvm;

public class GarbageFirstInstance {

	public static void main(String[] args) {
		String str = "GarbageFirst";
		while(true){
			str += str + str;
		}
	}
}
