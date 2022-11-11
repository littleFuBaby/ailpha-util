package com.ailpha.practice.classLibrary;

import java.util.Arrays;
import java.util.Comparator;

class EBook {
	
	private String title;
	private double price;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public EBook(String title, double price){
		this.title = title;
		this.price = price;
	}
	@Override
	public String toString() {
		return "(title=" + this.title + ",price=" + this.price + ")";
	}
}

class EBookComparator implements Comparator<EBook> {

	@Override
	public int compare(EBook o1, EBook o2) {
		if(o1.getPrice()>o2.getPrice()){
			return 1;
		}else if(o1.getPrice()<o2.getPrice()){
			return -1;
		}else {
			return 0;
		}
	}
	
}

public class ComparatorInstance {
	
	public static void main(String[] args) {
		
		EBook[]ebooks = new EBook[]{
				new EBook("THE LONG VIEW", 35.4),
				new EBook("Zero To One", 23.5),
				new EBook("Pride and Prejudice", 33.3)
		};
		Arrays.sort(ebooks, new EBookComparator());
		System.out.println(Arrays.toString(ebooks));
		
		
	}

}
