package com.tech.sprj11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj11.dao.PizzaDao;

public class PizzaDeleteService implements PizzaServiceInterface{

	@Override
	public void execute(Model model) {
		System.out.println(">>BDeleteService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String spzid = request.getParameter("bid");
		int pzid = Integer.parseInt(spzid);
		PizzaDao dao = new PizzaDao(); // 디비 접속 준비완료
		boolean flag = dao.delete(pzid);
		System.out.println("글삭제 성공여부 : "+flag);
		System.out.println("삭제된 글번호 : "+pzid);
	}
}
