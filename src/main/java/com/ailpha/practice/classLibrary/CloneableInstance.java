package com.ailpha.practice.classLibrary;

class Java implements Cloneable {
	
	private String detail;

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Java() {
		super();
	}

	public Java(String detail) {
		super();
		this.detail = detail;
	}
	
	public Java copy() throws CloneNotSupportedException {
		return (Java) this.clone();
	}
	
	@Override
	public String toString() {
		return this.detail;
	}
	
}

public class CloneableInstance {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Object obj = new Java("clone");
		// access right
		Java java = ((Java) obj).copy();
		System.out.println(obj);
		System.out.println(java);
		System.out.println(obj == java);
	}

}
