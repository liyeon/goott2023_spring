package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;

public class BReplyViewService implements BServiceInterface {

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BReplyViewService 신호를 받아보자");

		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String sbid = request.getParameter("bid");
		int bid = Integer.parseInt(sbid);
		// 디비에 접속해서 데이터 가져오기
//		BoardDao dao = new BoardDao();// 호출
		BoardDto dto = dao.replyView(bid);
		// 리턴 받은 해당 글(dto)을 model에 적재
		model.addAttribute("dto", dto);
	}

}