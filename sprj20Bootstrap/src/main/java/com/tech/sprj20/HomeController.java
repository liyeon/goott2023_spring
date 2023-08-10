package com.tech.sprj20;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/bootstrap1", method = RequestMethod.GET)
	public String bootstrap1() {
		return "bootstrap1";
	}
	@RequestMapping(value = "/bootstrap2", method = RequestMethod.GET)
	public String bootstrap2() {
		return "bootstrap2";
	}
}
