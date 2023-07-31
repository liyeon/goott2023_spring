package com.tech.sprj09.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprj09.service.BContentViewService;
import com.tech.sprj09.service.BDeleteService;
import com.tech.sprj09.service.BListService;
import com.tech.sprj09.service.BModifyService;
import com.tech.sprj09.service.BServiceInterface;
import com.tech.sprj09.service.BWriteService;

@Controller
public class BController {

	BServiceInterface bServiceInterface;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		bServiceInterface = new BListService();
		bServiceInterface.execute(model);
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
		// toss
		model.addAttribute("request", request);
		bServiceInterface = new BWriteService();
		bServiceInterface.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("=====content_view_view====");

//		글조회
		model.addAttribute("request", request);
		bServiceInterface = new BContentViewService();
		bServiceInterface.execute(model);
		return "/content_view";
	}

	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request, Model model) {
		System.out.println("=====content_update====");
		model.addAttribute("request", request);
		bServiceInterface = new BContentViewService();
		bServiceInterface.execute(model);
		return "/content_update";
	}

	// 글 수정
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("=====modify====");
		model.addAttribute("request", request);
		bServiceInterface = new BModifyService();
		bServiceInterface.execute(model);
		return "redirect:list";
	}

	// 글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("=====delete====");
		model.addAttribute("request", request);
		bServiceInterface = new BDeleteService();
		bServiceInterface.execute(model);
		return "redirect:list";
	}
}