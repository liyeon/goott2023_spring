package com.tech.anno4;

public class College {
	private Principal principal;
	public College() {}
	public College(Principal principal) {
		this.principal=principal;
	}
	public void test() {
		principal.principalInfo();
		System.out.println("testing is call methods");
	}
}//class