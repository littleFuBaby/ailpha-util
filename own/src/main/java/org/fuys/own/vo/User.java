package org.fuys.own.vo;

import java.io.Serializable;

/**
 * user vo
 * @author ys
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -6757902101613856970L;
	
	public User(String name) {
		this.name = name;
	}
	
	public User(int age,String name) {
		this.age = age;
		this.name = name;
	}
	
	public User(String name,Province province){
		this.name = name;
		this.province = province;
	}
	
	private String name;
	private int age;
	private Province province;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

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
		return "User [age="+age+",name=" + name + ", province=" + province + "]";
	}
}
