package com.tech.sprj19;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/main1", method = RequestMethod.GET)
	public String main1() {
		return "main";
	}
	@RequestMapping(value = "/main2", method = RequestMethod.GET)
	public String main2(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "main2";
	}
	@RequestMapping(value = "/main3", method = RequestMethod.GET)
	public String main3(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "main3";
	}
	@RequestMapping(value = "/board.list", method = RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "board/list";
	}
	
	@RequestMapping(value = "/board.detail", method = RequestMethod.GET)
	public String detail(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "board/detail";
	}
	
	@RequestMapping(value = "/notice.detail", method = RequestMethod.GET)
	public String noticedetail(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "notice/detail";
	}
	@RequestMapping(value = "/notice.edit", method = RequestMethod.GET)
	public String noticeedit(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "notice/edit";
	}
	@RequestMapping(value = "/notice.list", method = RequestMethod.GET)
	public String noticelist(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "notice/list";
	}
}
