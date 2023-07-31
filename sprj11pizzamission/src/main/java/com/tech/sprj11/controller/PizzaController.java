package com.tech.sprj11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprj11.service.PizzaContentViewService;
import com.tech.sprj11.service.PizzaDeleteService;
import com.tech.sprj11.service.PizzaListService;
import com.tech.sprj11.service.PizzaModifyService;
import com.tech.sprj11.service.PizzaReplyService;
import com.tech.sprj11.service.PizzaReplyViewService;
import com.tech.sprj11.service.PizzaServiceInterface;
import com.tech.sprj11.service.PizzaWriterService;

@Controller
public class PizzaController {

	PizzaServiceInterface pizzaService;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		pizzaService = new PizzaListService();
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
		model.addAttribute("request", request);
		pizzaService = new PizzaWriterService();
		pizzaService.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("=====content_view_view====");

//		글조회
		model.addAttribute("request", request);
		pizzaService = new PizzaContentViewService();
		pizzaService.execute(model);
		return "/content_view";
	}

	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request, Model model) {
		System.out.println("=====content_update====");
		model.addAttribute("request", request);
		pizzaService = new PizzaContentViewService();
		pizzaService.execute(model);
		return "/content_update";
	}

	// 글 수정
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("=====modify====");
		model.addAttribute("request", request);
		pizzaService = new PizzaModifyService();
		pizzaService.execute(model);
		return "redirect:list";
	}

	// 글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("=====delete====");
		model.addAttribute("request", request);
		pizzaService = new PizzaDeleteService();
		pizzaService.execute(model);
		return "redirect:list";
	}

	// 답변
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("=====reply_view====");
		model.addAttribute("request", request);
		pizzaService = new PizzaReplyViewService();
		pizzaService.execute(model);
		return "reply_view";
	}

	// 댓글달기?
	@RequestMapping(method = RequestMethod.POST, value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("=====reply====");
		model.addAttribute("request", request);
		pizzaService = new PizzaReplyService();
		pizzaService.execute(model);
		return "redirect:list";
	}
}