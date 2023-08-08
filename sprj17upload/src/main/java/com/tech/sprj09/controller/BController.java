package com.tech.sprj09.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.service.BContentViewService;
import com.tech.sprj09.service.BDeleteService;
import com.tech.sprj09.service.BListService;
import com.tech.sprj09.service.BModifyService;
import com.tech.sprj09.service.BReplyService;
import com.tech.sprj09.service.BReplyViewService;
import com.tech.sprj09.service.BServiceInterface;
import com.tech.sprj09.service.BWriteService;

@Controller
public class BController {
	
	BServiceInterface bServiceInterface;
	
//	servlet-context에 등록한 sqlsession Bean을 가져온다.
	@Autowired
	private SqlSession sqlSession;
	/* #2 페이징처리 request로 값 받기 #6 SearchVo 받기*/
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BListService();
		bServiceInterface.execute(model,dao);
		return "/list";
	}

	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("=====write_view====");
		return "/write_view";
	}
	//글작성 작업
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		System.out.println("=====write====");

		// 글쓰기 진행
		// toss
//		String bname = request.getParameter("bname");
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
		model.addAttribute("request", request);
		IDao dao = sqlSession.getMapper(IDao.class);
		bServiceInterface = new BWriteService();
		bServiceInterface.execute(model,dao);
//		dao.write(bname,btitle,bcontent);
		return "redirect:list";
	}

	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		System.out.println("=====content_view_view====");

//		글조회
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface=new BContentViewService();
		bServiceInterface.execute(model,dao);
		System.out.println("contentview 리퀘스트 값 "+request);
//		int bid = Integer.parseInt(request.getParameter("bid"));
//		dao.upHit(bid);
//		BoardDto dto = dao.content_view(bid);
//		model.addAttribute("dto",dto);
		return "/content_view";
	}

	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request, Model model) {
		System.out.println("=====content_update====");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BContentViewService();
		bServiceInterface.execute(model,dao);
//		int bid = Integer.parseInt(request.getParameter("bid"));
//		BoardDto dto = dao.content_view(bid);
//		model.addAttribute("dto",dto);
		return "/content_update";
	}

	// 글 수정
	// method가 post방식일때 처리
	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("=====modify====");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BModifyService();
		bServiceInterface.execute(model,dao);
//		int bid = Integer.parseInt(request.getParameter("bid"));
//		String bname = request.getParameter("bname");
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//		int flag = dao.modify(bname,btitle,bcontent,bid);
//		System.out.println("글수정 성공여부 : "+flag);
		return "redirect:list";
	}

	// 글 삭제
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("=====delete====");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BDeleteService();
		bServiceInterface.execute(model,dao);
//		BoardDao dao = new BoardDao(); // 디비 접속 준비완료
//		int bid = Integer.parseInt(request.getParameter("bid"));
//		boolean flag = dao.delete(bid);

		return "redirect:list";
	}
	// 답변
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("=====reply_view====");
		IDao dao=sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BReplyViewService();
		bServiceInterface.execute(model,dao);
//		230802 오후수업 추가
//		String sbid = request.getParameter("bid");
//		int bid = Integer.parseInt(sbid);
//		
//		BoardDto dto = dao.replyView(bid);
//		model.addAttribute("dto", dto);
		return "reply_view";
	}
	//댓글달기?
	@RequestMapping(method = RequestMethod.POST, value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("=====reply====");
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
		bServiceInterface = new BReplyService();
		bServiceInterface.execute(model,dao);
//		230802 오후수업 추가
//		String bid = request.getParameter("bid");
//		String bgroup = request.getParameter("bgroup");
//		String bstep = request.getParameter("bstep");
//		String bindent = request.getParameter("bindent");
//		String bname = request.getParameter("bname");
//		String btitle = request.getParameter("btitle");
//		String bcontent = request.getParameter("bcontent");
//		dao.replyShape(bgroup,bstep);
//		boolean flag = dao.reply(bid,bname,btitle,bcontent,bgroup,bstep,bindent);
//		System.out.println("답변 등록 성공여부 : " + flag);
		return "redirect:list";
	}
}