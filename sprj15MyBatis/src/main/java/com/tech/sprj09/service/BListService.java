package com.tech.sprj09.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.vopage.SearchVo;
@Service
public class BListService implements BServiceInterface {

	@Override
	public void execute(Model model, IDao dao) {
		System.out.println(">>BListService 신호를 받아보자");

		// asMap = 인덱스 번호도 같이 가져올수있다.
		Map<String, Object> map = model.asMap();
		// 키값이 request 인 value 가져오기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String strPage = request.getParameter("page");
		// 시작 페이지 값이 없다면 1로 변경해준다.
		if (strPage == null) {
			strPage = "1";
		}
		System.out.println("page : "+strPage);
		int page = Integer.parseInt(strPage);
		
		// 검색 vo에 페이지값 담아주기
		SearchVo searchVO = new SearchVo();
		searchVO.setPage(page);
		//글의 총 갯수 구하기
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

		// 디비에 접속해서 데이터 가져오기
//		BoardDao dao = new BoardDao();//호출
		ArrayList<BoardDto> dto = dao.list(rowStart, rowEnd);
		// 모델에 전달하기
		model.addAttribute("list", dto);
		/* #12 페이지 계산을 위해 list.jsp에 값 전달 */
		model.addAttribute("totRowcnt",total);
		model.addAttribute("searchVO",searchVO);
	}
}