package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

public class BDeleteService implements BServiceInterface{

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BDeleteService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String sbid = request.getParameter("bid");
		int bid = Integer.parseInt(sbid);
//		BoardDao dao = new BoardDao(); // 디비 접속 준비완료
		boolean flag = dao.delete(bid);
		System.out.println("글삭제 성공여부 : "+flag);
		System.out.println("삭제된 글번호 : "+sbid);
	}
}
