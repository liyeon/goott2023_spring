package com.tech.sprj09.dao;

import com.tech.sprj09.dto.ReviewDto;

public interface ReviewDao {
	public void reviewwrite(String review,String point);
	public ReviewDto getReview(String reno);
		
}