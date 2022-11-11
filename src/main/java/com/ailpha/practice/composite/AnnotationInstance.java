package com.ailpha.practice.composite;

interface Cup {
	
	void drink();
	
	boolean isEmpty();
	
	@Deprecated
	void finalized();
	
}

class WhiteCup implements Cup {
	
	private long content;
	
	public void addWater(long content){
		if(content > 0 ){
			this.content += content;
			System.out.println("water content = " + this.content);
		}
	}

	@Override
	public void drink() {
		this.content = 0;
		System.out.println("drink water");
	}

	@Override
	public boolean isEmpty() {
		if(this.content == 0){
			return false;
		}
		return false;
	}

	@Override
	public void finalized() {
		this.content = 0;
		System.out.println("wash cup");
	}
	
}


public class AnnotationInstance {

	public static void main(String[] args) {
		
		Cup cup = new WhiteCup();
		WhiteCup whitecup = (WhiteCup) cup;
		whitecup.addWater(1000);
		whitecup.drink();
		whitecup.finalized();

	}

}
