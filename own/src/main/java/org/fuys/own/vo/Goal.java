package org.fuys.own.vo;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

@Repository
public class Goal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3571483870932700806L;

	private String name;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Goal [name=" + name + ", description=" + description + "]";
	}

}
