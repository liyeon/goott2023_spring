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
	@RequestMapping(value = "/main4", method = RequestMethod.GET)
	public String main4(Model model) {
		
		model.addAttribute("id","dongdongi");
		model.addAttribute("addr","seoul");
		return "main4/center4";
	}
}
