package com.ailpha.practice.classLibrary;

import java.util.Arrays;

class Water {
	private double content;
	public Water(double content){
		this.content = content;
	}
	@Override
	public String toString() {
		return "content="+this.content;
	}
}

public class SystemInstance {
	
	public static void main(String[] args) {
		// current time
		System.out.println(System.currentTimeMillis());
		
		// array copy
		Water[][] waters_1 = new Water[][]{{},{
				new Water(3000),
				new Water(3500),
				new Water(4000),
		}};
		Water[][] waters_2 = new Water[2][5];
		waters_2[0][0] = new Water(2000);
		waters_2[0][1] = new Water(2500);
		
		System.arraycopy(waters_1[1], 0, waters_2[0], 2, 3);
		
		System.out.println(Arrays.toString(waters_2[0]));
	}

}
