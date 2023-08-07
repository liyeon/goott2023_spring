package com.tech.sprj09.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardDto {
	private int brd_id;
	private String brd_name;
	private String brd_title;
	private String brd_content;
	private Timestamp brd_date;
	private int brd_hit;
	private int brd_group;
	private int brd_step;
	private int brd_indent;
}//class