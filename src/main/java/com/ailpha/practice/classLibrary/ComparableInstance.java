package com.ailpha.practice.classLibrary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Ship implements Comparable<Ship> {
	private double weight;
	public Ship(double weight){
		this.weight = weight;
	}
	@Override
	public int compareTo(Ship o) {
		if(o==null){
			return -1;
		}
		if(this == o){
			return 0;
		}
		if(this.weight>o.weight){
			return 1;
		}else if(this.weight<o.weight){
			return -1;
		}else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "weight=" + this.weight;
	}
}

public class ComparableInstance {

	public static void main(String[] args) {
		// comparable with treeset
		Set<Ship> set = new TreeSet<>();
		set.add(new Ship(12));
		set.add(new Ship(13));
		set.add(new Ship(12));
		set.add(new Ship(13));
		System.out.println(Arrays.toString(set.toArray()));
		
		// comparable with hashset
		set = new HashSet<>();
		set.add(new Ship(12));
		set.add(new Ship(12));
		set.add(new Ship(13));
		set.add(new Ship(13));
		System.out.println(Arrays.toString(set.toArray()));
		
	}

}
