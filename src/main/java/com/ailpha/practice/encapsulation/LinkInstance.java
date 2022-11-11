package com.ailpha.practice.encapsulation;

import java.util.Arrays;

class Pen{
	private String brand;
	private double price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Pen(String brand, double price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	public boolean equals(Pen pen){
		if(pen == null){
			return false;
		}
		if(pen == this){
			return true;
		}
		if(this.brand.equals(pen.brand)
				&&this.price == pen.price){
			return true;
		}
		return false;
	}
	public String toString() {
		return "Brand is " + this.brand + ",price is " + this.price;
	}
}

class Link {
	
	private int count;
	private Node root;
	private int foot;
	private Object[] array;
	public Link(){}
	public Link(Object name){
		add(name);
	}
	
	private class Node {
		private Object name;
		private Node next;
		public Node(Object name){
			this.name = name;
		}
		public void addNode(Node node){
			if(this.next==null){
				this.next = node;
			}else {
				this.next.addNode(node);
			}
		}
		public void printNode(){
			System.out.println(this.name);
			if(this.next!=null){
				this.next.printNode();
			}
		}
		public boolean containsNode(Object name){
			if(name == null){
				return false;
			}
			if(this.name.equals(name)){
				return true;
			}else if(this.next!=null){
				return this.next.containsNode(name);
			}else {
				return false;
			}
		}
		public Object getNode(int index){
			if(Link.this.foot++ == index){
				return this.name;
			}
			return this.next.getNode(index);
		}
		public void setNode(int index, Object name){
			if(Link.this.foot++ == index){
				this.name = name;
				return ;
			}
			this.next.setNode(index, name);
		}
		public void removeNode(Node previous, Object name){
			if(this.name.equals(name)){
				previous.next = this.next;
			}else {
				this.next.removeNode(this, name);
			}
		}
		public void toArrayNode(){
			Link.this.array[foot++] = this.name;
			if(this.next!=null){
				this.next.toArrayNode();
			}
		}
	}
	
	public void add(Object name){
		if(name == null){
			return ;
		}
		Node node = new Node(name);
		if(this.root == null){
			this.root = node;
		}else {
			this.root.addNode(node);
		}
		this.count++;
	}
	public void print(){
		if(this.root!=null){
			this.root.printNode();
		}
	}
	public int size(){
		return this.count;
	}
	public boolean isEmpty(){
		return this.root == null;
	}
	public boolean contains(Object name){
		if(name == null || this.root == null){
			return false;
		}
		return this.root.containsNode(name);
	}
	public Object get(int index){
		if(index < 0 || index >= this.count){
			return null;
		}
		this.foot = 0;
		return this.root.getNode(index);
	}
	public void set(int index, Object name){
		if(index < 0 || index >= this.count){
			return ;
		}
		this.foot = 0;
		this.root.setNode(index, name);
	}
	public void remove(Object name){
		if(!this.contains(name)){
			return ;
		}
		if(this.root.name.equals(name)){
			this.root = this.root.next;
		}else {
			this.root.next.removeNode(this.root,name);
		}
		this.count--;
	}
	public Object[] toArray(){
		if(this.count == 0){
			return null;
		}
		this.foot = 0;
		this.array = new Object[this.count];
		this.root.toArrayNode();
		return this.array;
	}
}

public class LinkInstance {
	public static void main(String[] args) {
		Link link = new Link();
		if(link.isEmpty()){
			link.add(new Pen("deli1", 11.3));
			link.add(new Pen("deli0", 10.3));
			link.add(new Pen("deli3", 13.3));
		}
		link.add(new Pen("deli2", 12.3));
		link.print();
		System.out.println(link.contains(new Pen("deli1", 11.3)));
		System.out.println(link.contains(new Pen("deli1", 11.4)));
		System.out.println(link.get(2));
		link.set(2, new Pen("deli3", 23.3));
		System.out.println(link.get(2));
		System.out.println(link.size());
		link.remove(new Pen("deli1", 11.3));
		System.out.println(link.size());
		Object[]objs = link.toArray();
		System.out.println(Arrays.toString(objs));
	}
}
