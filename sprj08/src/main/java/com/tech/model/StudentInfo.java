package com.tech.model;

public class StudentInfo {
	private String id;
	private String pw;
	private String age;
	
	public StudentInfo() {
	}

	public StudentInfo(String id, String pw, String age) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	
}