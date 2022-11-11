package com.ailpha.practice.inheritance;

import java.util.Date;

final class Eunuch {
	
	private String name;
	
	public Eunuch(){
	}
	public Eunuch(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name --> " + this.name;
	}
	
}

class Emperor {
	
	public final Date birthday = new Date();
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Emperor() {
	}
	public Emperor(String name) {
		super();
		this.name = name;
	}

	public final void experience(){
		System.out.println(this.name + " Emperor Experience ");
	}
	@Override
	public String toString() {
		return "Name --> " + this.name;
	}
	public void print(){
		System.out.println(this.toString());
	}
	
}

class Princess extends Emperor {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Princess(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name ++ " + this.name;
	}
	
	
}

public class FinalInstance {

	public static void main(String[] args) {
		
		Eunuch eunuch = new Eunuch("Gao Zhao");
		System.out.println(eunuch.toString());

		Princess princess = new Princess("Wencheng");
		System.out.println(princess.birthday);
		princess.experience();
		System.out.println(princess.toString());
		princess.print();
		System.out.println(princess.getName());
		
		Emperor emperor = new Emperor("Yuanzhang Zhu");
		System.out.println(emperor.birthday);
		emperor.experience();
		System.out.println(emperor.toString());
		emperor.print();
	}

}
