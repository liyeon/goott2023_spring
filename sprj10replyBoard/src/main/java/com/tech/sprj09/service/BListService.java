package com.tech.sprj09.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.BoardDao;
import com.tech.sprj09.dto.BoardDto;

@Service
public class BListService implements BServiceInterface{

	@Override
	public void execute(Model model) {
		System.out.println(">>BListService 신호를 받아보자");
		// 디비에 접속해서 데이터 가져오기
		BoardDao dao = new BoardDao();//호출
		ArrayList<BoardDto> dto = dao.list();
		//모델에 전달하기
		model.addAttribute("list",dto);
	}
}