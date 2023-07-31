package com.tech.sprj11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj11.dao.PizzaDao;

public class PizzaReplyService implements PizzaServiceInterface {

	@Override
	public void execute(Model model) {
		System.out.println(">>BReplyService 신호를 받아보자");

		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String spzid = request.getParameter("pzid");
		int pzid = Integer.parseInt(spzid);
		String pzgroup = request.getParameter("pzgroup");
		String pzstep = request.getParameter("pzstep");
		String pzindent = request.getParameter("pzindent");
		String pzname = request.getParameter("pzname");
		String pzsubj = request.getParameter("pzsubj");
		String pzcontent = request.getParameter("pzcontent");
		// 디비에 접속해서 데이터 가져오기
		PizzaDao dao = new PizzaDao();// 호출
		boolean flag = dao.reply(pzid,pzname,pzsubj,pzcontent,pzgroup,pzstep,pzindent);
		System.out.println("답변 등록 성공여부 : " + flag);
	}

}