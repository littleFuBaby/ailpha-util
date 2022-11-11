package com.ailpha.practice.inheritance;

abstract class Room {
	
	public abstract void live();
	
}

interface Key {
	public void open();
	public void lock();
}

public class AnonymousInnerClassInstance {

	public static void main(String[] args) {
		Key key = new Key() {
			@Override
			public void open() {
				System.out.println("open the door");
			}

			@Override
			public void lock() {
				System.out.println("lock the door");
			}
		};
		key.open();
		new Room() {
			@Override
			public void live() {
				System.out.println("live");
			}
		}.live();
		key.lock();
	}

}
