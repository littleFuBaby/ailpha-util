package com.ailpha.practice.encapsulation;

/**
 * hungry singleton model
 * @author ys
 *
 */
class HungrySingleton {
	
	private final static HungrySingleton SINGLETON = new HungrySingleton();
	
	private HungrySingleton(){
	}
	
	public static HungrySingleton getInstance(){
		return SINGLETON;
	}
}

/**
 * equals public contractor method
 * @author ys
 *
 */
class LazySingleton_1 {

	private LazySingleton_1() {
	}

	public static LazySingleton_1 getInstance() {
		return new LazySingleton_1();
	}
}

class LazySingleton_2 {

	private static LazySingleton_2 singleton;

	private LazySingleton_2() {
	}

	public static LazySingleton_2 getInstance() {
		if (singleton == null) {
			singleton = new LazySingleton_2();
		}
		return singleton;
	}

}

enum Gender{
	MALE,FEMALE;
}

class Human {
	
	private String name;
	
	private static Human man;
	private static Human woman;

	private Human(String name) {
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

	public static Human getInstance(Gender gender) {
		switch (gender) {
		case MALE:
			if(man == null){
				man = new Human("man");
			}
			return man;
		case FEMALE:
			if(woman == null){
				woman = new Human("woman");
			}
			return woman;
		default:
			return null;
		}
	}
}

public class SingletonInstance {
	public static void main(String[] args) {
		// hungry singleton
		HungrySingleton hs = HungrySingleton.getInstance();
		System.out.println(hs);
		hs = HungrySingleton.getInstance();
		System.out.println(hs);
		
		System.out.println("************************");
		
		// lazy singleton
		LazySingleton_1 ls1 = LazySingleton_1.getInstance();
		System.out.println(ls1);
		ls1 = LazySingleton_1.getInstance();
		System.out.println(ls1);
		
		System.out.println("************************");
		
		LazySingleton_2 ls2 = LazySingleton_2.getInstance();
		System.out.println(ls2);
		ls2 = LazySingleton_2.getInstance();
		System.out.println(ls2);
		
		System.out.println("************************");
		
		// multi-ton
		Human human = Human.getInstance(Gender.FEMALE);
		System.out.println(human.getName());
	}
}
