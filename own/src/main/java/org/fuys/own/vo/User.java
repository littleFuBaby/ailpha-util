package org.fuys.own.vo;

import java.io.Serializable;

/**
 * user vo
 * @author ys
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6757902101613856970L;
	
	public User(String name,Province province){
		this.name = name;
		this.province = province;
	}
	
	private String name;
	private Province province;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", province=" + province + "]";
	}
}
