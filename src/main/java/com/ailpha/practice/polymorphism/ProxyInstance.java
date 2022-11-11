package com.ailpha.practice.polymorphism;

interface Pay {
	// 1,
	void scan();
	// 2,
	void enter();
	// 3,
	void password();
}

class User implements Pay {
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name){
		this.name = name;
	}

	@Override
	public void scan() {
		System.out.println(this.name + " -- use phone scan QR");
	}

	@Override
	public void enter() {
		System.out.println(this.name + " -- enter number");
	}

	@Override
	public void password() {
		System.out.println(this.name + " -- enter password");
	}
}

class Alipay implements Pay {
	
	public final static String APP = "alipay";
	
	private Pay pay;
	
	public Alipay(Pay pay){
		this.pay = pay;
	}
	
	public void init(){
		System.out.println(APP + " -- init app");
	}

	@Override
	public void scan() {
		this.init();
		this.pay.scan();
		this.connect();
		this.open();
	}

	public void connect() {
		System.out.println(APP + " -- connect system");
	}
	
	public void open(){
		System.out.println(APP + " -- open pay page");
	}

	@Override
	public void enter() {
		this.pay.enter();
	}

	@Override
	public void password() {
		this.pay.password();
		this.pay();
		this.feedback();
		this.end();
	}

	public void pay() {
		System.out.println(APP + " -- paying");
	}

	public void feedback() {
		System.out.println(APP + " -- pay success");
	}
	public void end(){
		System.out.println(APP + " -- end");
	}
}

public class ProxyInstance {

	public static void main(String[] args) {
		Pay pay = new Alipay(new User("andy"));
		pay.scan();
		pay.enter();
		pay.password();
	}

}
