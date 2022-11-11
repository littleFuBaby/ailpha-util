package com.ailpha.practice.encapsulation;

class Node{
	private String content;
	private Node last;
	private Node next;
	public Node getLast() {
		return last;
	}
	public void setLast(Node last) {
		this.last = last;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Node(String content){
		this.content = content;
	}
}

public class NodeInstance {
	
	public static void main(String[] args) {
		Node root = new Node("root");
		Node node1 = new Node("node1");
		Node node2 = new Node("node2");
		Node node3 = new Node("node3");
		root.setNext(node1);
		node1.setNext(node2);
		node1.setLast(root);
		node2.setNext(node3);
		node2.setLast(node1);
		node3.setLast(node2);
		printAll(node2);
	}
	public static void printAll(Node node){
		if(node == null){
			return ;
		}
		printALlLast(node);
		printALlNext(node);
	}
	public static void printALlLast(Node node){
		if(node == null){
			return ;
		}
		printALlLast(node.getLast());
		System.out.println(node.getContent());
	}
	public static void printALlNext(Node node){
		if(node == null){
			return ;
		}
		System.out.println(node.getContent());
		printALlNext(node.getNext());
	}
}
