package com.tech.sprj09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
	private String id;
	private String pwd;
	private String name;
	private String email;
}