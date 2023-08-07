package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

public class BWriteService implements BServiceInterface{

	@Override
	public void execute(Model model,IDao dao) {
		System.out.println(">>BWriteService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String brd_name = request.getParameter("brd_name");
		String brd_title = request.getParameter("brd_title");
		String brd_content = request.getParameter("brd_content");
		
		int flag = dao.write(brd_name,brd_title,brd_content);
		System.out.println("글작성 성공여부 : "+flag);
	}
}
