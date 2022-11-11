package com.ailpha.practice.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class SMSCodeInstance {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = false;
		while(flag==false){
			System.out.println("Please enter SMS code:");
			String str = reader.readLine();
			if(Pattern.matches("\\d{6}", str)){
				System.out.println("SMS code is correct");
				flag = true;
			}else {
				System.err.println("SMS code is uncorrect");
			}
		}
		reader.close();
	}

}
