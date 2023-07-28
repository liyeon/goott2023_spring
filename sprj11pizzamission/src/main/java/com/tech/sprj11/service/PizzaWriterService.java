package com.tech.sprj11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj11.dao.PizzaDao;

public class PizzaWriterService implements PizzaServiceInterface{

	@Override
	public void execute(Model model) {
		System.out.println(">>BWriteService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String pzname = request.getParameter("pzname");
		String pzsubj = request.getParameter("pzsubj");
		String pzcontent = request.getParameter("pzcontent");
		
		PizzaDao dao = new PizzaDao(); // 디비 접속 준비완료
		int flag = dao.write(pzname,pzsubj,pzcontent);
		System.out.println("글작성 성공여부 : "+flag);
	}
}
