package com.ailpha.practice.stream;

import java.io.*;

class Man implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -732807289010011827L;
	
	private String name;
	private int sex;
	private transient int age;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	public Man(){
	}
	public Man(String name){
		this.name = name;
	}
	public Man(String name, int sex){
		this(name);
		this.sex = sex;
	}
	public Man(String name, int sex, int age){
		this(name,sex);
		this.age = age;
	} 
	
	@Override
	public String toString() {
		return "Name is " + this.name + ", sex is " + this.sex + ", age is " + this.age;
	}
	
}

public class SerializableInstance {
	
	public static void main(String[] args) throws Exception {
		// 1,serialize
		ser();
		Thread.sleep(2000);
		System.out.println(dser());
	}
	
	public static void ser() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("e:"+ File.separator+"man.ser")));
		oos.writeObject(new Man("Naomi", 1,29));
		oos.close();
	}
	
	public static String dser() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("e:"+ File.separator+"man.ser")));
		Object obj = ois.readObject();
		Man man = (Man) obj;
		ois.close();
		return man.toString();
	}
	

}



