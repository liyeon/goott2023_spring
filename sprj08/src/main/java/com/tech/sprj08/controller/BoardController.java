package com.tech.sprj08.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.model.StudentInfo;

@Controller
public class BoardController {
	@RequestMapping("/board/loginform")
	public String loginform() {
		
		return "/board/loginform";
	}
	@RequestMapping(method = RequestMethod.POST, value= "/board/confirm")
	public String confirm(HttpServletRequest request,Model model) {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		model.addAttribute("id", id);
		model.addAttribute("pwd",pwd);
		return "/board/confirm";
	}
	
	@RequestMapping("/board/student")
	public String student() {
		
		return "/board/student";
	}
	
	// 데이터를 객체 통째로 전달
//	@RequestMapping("/board/studentinfo")
//	public String studentinfo(@ModelAttribute("studentinfo") StudentInfo studentInfo) {
//		
//		return "/board/studentinfo";
//	}
	@RequestMapping("/board/studentinfo")
	public String studentinfo(@ModelAttribute("stu") StudentInfo studentInfo) {
		
		return "/board/studentinfo";
	}
}