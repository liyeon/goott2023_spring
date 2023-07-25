package com.tech.ex;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
	private String name;
	private String age;
	private String gradeNum;
	private String classNum;
	
	private ArrayList<String> hobbys;
	private HashMap<String, String> maps;
	
	public Student() {}
	
	public Student(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name, String age, String gradeNum, String classNum, ArrayList<String> hobbys,
			HashMap<String, String> maps) {
		super();
		this.name = name;
		this.age = age;
		this.gradeNum = gradeNum;
		this.classNum = classNum;
		this.hobbys = hobbys;
		this.maps = maps;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGradeNum() {
		return gradeNum;
	}

	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}

	public ArrayList<String> getHobbys() {
		return hobbys;
	}

	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}

	public HashMap<String, String> getMaps() {
		return maps;
	}

	public void setMaps(HashMap<String, String> maps) {
		this.maps = maps;
	}
	
}