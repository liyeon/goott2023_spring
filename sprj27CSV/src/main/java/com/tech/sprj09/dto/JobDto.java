package com.tech.sprj09.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {
	private String job;
	private int salsum;
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getSalsum() {
		return salsum;
	}
	public void setSalsum(int salsum) {
		this.salsum = salsum;
	}
	
}
