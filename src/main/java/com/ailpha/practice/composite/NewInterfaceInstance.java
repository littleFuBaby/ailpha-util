package com.ailpha.practice.composite;

interface Thing {
	public void perform();
	default void print(){
		System.out.println("JDK1.8 New Character By using dafault");
	}
	static void println(){
		System.out.println("JDK1.8 New Character By using static");
	}
}

class PapeCup implements Thing {
	
	public static void drink(){
		System.out.println("drink water");
	}
	
	@Override
	public void perform() {
		System.out.println("Interface Define");
	}
}

public class NewInterfaceInstance {
	
	public static void main(String[] args) {
		Thing thing = new PapeCup();
		thing.perform();
		thing.print();
		Thing.println();
		PapeCup papeCup = (PapeCup)thing;
		papeCup.perform();
		PapeCup.drink();
		new Thing() {
			
			@Override
			public void perform() {
			}
		}.print();
	}

}
