package com.ailpha.practice.thread;

class A {
	public synchronized void say(B b){
		System.out.println("A:���ȸ��ң��Ҳ��ܸ���");
		b.get();
	}
	public synchronized void get(){
		System.out.println("A:�Ҹ����㣬�������ң�ʲôҲ������");
	}
}

class B {
	public synchronized void say(A a){
		System.out.println("B:���ȸ��ң��Ҳ��ܸ���");
		a.get();
	}
	public synchronized void get(){
		System.out.println("B:�Ҹ����㣬�������ң�ʲôҲ������");
	}
}

class DeadLock implements Runnable {

	private static A a = new A();
	private static B b = new B();
	public DeadLock(){
		new Thread(this).start();
		b.say(a);
	}
	
	@Override
	public synchronized void run() {
		a.say(b);
	}
	
}

public class DeadLockInstance {

	public static void main(String[] args) {
		new DeadLock();
	}

}
