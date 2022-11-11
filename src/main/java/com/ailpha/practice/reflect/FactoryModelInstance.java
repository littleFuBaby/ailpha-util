package com.ailpha.practice.reflect;

interface Fruit {
	void eat();
}

class Apple implements Fruit {

	@Override
	public void eat() {
		System.out.println("eat apple");
	}

}

class Orange implements Fruit {

	@Override
	public void eat() {
		System.out.println("eat orange");
	}

}

class FruitFactory {

	public static Fruit newInstance(String str) {
		Fruit fruit = null;
		switch (str) {
		case "apple":
			fruit = new Apple();
			break;
		case "orange":
			fruit = new Orange();
			break;
		default:
			break;
		}
		return fruit;
	}
	
	public static Fruit getInstance(String classpath){
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(classpath).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fruit;
	}

}

public class FactoryModelInstance {

	public static void main(String[] args) {
		// old way
		Fruit fruit = FruitFactory.newInstance("orange");
		fruit.eat();
		
		// reflected way
		fruit = FruitFactory.getInstance("Apple");
		fruit.eat();
	}

}
