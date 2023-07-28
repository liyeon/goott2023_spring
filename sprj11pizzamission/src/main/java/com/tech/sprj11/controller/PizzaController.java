package com.tech.sprj11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.sprj11.service.PizzaContentViewService;
import com.tech.sprj11.service.PizzaListService;
import com.tech.sprj11.service.PizzaServiceInterface;
import com.tech.sprj11.service.PizzaWriterService;

@Controller
public class PizzaController {
	
	PizzaServiceInterface pizzaService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		pizzaService=new PizzaListService();
		pizzaService.execute(model);
		return "/list";
	}
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("=====write_view====");
		return "/write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("=====write====");
		
		// 글쓰기 진행
		model.addAttribute("request",request);
		pizzaService = new PizzaWriterService(); 
		pizzaService.execute(model);
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("=====content_view_view====");
		
//		글조회
		model.addAttribute("request",request);
		pizzaService=new PizzaContentViewService();
		pizzaService.execute(model);
		return "/content_view";
	}
}