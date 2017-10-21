package com.hackerxiehao.hnrmgmt.entities;

public class Award {
	private String awdID;
	private String name;
	private String gradeName;
	private String grade;

	public String getAwdID() {
		return awdID;
	}

	public void setAwdID(String awdID) {
		this.awdID = awdID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Award(String name, String gradeName, String grade) {
		super();
		this.name = name;
		this.gradeName = gradeName;
		this.grade = grade;
	}

	public Award() {
		super();
	}

	@Override
	public String toString() {
		return "Award [awdID=" + awdID + ", name=" + name + ", gradeName=" + gradeName + ", grade=" + grade + "]";
	}

}
