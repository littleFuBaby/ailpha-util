package com.ailpha.practice.encapsulation;

class ID {
	private String name;
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	public ID(String n){
		name = n;
	}
}

public class ClassAndObjeceInstance {

	public static void main(String[] args) {
		ID id = new ID("andy fu");
		new ID("jane yang");
		System.out.println(id.getName());
	}

}
