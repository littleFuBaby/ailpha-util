package com.ailpha.practice.thread;

import java.io.IOException;

public class VirusInstance {

	public static void main(String[] args) {
		
		try {
			//while(true){
				Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe");
			//}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
