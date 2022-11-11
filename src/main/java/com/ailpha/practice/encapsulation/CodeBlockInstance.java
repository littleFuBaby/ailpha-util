package com.ailpha.practice.encapsulation;

/**
 * Code Block instance
 * @author ys
 *
 */
class CodeBlock{
	
	// Static Code Block
	// Higher privilege than Constructor Code Block
	// Used first time when class is used
	static{
		System.out.println("Static Code Block");
	}
	// Constructor Code Block
	// Higher privilege than Constructor Method
	// Used many times when object is instantiated
	{
		System.out.println("Constructor Code Block");
	}
	public CodeBlock(){
		System.out.println("Constructor Method");
	}
	
	public void normalCodeBlock(){
		// Normal Code Block
		{
			String info = "Normal Code Block";
			System.out.println(info);
		}
		String info = "Normal Code";
		System.out.println(info);
		// Synchronized Code Block
		synchronized(this){
			info = "Synchronized Code Block";
			System.out.println(info);
		}
	}	
}

public class CodeBlockInstance {

	public static void main(String[] args) {
		CodeBlock codeBlock = new CodeBlock();
		codeBlock.normalCodeBlock();
		codeBlock = new CodeBlock();
		codeBlock.normalCodeBlock();
	}
}
