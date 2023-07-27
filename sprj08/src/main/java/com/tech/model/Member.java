package com.tech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor 
public class Member {
	private String name;
	private String id;
	private String pw;
	private String email;
	
//	public Member() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public Member(String name, String id, String pw, String email) {
//		super();
//		this.name = name;
//		this.id = id;
//		this.pw = pw;
//		this.email = email;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getPw() {
//		return pw;
//	}
//
//	public void setPw(String pw) {
//		this.pw = pw;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
	
}
