package com.tech.sprj09.service;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.dto.JobDto;

@Service
public class EmpsumService implements BServiceInterface{
	@Autowired
	private SqlSession sqlSession;
	public EmpsumService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println(">>BContentViewService.java 신호를 받아보자");
		IDao dao = sqlSession.getMapper(IDao.class);
		JSONArray arr = new JSONArray();
		ArrayList<JobDto> dto = dao.sumByJob();
		for (JobDto job : dto) {
			JSONObject obj = new JSONObject();
			String job1 = job.getJob();
			int sum = job.getSum();
			obj.put("job", job1);
			obj.put("sum", sum);
			if (obj != null) {
				arr.add(obj);
			}
		}
		model.addAttribute("arr", arr);
	}
	
}