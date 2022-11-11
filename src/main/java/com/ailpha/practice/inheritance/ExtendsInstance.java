package com.ailpha.practice.inheritance;

import java.util.Date;

/**
 * Notice difference between extending class relationship 
 * and simple java class implementing relationship different tables
 * @author ys
 */
class SuperClass{
	
	static{
		honor = "NORMAL";
		FAMILYCREATETIME = new Date();
	}
	
	public final static Date FAMILYCREATETIME;
	
	private String name;
	private static String honor;
	
	public SuperClass(){
	}
	public SuperClass(String name){
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getHonor() {
		return honor;
	}
	public static void setHonor(String honor) {
		SuperClass.honor = honor;
	}
	
	public String getInformation(){
		return "Honor --> " + honor + " | Name --> " + this.name + " | Super";
	}
	void print(){
		System.out.println(this.getInformation());
	}
}

class SubClass extends SuperClass {
	public SubClass(){
	}
	public SubClass(String name){
		// illegal syntax --> super *****************************
		super();
		this.setName(name);
	}
	public String getInformation(){
		return "Honor --> " + getHonor() + " | Name --> " + this.getName() + " | Sub";
	}
	protected void print(){
		// System.out.println(this.getInformation());
		super.print();
	}
}

class SubSubClass extends SubClass {
	
	public SubSubClass(String name){
		this.setName(name);
	}
	public String getInformation(){
		return "Honor --> " + getHonor() + " | Name --> " + this.getName() + " | Subsub";
	}
	/*
	 * Incompatible print comparing with same method from superClass.
	 * Because of return value type.
	public boolean print(){
		System.out.println(this.getInformation());
		return true;
	}
	 */
}

public class ExtendsInstance {
	
	public static void main(String[] args) {
		SubSubClass subSub = new SubSubClass("jane");
		subSub.print();
		
		SubClass sub = new SubClass("andy");
		SubClass.setHonor("UP");
		sub.print();
		
		SuperClass sup = new SuperClass("huangdi");
		sup.print();
		
		System.out.println(SubSubClass.FAMILYCREATETIME);
		System.out.println(SubClass.FAMILYCREATETIME);
		System.out.println(SuperClass.FAMILYCREATETIME);
		
	}

}
