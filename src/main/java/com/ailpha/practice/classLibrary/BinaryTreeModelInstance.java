package com.ailpha.practice.classLibrary;

import java.util.Arrays;

class Pant implements Comparable<Object> {
	
	private String brand;
	private double price;
	public Pant(String brand, double price){
		this.brand = brand;
		this.price = price;
	}
	@Override
	public int compareTo(Object obj) {
		if(obj == null)
			return -1;
		if(obj == this)
			return 0;
		if(!(obj instanceof Pant)){
			return -1;
		}
		Pant pant = (Pant)obj;
		if(this.price>pant.price){
			return 1;
		}else if(this.price<pant.price){
			return -1;
		}else {
			return 0;
		}
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if((obj instanceof Pant)==false){
			return false;
		}
		Pant pant = (Pant)obj;
		if(this.brand.equals(pant.brand)
				&& this.price == pant.price){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[brand=" + this.brand + ",price=" + this.price + "]";
	}
	
}

class BinaryTreeLink {
	
	private int size;
	private Node root;
	private Object[] pants;
	private int foot;
	
	public BinaryTreeLink(){
	}
	
	private class Node {
		
		private Comparable<Object> pant;
		private Node prev;
		private Node next;
		public Node (Comparable<Object> pant){
			this.pant = pant;
		}
		public void addNode(Node node){
			if(this.pant.compareTo(node.pant)>0){
				if(this.prev==null){
					this.prev = node;
				}else {
					this.prev.addNode(node);
				}
			}else {
				if(this.next==null){
					this.next = node;
				}else {
					this.next.addNode(node);
				}
			}
		}
		public Object[] toArrayNode(){
			if(this.prev!=null){
				this.prev.toArrayNode();
			}
			BinaryTreeLink.this.pants[BinaryTreeLink.this.foot++] = this.pant;
			if(this.next!=null){
				this.next.toArrayNode();
			}
			return BinaryTreeLink.this.pants;
		}
		public boolean containsNode(Comparable<Object> pant){
			for(int i = 0; i< BinaryTreeLink.this.pants.length; i++){
				if(BinaryTreeLink.this.pants[i].equals(pant)){
					return true;
				}
			}
			return false;
		}
	}
	
	public void add(Comparable<Object> pant){
		Node node = new Node(pant);
		if(this.root == null){
			this.root = node;
		}else {
			this.root.addNode(node);
		}
		this.size++;
	}
	public int size(){
		return this.size;
	}
	public Object[] toArray(){
		if(this.root==null)
			return null;
		this.pants = new Object[this.size];
		this.foot = 0;
		this.pants = this.root.toArrayNode();
		return this.pants;
	}
	public boolean isEmpty(){
		return this.root==null;
	}
	public boolean contains(Comparable<Object> pant){
		if(this.root==null){
			return false;
		}
		this.pants = new Object[this.size];
		this.foot = 0;
		this.pants = this.root.toArrayNode();
		return this.root.containsNode(pant);
	}
}

public class BinaryTreeModelInstance {

	public static void main(String[] args) {
		
		BinaryTreeLink link = new BinaryTreeLink();
		System.out.println(link.size());
		System.out.println(link.isEmpty());
		link.add(new Pant("J Brand", 2000));
		link.add(new Pant("Paige", 1000));
		link.add(new Pant("Rag&Bone", 1500));
		link.add(new Pant("Frame Denim", 1500));
		link.add(new Pant("Current/Elliott", 2100));
		System.out.println(link.size());
		System.out.println(Arrays.toString(link.toArray()));
		System.out.println(link.contains(new Pant("Current/Elliott", 2100)));
		
	}

}
