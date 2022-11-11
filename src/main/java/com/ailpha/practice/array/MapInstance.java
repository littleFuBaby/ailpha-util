package com.ailpha.practice.array;

import java.util.*;

class Goods{
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Goods() {
		super();
	}
	public Goods(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Goods other = (Goods) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", price=" + price + "]";
	}
}

public class MapInstance {
	
	public static void main(String[] args) {
		// hashmap
		Map<String, Double> map = new HashMap<String, Double>();
		map.put("pepsi", 4.0);
		map.put("sprite", 3.5);
		map.put(null, 0.0);
		map.put("123-", 44.4);
		map.put("test", 44.4);
		map.put("test", 54.4);
		System.out.println(map);
		
		// hashtable
		map = new Hashtable<>();
		map.put("pepsi", 4.0);
		map.put("sprite", 3.5);
		// map.put(null, 0.0);
		// map.put("", null);
		System.out.println(map);
		
		// hashmap key
		Map<Goods, Goods> maps = new HashMap<>();
		maps.put(new Goods("coco",4.5), new Goods("pepsi", 3.5));
		maps.put(new Goods("java",2.5), new Goods("india", 3.5));
		maps.put(new Goods("java",2.5), new Goods("india", 3.5));
		maps.put(new Goods("coco",4.5), new Goods("pepsi", 3.5));
		Set<Map.Entry<Goods, Goods>> entry = maps.entrySet();
		Iterator<Map.Entry<Goods, Goods>> iter = entry.iterator();
		while(iter.hasNext()){
			Map.Entry<Goods, Goods> goods = iter.next();
			System.out.println(goods.getKey() + "--" + goods.getValue());
		}
		
		Map<String, String> linkedMap = new LinkedHashMap<>();
		linkedMap.put("123", "34");
		
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.put("234", "34");
		
		Map<String, String> weakHashMap = new WeakHashMap<>();
		weakHashMap.put("dd", "dd");
		
	}

}
