package com.tech.sprj11.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PizzaDto {
	private int pzid;
	private String pzname;
	private String pzsubj;
	private String pzcontent;
	private Date pzdate;
	private int pzhit;
	private int pzgroup;
	private int pzstep;
	private int pzintent;
}//class