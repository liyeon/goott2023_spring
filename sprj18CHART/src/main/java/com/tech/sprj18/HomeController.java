package com.tech.sprj18;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	
	@RequestMapping("/line1")
	public String line1() {
		
		return "chart/line";
	}
	@RequestMapping("/graph1")
	public String graph1() {
		return "chart/graph1";
	}
	@RequestMapping("/graph2")
	public String graph2() {
		return "chart/graph2";
	}
	@RequestMapping("/bootstrap")
	public String bootstrap() {
		
		return "chart/bootstrap";
	}
}
