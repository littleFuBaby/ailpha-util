package com.ailpha.practice.array;

import java.util.*;

public class ListInstance {

	public static void main(String[] args) {

		// ArrayList
		List<String> list = new ArrayList<>();
		list.add("fu");
		list.add("yun");
		list.add("song");

		// ListIterator
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// get()
		// set()
		System.out.println(list.get(1));
		System.out.println("replace index 1 :" + list.set(1, ""));
		System.out.println("replace index 2 :" + list.set(2, "andy"));
		
		// remove
		list = new ArrayList<>();
		list.add("f");
		list.add("u");
		list.add("y");
		list.add("n");
		
		System.out.println("list:" + list);
		System.out.println("index 2 before remove:" + list.get(2));
		list.remove(2);
		System.out.println("list:" + list);
		System.out.println("index 2 after remove:" + list.get(2));
		

		// Iterator
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// LinkedList
		List<String> linkedList = new LinkedList<>();
		linkedList.add("fu");
		linkedList.add("yun");
		linkedList.add("song");

		// Vector
		List<String> vector = new Vector<>();
		vector.add("03");
		vector.add("05");
		vector.add("12");

		// Iterator
		Iterator<String> itera = vector.iterator();
		while (itera.hasNext()) {
			System.out.println(itera.next());
		}
		
		
	}
}


