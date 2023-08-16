package com.tech.sprj09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeptDto {
	private int deptno;
	private String dname;
	private String loc;
}