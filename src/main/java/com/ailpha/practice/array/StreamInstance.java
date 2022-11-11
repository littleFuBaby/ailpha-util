package com.ailpha.practice.array;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DataStream implements Comparable<DataStream> {
	private String key;
	private Double value;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public DataStream() {
		super();
	}
	public DataStream(String key, Double value) {
		super();
		this.key = key;
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		DataStream other = (DataStream) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	@Override
	public int compareTo(DataStream o) {
		if(o == null){
			return -1;
		}
		if(this.value > o.value){
			return 1;
		}else if(this.value == o.value){
			return 0;
		}else {
			return -1;
		}
	}
	public DataStream multiplyVal(double d){
		this.value *= d;
		return this;
	}
	public boolean filter(String str){
		if(this.key.contains(str)){
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "DataStream [key=" + key + ", value=" + value + "]";
	}
}

public class StreamInstance {
	
	public static void main(String[] args) {
		// List for Stream
		List<String> list = new ArrayList<String>();
		list.add("fu");
		list.add("fu");
		list.add("yun");
		list.add("yun");
		list.add("song");
		list.add("song");
		Stream<String> stream = list.stream();
//		System.out.println(stream.distinct().count());
		List<String> newList = stream.distinct().map((x) -> x.toUpperCase()).
				filter((x) -> x.contains("U")).collect(Collectors.toList());
		newList.forEach(System.out :: println);
		
		// Map for Stream
		Map<String, String> map = new HashMap<String, String>();
		map.put("fu", "0987");
		map.put("yun", "098");
		map.put("song", "09");
		map.put("fuy", "09");
		map.put("yuns", "09");
		map.put("ys", "09");
		map.put("ysfu", "09");
		map.put("fuys", "09");
		
		Stream<String> dataStream = map.keySet().stream();
		System.out.println(dataStream.anyMatch((x) -> x.endsWith("u")));
		
		dataStream = map.keySet().stream();
		System.out.println(dataStream.count());
		
		dataStream = map.keySet().stream();
		Set<String> set = dataStream.filter((x) -> x.contains("u")).map((x) -> x.toUpperCase()).distinct().limit(3)
			.collect(Collectors.toSet());
		System.out.println(set);
		
		Set<DataStream> sets = new HashSet<>();
		sets.add(new DataStream("fu", 123.0));
		sets.add(new DataStream("fuy", 123.4));
		sets.add(new DataStream("fuys", 123.5));
		sets.add(new DataStream("yun", 123.2));
		System.out.println(sets);
		
		Stream<DataStream> dataSrm = sets.stream();
		sets = dataSrm.map((x) -> x.multiplyVal(6)).filter((x)-> x.filter("s")).collect(Collectors.toSet());
		System.out.println(sets);
		
	}

}
