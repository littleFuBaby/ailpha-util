package com.ailpha.practice.stream;

import java.util.Scanner;

public class ScannerInstance {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\.");
		System.out.println("Please enter:");
		while(scanner.hasNext()){
			System.out.println(scanner.nextLine());
		}
		scanner.close();
	}

}
