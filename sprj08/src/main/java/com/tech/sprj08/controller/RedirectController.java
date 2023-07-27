package com.tech.sprj08.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedirectController {
	
	@RequestMapping("/studentConfirm")
	public String studentConfirm(HttpServletRequest request) {
		System.out.println("스튜던트컨펌");
		String id=request.getParameter("id");
		if(id.equals("abc")) {
			return "redirect:studentOk";
		}
		return "redirect:studentNg?msg=try";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk(HttpServletRequest request) {
		
		System.out.println("스튜던트옼께이");
		return "/studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg(HttpServletRequest request) {
		
		System.out.println("스튜던트엔지이이이ㅣㅣㅇ"+request.getParameter("msg"));
		return "/studentNg";
	}
}//class