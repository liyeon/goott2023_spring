package com.tech.sprj09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tech.sprj09.dao.ReviewDao;
import com.tech.sprj09.dto.ReviewDto;

import oracle.jdbc.driver.ClassRef.Locale;

@Controller
public class HomeController {
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	@RequestMapping(value = "/star", method = RequestMethod.GET)
	public String star() {
		return "star";
	}

	@RequestMapping(value = "/viewwrite", method = RequestMethod.GET)
	public String viewwrite(HttpServletRequest request, Locale locale, Model model) {
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);

		String review = request.getParameter("review");
		String point = request.getParameter("point");
		System.out.println("review : " + review);
		System.out.println("point : " + point);

//	      point세션만 지우기(다른 세션은 필요할 수 있음으로)
		HttpSession session = request.getSession();
		session.removeAttribute("point");
//	      
		dao.reviewwrite(review, point);

		return "home";
	}
	
	@RequestMapping(value = "/callgetdbstar", method = RequestMethod.GET)
	public String callgetdbstar(HttpServletRequest request, Model model) {
		// db 에서 글번호의 관련글 데이터 조회
		String reno = request.getParameter("reno");
		ReviewDao dao = sqlSession.getMapper(ReviewDao.class);
		ReviewDto dto = dao.getReview(reno);
		// 모델로 전달하기
		model.addAttribute("dto",dto);
//		System.out.println(dto.getRepoint());
		return "callstar";
	}
}
