package com.ailpha.practice.classLibrary;

import java.io.IOException;

public class RuntimeInstance {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		// singleton
		Runtime runtime = Runtime.getRuntime();
		
		// available processors
		int availableProcessorsCount = runtime.availableProcessors();
		System.out.println(availableProcessorsCount);
		
		// the total amount of memory currently available
		System.out.println(runtime.totalMemory());
		
		// the maximum amount of memory that the virtual machine
		System.out.println(runtime.maxMemory());
		
		// an approximation to the total amount of memory currently available
		System.out.println(runtime.freeMemory());
		
		// gc
		runtime.gc();
		
		// halt thread
		runtime.halt(0);
		
		try {
			runtime.exec("D:\\java\\jdk-9.0.4\\bin\\jconsole.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
