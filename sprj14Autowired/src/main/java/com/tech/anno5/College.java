package com.tech.anno5;

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
	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
}//class