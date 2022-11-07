package com.ailpha.vo;

import java.io.Serializable;

public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3288120008170102555L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + "]";
	}

}
