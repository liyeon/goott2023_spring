package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;

@Service
public class BContentViewService implements BServiceInterface{

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BContentViewService.java 신호를 받아보자");
		
		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		int bid = Integer.parseInt(request.getParameter("bid"));
		dao.upHit(bid);
		BoardDto dto = dao.contentView(bid);
		//리턴 받은 해당 글(dto)을 model에 적재
		model.addAttribute("dto",dto);
	}
}