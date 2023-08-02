package com.tech.sprj09.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.service.BReplyService;
import com.tech.sprj09.service.BReplyViewService;
import com.tech.sprj09.service.BServiceInterface;

@Controller
public class BController {

	BServiceInterface bServiceInterface;
	
//	servlet-context에 등록한 sqlsession을 가져온다.
	@Autowired
	private SqlSession sqlSession;
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
//		bServiceInterface = new BListService();
//		bServiceInterface.execute(model);
		
//		dao = 인터페이스
		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("list",dtos);
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
		// toss
//		model.addAttribute("request", request);
//		bServiceInterface = new BWriteService();
//		bServiceInterface.execute(model);
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.write(bname,btitle,bcontent);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("=====content_view_view====");

//		글조회
//		model.addAttribute("request", request);
//		bServiceInterface=new BWriteService();
//		bServiceInterface.execute(model);
		
		IDao dao = sqlSession.getMapper(IDao.class);
		int bid = Integer.parseInt(request.getParameter("bid"));
		dao.upHit(bid);
		BoardDto dto = dao.content_view(bid);
		model.addAttribute("dto",dto);
		return "/content_view";
	}

	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request, Model model) {
		System.out.println("=====content_update====");
//		model.addAttribute("request", request);
//		bServiceInterface = new BContentViewService();
//		bServiceInterface.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDto dto = dao.content_view(bid);
		model.addAttribute("dto",dto);
		return "/content_update";
	}

	// 글 수정
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("=====modify====");
//		model.addAttribute("request", request);
//		bServiceInterface = new BModifyService();
//		bServiceInterface.execute(model);
		IDao dao = sqlSession.getMapper(IDao.class);
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		int flag = dao.modify(bname,btitle,bcontent,bid);
		System.out.println("글수정 성공여부 : "+flag);
		return "redirect:list";
	}

	// 글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("=====delete====");
//		model.addAttribute("request", request);
//		bServiceInterface = new BDeleteService();
//		bServiceInterface.execute(model);
//		BoardDao dao = new BoardDao(); // 디비 접속 준비완료
		IDao dao = sqlSession.getMapper(IDao.class);
		int bid = Integer.parseInt(request.getParameter("bid"));
		boolean flag = dao.delete(bid);
		System.out.println("삭제 성공여부 : "+flag);
		return "redirect:list";
	}
	// 답변
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("=====reply_view====");
		model.addAttribute("request", request);
		bServiceInterface = new BReplyViewService();
		bServiceInterface.execute(model);
		return "reply_view";
	}
	//댓글달기?
	@RequestMapping(method = RequestMethod.POST, value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("=====reply====");
		model.addAttribute("request", request);
		bServiceInterface = new BReplyService();
		bServiceInterface.execute(model);
		return "redirect:list";
	}
}