package com.ailpha.practice.inheritance;


class Obj{
	
	@Override
	public int hashCode() {
		return super.hashCode() + 1;
	}
	
	@Override
	public String toString() {
		return super.toString() + 1;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println("obj garbage");
	}
}

class Obje extends Obj {
	
	@Override
	public int hashCode() {
		return super.hashCode() + 1;
	}
	@Override
	public String toString() {
		return super.toString() + 1;
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("obje garbage");
	}
}

public class ObjectInstance {

	public static void main(String[] args) throws Throwable {
		
		Object object = new Obje();
		System.out.println(object.toString());
		System.out.println(object.hashCode());
		Obj obj = (Obj)object;
		System.out.println(obj.toString());
		System.out.println(obj.hashCode());
		Obje obje = (Obje)obj;
		System.out.println(obje.toString());
		System.out.println(obje.hashCode());
		
		// because object is strong reference
		// so destroy reference
		object = null;
		obj = null;
		obje = null;
		
		System.gc();
		
	}

}
