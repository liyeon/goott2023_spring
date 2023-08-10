package com.tech.springwebt_mail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private String shpwd;
	private String bcpwd;
	private int mailcheck;
	public MemberDTO(String id, String pw, String nickname, String email, String shpwd, String bcpwd) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
		this.shpwd = shpwd;
		this.bcpwd = bcpwd;
	}
}