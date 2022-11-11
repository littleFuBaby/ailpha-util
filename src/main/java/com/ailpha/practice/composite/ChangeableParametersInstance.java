package com.ailpha.practice.composite;

import java.util.Arrays;
import java.util.Calendar;

class ChangeableParameters {
	
	private Object[] objects;
	
	public ChangeableParameters(Object... objects){
		this.objects = objects;
	}
	
	public void print(){
		System.out.println(Arrays.toString(this.objects));
	}
	
}

public class ChangeableParametersInstance {

	public static void main(String[] args) {
		
		ChangeableParameters cp = new ChangeableParameters(0,0l,0.0f,0.0d,'\u0000',
				false,null,"Hello World", Calendar.getInstance().getTime());
		cp.print();
		cp = new ChangeableParameters();
		cp.print();
		
	}

}
