package com.ailpha.practice.composite;

import java.util.Date;

class Generics <T> {
	
	private T t ;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
	public Generics(T t){
		this.t = t;
	}
	
	@Override
	public String toString(){
		return this.t.getClass().getName() + "@" + 
				Integer.toHexString(this.t.hashCode());
	}
	
	public boolean equals(Generics<? super T> gen){
		if(gen == null){
			return false;
		}
		if(gen == this){
			return true;
		}
		if(gen.equals(this)){
			return true;
		}
		return false;
	}
	
}

public class GenericsInstance {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Generics<String> g = new Generics("++");
		System.out.println(g);
		System.out.println(g.equals(new Generics<Date>(new Date())));
	}
}
