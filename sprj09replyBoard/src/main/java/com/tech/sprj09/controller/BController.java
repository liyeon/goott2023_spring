package com.tech.sprj09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.sprj09.service.BListService;
import com.tech.sprj09.service.BServiceInterface;

@Controller
public class BController {
	
	BServiceInterface bServiceInterface;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		bServiceInterface=new BListService();
		bServiceInterface.execute(model);
		return "/list";
	}
	
}