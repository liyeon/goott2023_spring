package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

public class BReplyService implements BServiceInterface {

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BReplyService 신호를 받아보자");

		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String sbid = request.getParameter("bid");
		int bid = Integer.parseInt(sbid);
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		dao.replyShape(bgroup, bstep);
		boolean flag = dao.reply(bid,bname,btitle,bcontent,bgroup,bstep,bindent);
		System.out.println("답변 등록 성공여부 : " + flag);
	}

}