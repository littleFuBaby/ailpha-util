package org.fuys.own.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository
public class Goal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3571483870932700806L;

	private String goalId;
	private String name;
	private String description;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGoalId() {
		return goalId;
	}

	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}

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
		return "Goal [goalId=" + goalId + ", name=" + name + ", description=" + description + ", date=" + date + "]";
	}

}
