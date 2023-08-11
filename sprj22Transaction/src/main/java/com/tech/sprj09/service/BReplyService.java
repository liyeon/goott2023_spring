package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.BoardDao;
import com.tech.sprj09.dao.IDao;

@Service
public class BReplyService implements BServiceInterface {
	@Autowired
	private SqlSession sqlSession;
	public BReplyService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Transactional
	@Override
	public void execute(Model model) {
		System.out.println(">>BReplyService 신호를 받아보자");
		IDao dao = sqlSession.getMapper(IDao.class);
		// 맵 변환
		Map<String, Object> map = model.asMap();
		// 맵에서 request 추출
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String sbid = request.getParameter("bid");
		int bid = Integer.parseInt(sbid);
		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		// 디비에 접속해서 데이터 가져오기
//		BoardDao dao = new BoardDao();// 호출
		dao.replyShape(bgroup, bstep);
		boolean flag = dao.reply(bid,bname,btitle,bcontent,bgroup,bstep,bindent);
		System.out.println("답변 등록 성공여부 : " + flag);
	}

}