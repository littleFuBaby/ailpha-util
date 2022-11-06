package org.fuys.own.vo;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

@Repository
public class Plan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665895604104725725L;

	private String name;
	@Resource
	private Goal goal;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return "Plan [name=" + name + ", goal=" + goal + "]";
	}

}
