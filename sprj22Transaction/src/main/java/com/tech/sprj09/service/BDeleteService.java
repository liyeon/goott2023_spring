package com.tech.sprj09.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

@Service
public class BDeleteService implements BServiceInterface{
	@Autowired
	private SqlSession sqlSession;
	public BDeleteService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	@Transactional
	@Override
	public void execute(Model model) {
		System.out.println(">>BDeleteService 신호를 받아보자");
		// 데이터를 가져와보자
				IDao dao = sqlSession.getMapper(IDao.class);
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String sbid = request.getParameter("bid");
		int bid = Integer.parseInt(sbid);
//		BoardDao dao = new BoardDao(); // 디비 접속 준비완료
		boolean flag = dao.delete(bid);
		System.out.println("글삭제 성공여부 : "+flag);
		System.out.println("삭제된 글번호 : "+sbid);
	}
}
