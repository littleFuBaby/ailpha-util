package com.ailpha.practice.array;

import java.io.*;
import java.util.Properties;

public class PropertiesInstance {

	public static void main(String[] args) {
		// Properties
		Properties properties = new Properties();
		// set
		properties.setProperty("fu", "0987");
		properties.setProperty("yun", "0986");
		properties.setProperty("song", "0980");
		// get
		System.out.println(properties.getProperty("yun"));
		System.out.println(properties.getProperty("yunsong", "0000"));
		// tostring
		System.out.println(properties.toString());

		File file = new File("E:\\fuys.pro");
		if (file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// store
		try {
			properties.store(new FileOutputStream(file), "copyrigth 2018");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// load
		try {
			properties.load(new FileInputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(properties.toString());
		
	}

}
