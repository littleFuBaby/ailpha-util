package com.ailpha.vo;

import java.io.Serializable;
import java.util.Map;
import java.util.Properties;

public class Goods implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6848532941789324138L;
	
	private String name;
	private Map<String, String> information;
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getInformation() {
		return information;
	}

	public void setInformation(Map<String, String> information) {
		this.information = information;
	}

	@Override
	public String toString() {
		return "Goods [name=" + name + ", information=" + information + ", properties=" + properties + "]";
	}

}
