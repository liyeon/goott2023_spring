package com.tech.sprj06Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/view")
	public String view() {
		return "view";
	}
	@RequestMapping("/content/contentView")
	public String contentView(Model model) {
		// 데이터 전달
		model.addAttribute("id","bllueeee");
		model.addAttribute("name","이름이라구");
		return "/content/contentView";
	}
	
	@RequestMapping("/model/modelEx")
	public String modelEx(Model model) {
		// 데이터 전달
		model.addAttribute("key","bllueeee");
		model.addAttribute("name","이름이라구");
		return "/model/modelEx";
	}
	
	@RequestMapping("/modelAndView/modelView")
	public ModelAndView modelAndView(Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("data","modelandviewdata");
		mv.setViewName("/modelAndView/modelView");
		return mv;
	}
	@RequestMapping("/modelAndView/modelView2")
	public ModelAndView modelAndView2(Model model) {
		
		ModelAndView mv = new ModelAndView();
		ArrayList<String> list = new ArrayList<String>();
		list.add("moview1");
		list.add("moview2");
		list.add("moview3");
		list.add("moview4");
		list.add("moview5");
		list.add("moview6");
		list.add("moview7");
		
		mv.addObject("hobbys", list);
		mv.addObject("data","modelandviewdata");
		mv.setViewName("/modelAndView/modelView2");
		return mv;
	}
}