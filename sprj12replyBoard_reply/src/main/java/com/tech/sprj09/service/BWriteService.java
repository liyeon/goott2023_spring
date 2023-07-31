package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.tech.sprj09.dao.BoardDao;

public class BWriteService implements BServiceInterface{

	@Override
	public void execute(Model model) {
		System.out.println(">>BWriteService 신호를 받아보자");
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao(); // 디비 접속 준비완료
		int flag = dao.write(bname,btitle,bcontent);
		System.out.println("글작성 성공여부 : "+flag);
	}
}
