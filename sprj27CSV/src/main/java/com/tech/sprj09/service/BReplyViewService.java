package com.tech.sprj09.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.BoardDao;
import com.tech.sprj09.dto.BoardDto;

public class BReplyViewService implements BServiceInter{

	@Override
	public void execute(Model model) {
		System.out.println(">>>BReplyViewService");
		
//		map변환
		Map<String, Object> map=model.asMap();
//		map에서 request추출
		HttpServletRequest request=
				(HttpServletRequest) map.get("request");
		String bid=request.getParameter("bid");
		
		BoardDao dao=new BoardDao();
		BoardDto dto=dao.replyView(bid);
		model.addAttribute("reply_view",dto);
	}
}
