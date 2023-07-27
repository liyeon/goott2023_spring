package com.tech.sprj08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FoodController {
	@RequestMapping("/food/food")
	public String food() {
		return "/food/food";
	}
	@RequestMapping("/food/kfood")
	public String kfood(@RequestParam String k1, String k2, Model model) {
		model.addAttribute("food1",k1);
		model.addAttribute("food2",k2);
		return "/food/kfood";
	}
	@RequestMapping("/food/wfood")
	public ModelAndView wfood(@RequestParam String w1, String w2) {
		
		ModelAndView m = new ModelAndView();
		m.addObject("food1", w1);
		m.addObject("food2", w2);
		m.setViewName("/food/wfood");
		return m;
	}
}