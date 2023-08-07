package com.tech.ex;

import lombok.Data;

@Data
public class Bottle {
	private String name;
	private String kind;
	private int price;
	
	public void getBottle() {
		System.out.println(name+"님 "+kind+" 술을 "+price+" 원에 많이 많이 먹었습니다.");
	}
}