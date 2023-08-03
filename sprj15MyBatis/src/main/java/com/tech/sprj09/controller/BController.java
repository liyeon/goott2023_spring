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
import com.tech.sprj09.service.BContentViewService;
import com.tech.sprj09.service.BDeleteService;
import com.tech.sprj09.service.BModifyService;
import com.tech.sprj09.service.BReplyService;
import com.tech.sprj09.service.BReplyViewService;
import com.tech.sprj09.service.BServiceInterface;
import com.tech.sprj09.service.BWriteService;
import com.tech.sprj09.vopage.SearchVo;

@Controller
public class BController {
	
	BServiceInterface bServiceInterface;
	
//	servlet-context에 등록한 sqlsession Bean을 가져온다.
	@Autowired
	private SqlSession sqlSession;
	/* #2 페이징처리 request로 값 받기 #6 SearchVo 받기*/
	@RequestMapping("/list")
	public String list(HttpServletRequest request,SearchVo searchVO,Model model) {
		System.out.println("리스트");
		// 데이터를 가져와보자
		IDao dao = sqlSession.getMapper(IDao.class);
//		model.addAttribute("request", request);
//		bServiceInterface = new BListService();
//		bServiceInterface.execute(model,dao);
		
//		dao = 인터페이스
//		ArrayList<BoardDto> dtos = dao.list();
//		model.addAttribute("list",dtos);
		

		/* #3 페이징 처리 */
		String strPage = request.getParameter("page");
		/* #4 처음 페이지 null 처리 */
		if (strPage==null)
			strPage="1";
		System.out.println("page : "+strPage);
		int page = Integer.parseInt(strPage);				
		
		/* #7 현재 페이지를 받아온다. */
		searchVO.setPage(page);
		/* #8 글의 총 갯수 구하기 */
		int total = dao.selectBoardTotCount();
		System.out.println("total cnt: "+total);
		searchVO.pageCalculate(total);
		/* 계산 결과 출력하기 */
		System.out.println("total row: "+total);
		System.out.println("clickpage: "+searchVO.getPage());
		System.out.println("pageStart: "+searchVO.getPageStart());
		System.out.println("pageEnd: "+searchVO.getPageEnd());
		System.out.println("pageTot: "+searchVO.getTotPage());
		System.out.println("rowStart: "+searchVO.getRowStart());
		System.out.println("rowEnd: "+searchVO.getRowEnd());
		
		/* #9 페이징 글 번호 전달 */
		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();

		ArrayList<BoardDto> dtos = dao.list(rowStart, rowEnd);
		model.addAttribute("list",dtos);
		/* #12 페이지 계산을 위해 list.jsp에 값 전달 */
		model.addAttribute("totRowcnt",total);
		model.addAttribute("searchVO",searchVO);
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
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("request", request);
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
		bServiceInterface=new BWriteService();
		bServiceInterface.execute(model,dao);
		
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