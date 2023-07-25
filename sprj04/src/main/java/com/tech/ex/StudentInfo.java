package com.tech.ex;

public class StudentInfo {
	private Student student;
	public StudentInfo() {}
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	
	public void getStudentIfno() {
		if(student!=null) {
			System.out.println("====================================");
			System.out.println("이름 : "+ student.getName());
			System.out.println("나이 : "+ student.getAge());
			System.out.println("학년 : "+ student.getGradeNum());
			System.out.println("반 : "+ student.getClassNum());
			System.out.println("취미 : "+student.getHobbys());
			System.out.println("좋아하는메뉴 : "+student.getMaps());
			System.out.println("====================================");
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}