package com.tech.sprj11.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj11.dao.PizzaDao;
import com.tech.sprj11.dto.PizzaDto;

@Service
public class PizzaListService implements PizzaServiceInterface{

	@Override
	public void execute(Model model) {
		System.out.println(">>BListService 신호를 받아보자");
		// 디비에 접속해서 데이터 가져오기
		PizzaDao dao = new PizzaDao();//호출
		ArrayList<PizzaDto> dto = dao.list();
		//모델에 전달하기
		model.addAttribute("list",dto);
	}
}