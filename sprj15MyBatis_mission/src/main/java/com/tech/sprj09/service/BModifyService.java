package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

public class BModifyService implements BServiceInterface{

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BModifyService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bid = Integer.parseInt(request.getParameter("brd_id"));
		String bname = request.getParameter("brd_name");
		String btitle = request.getParameter("brd_title");
		String bcontent = request.getParameter("brd_content");
		
		int flag = dao.modify(bid,bname,btitle,bcontent);
		System.out.println("글수정 성공여부 : "+flag);
	}
}
