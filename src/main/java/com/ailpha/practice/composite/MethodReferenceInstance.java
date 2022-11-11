package com.ailpha.practice.composite;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@FunctionalInterface
interface MethodReferenceModel1<P,R> {
	public R function(P p);
}

@FunctionalInterface
interface MethodReferenceModel2<R> {
	public R function();
}

@FunctionalInterface
interface MethodReferenceModel3<P,R> {
	public R function(P p1, P p2);
}

@FunctionalInterface
interface MethodReferenceModel4<P,T,R> {
	public R function(P p, T t);
}

class Phone {
	private String brand;
	private double price;
	public Phone(String brand, double price){
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return "[brand=" + this.brand + ",price="+this.price+"]";
	}
}

public class MethodReferenceInstance {
	
	public static void main(String[] args) {
		
		// 1,class :: static method
		MethodReferenceModel1<byte[], UUID> mr1 = UUID:: nameUUIDFromBytes;
		System.out.println(mr1.function("fuyunsong".getBytes()));
		
		// 2,class object :: normal method
		try {
			URI uri = new URI("www.qq.com");
			MethodReferenceModel2<Boolean> mr2 = uri :: isAbsolute;
			System.out.println(mr2.function());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		// 3,special class :: normal method
		MethodReferenceModel3<String, Integer> mr3 = String:: compareTo;
		System.out.println(mr3.function("baby", "BABY"));
		
		// 4,class :: new
		MethodReferenceModel4<String, Double, Phone> mr4 = Phone:: new;
		System.out.println(mr4.function("MEIZU", 1010.0).toString());
		System.out.println(mr4.function("XIAOMI", 3010.0).toString());
		
	}

}

