package com.tech.sprj11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj11.dao.PizzaDao;
import com.tech.sprj11.dto.PizzaDto;

public class PizzaReplyViewService implements PizzaServiceInterface {

	@Override
	public void execute(Model model) {
		System.out.println(">>BReplyViewService 신호를 받아보자");

		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String spzid = request.getParameter("pzid");
		int pzid = Integer.parseInt(spzid);
		// 디비에 접속해서 데이터 가져오기
		PizzaDao dao = new PizzaDao();// 호출
		PizzaDto dto = dao.replyView(pzid);
		// 리턴 받은 해당 글(dto)을 model에 적재
		model.addAttribute("dto", dto);
	}

}