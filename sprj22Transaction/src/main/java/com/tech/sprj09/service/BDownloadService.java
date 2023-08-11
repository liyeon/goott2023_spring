package com.tech.sprj09.service;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tech.sprj09.dao.IDao;

@Service
public class BDownloadService implements BServiceInterface{
	@Autowired
	private SqlSession sqlSession;
	public BDownloadService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}

	@Override
	public void execute(Model model) {
		System.out.println(">>BDownloadService.java 신호를 받아보자");
		IDao dao = sqlSession.getMapper(IDao.class);
		// 맵 변환
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse)map.get("response");
		String path = request.getParameter("p");
		String fname = request.getParameter("f");
		String bid = request.getParameter("bid");

		// down처리
		try {
			response.setHeader("Content-Disposition", "Attachment;filename=" + URLEncoder.encode(fname, "utf-8"));
			String attachPaht = "resources\\upload\\";
			String realPath = request.getSession().getServletContext().getRealPath(attachPaht) + "\\" + fname;
			System.out.println("realpath: " + realPath);

//		      stream연결
			FileInputStream fin= new FileInputStream(realPath);
			ServletOutputStream sout= response.getOutputStream();// 다운로드하는게 아웃풋

			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fin.read(buf, 0, 1024)) != -1) { // 가져올게 없는 순간이면 -1이되는데 -1이 되지 않을 때 까지 동작
				sout.write(buf, 0, size);
			}
			fin.close();
			sout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
		
	}
}