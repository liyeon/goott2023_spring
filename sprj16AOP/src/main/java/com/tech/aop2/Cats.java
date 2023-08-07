package com.tech.aop2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	public void getCatsInfo() {
		System.out.println("===============");
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("색상 : "+getColor());
		System.out.println("===============");
	}
	
	public void getColorChar() {
		if(name.equals("호랑이")) {
			System.out.println("==================");
			System.out.println("이녀석 성격이 용맹하다앙");
			System.out.println("==================");
		}else {
			System.out.println("==================");
			System.out.println("이녀석 완죠니 온순 그잡ㅊ채");
			System.out.println("==================");
		}
	}
}