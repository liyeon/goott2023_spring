package com.tech.sprj07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoffeeController {
	@RequestMapping("/coffee/coffeeform")
	public String coffeeform() {
		
		return "/coffee/coffeeform";
	}
	@RequestMapping("/coffee/coffeeresult")
	public ModelAndView loginconfirm(@RequestParam String name, String price) {
		ModelAndView m = new ModelAndView();
		m.addObject("name", name);
		m.addObject("price",price);
		m.setViewName("/coffee/coffeeresult");
		return m;
	}
}