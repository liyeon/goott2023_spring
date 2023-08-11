package com.tech.sprj09.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.vopage.SearchVo;

@Service
public class BListService implements BServiceInterface {
	@Autowired
	private SqlSession sqlSession;
	public BListService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	@Transactional
	@Override
	public void execute(Model model) {
		System.out.println(">>BListService 신호를 받아보자");
		// 데이터를 가져와보자
		IDao dao = sqlSession.getMapper(IDao.class);
		// asMap = 인덱스 번호도 같이 가져올수있다.
		Map<String, Object> map = model.asMap();
		// 키값이 request 인 value 가져오기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String strPage = request.getParameter("page");
		// 시작 페이지 값이 없다면 1로 변경해준다.
		if (strPage == null) {
			strPage = "1";
		}
		System.out.println("page : " + strPage);
		int page = Integer.parseInt(strPage);

		// 검색 vo에 페이지값 담아주기
		SearchVo searchVO = new SearchVo();
		searchVO.setPage(page);
		// 글의 총 갯수 구하기
//		int total = dao.selectBoardTotCount();

		// 검색
		// 저장할 변수 선언
		String btitle = "";
		String bcontent = "";
		String[] brdtitle = request.getParameterValues("searchType");
		System.out.println("brdtitle : " + brdtitle);
		// 출력되는지 테스트
		if (brdtitle != null) {// null 이 아닐때만 돌아주세용
			for (int i = 0; i < brdtitle.length; i++) {
				System.out.println("brdtitle : " + brdtitle[i]);
			}
		}

		// 변수에 저장하기
		if (brdtitle != null) {// null 이 아닐때만 돌아주세용
			for (String var : brdtitle) {
				if (var.equals("btitle")) {
					btitle = "btitle";
					model.addAttribute("btitle","true");
				} else if (var.equals("bcontent")) {
					bcontent = "bcontent";
					model.addAttribute("bcontent","true");
				}
			}
		}
		
		//페이징에 검색결과유지
		String bt=request.getParameter("btitle");
		String bc=request.getParameter("bcontent");
				
//		변수에 저장
		if (bt!=null) {//null이 아닐때만 돌아라
			if(bt.equals("btitle")) {
				btitle=bt;
				model.addAttribute("btitle","true");
			}
		}
		if (bc!=null) {//null이 아닐때만 돌아라
			if(bc.equals("bcontent")) {
				bcontent=bc;
				model.addAttribute("bcontent","true");
			}
		}
		// sk 값 Search Keyword 검색어 가져오기
		String searchKeyword = request.getParameter("sk");
		// 검색어 널값 처리
		if (searchKeyword == null) {
			searchKeyword = "";
		}
		System.out.println("검색어 : " + searchKeyword);
		// 검색에 따른 총갯수 변형
		int total = 0;
//		4개의 경우의 수로 총갯수를 구하기
		if (btitle.equals("btitle") && bcontent.equals("")) {
			total = dao.selectBoardTotCount1(searchKeyword);
		} else if (btitle.equals("") && bcontent.equals("bcontent")) {
			total = dao.selectBoardTotCount2(searchKeyword);
		} else if (btitle.equals("btitle") && bcontent.equals("bcontent")) {
			total = dao.selectBoardTotCount3(searchKeyword);
		} else if (btitle.equals("") && bcontent.equals("")) {
			total = dao.selectBoardTotCount4(searchKeyword);
		}
		// 총 갯수
		System.out.println("total cnt: " + total);
		searchVO.pageCalculate(total);
		/* #9 페이징 글 번호 전달 */
		int rowStart = searchVO.getRowStart();
		int rowEnd = searchVO.getRowEnd();
//		ArrayList<BoardDto> dto = dao.list(rowStart, rowEnd);
		ArrayList<BoardDto> dto = null;
		// 리스트에 임의 값 추가
		if (btitle.equals("btitle") && bcontent.equals("")) {
			dto = dao.list(rowStart, rowEnd, searchKeyword, "1");
		} else if (btitle.equals("") && bcontent.equals("bcontent")) {
			dto = dao.list(rowStart, rowEnd, searchKeyword, "2");
		} else if (btitle.equals("btitle") && bcontent.equals("bcontent")) {
			dto = dao.list(rowStart, rowEnd, searchKeyword, "3");
		} else if (btitle.equals("") && bcontent.equals("")) {
			dto = dao.list(rowStart, rowEnd, searchKeyword, "4");
		}
		/* 계산 결과 출력하기 */
		System.out.println("total row: " + total);
		System.out.println("clickpage: " + searchVO.getPage());
		System.out.println("pageStart: " + searchVO.getPageStart());
		System.out.println("pageEnd: " + searchVO.getPageEnd());
		System.out.println("pageTot: " + searchVO.getTotPage());
		System.out.println("rowStart: " + searchVO.getRowStart());
		System.out.println("rowEnd: " + searchVO.getRowEnd());
		// 디비에 접속해서 데이터 가져오기
//		BoardDao dao = new BoardDao();//호출
		// 모델에 전달하기
		model.addAttribute("list", dto);
		model.addAttribute("searchKey", searchKeyword);
		/* #12 페이지 계산을 위해 list.jsp에 값 전달 */
		model.addAttribute("totRowcnt", total);
		model.addAttribute("searchVO", searchVO);
	}
}