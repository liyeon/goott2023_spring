package com.tech.sprj09.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.sprj09.dao.IDao;

@Service
public class BWriteService implements BServiceInterface{
	@Autowired
	private SqlSession sqlSession;
	public BWriteService(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	@Transactional
	@Override
	public void execute(Model model) {
		System.out.println(">>BWriteService 신호를 받아보자");
		// 데이터를 가져와보자
		IDao dao = sqlSession.getMapper(IDao.class);
//		모델에서 request를 풀어서
//		맵으로 전환한다.
		Map<String,Object> map= model.asMap();
//		맵에서 request 뽑아내기
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		// 경로 만들기
		/*
		String attachPath="resources\\upload";
		String uploadPath=request.getSession().getServletContext().getRealPath("/");
		System.out.println("업로드 경로 >>> "+uploadPath);
		String path = uploadPath+attachPath;
		System.out.println("합쳐진 경로 >>>"+path);
		*/
		String path = "C:\\javabigsetspring2023\\spring_work\\sprj22Transaction\\src\\main\\webapp\\resources\\upload";
		////C:\javabigsetspring2023\spring_work\sprj17upload\src\main\webapp\resources\\\\upload//
		// multipart에서 변형하기
		// 20mb 를 의미함 1024*1024*20
		MultipartRequest req=null;
		try {
			req = new MultipartRequest(request, path, 1024*1024*20,"utf-8",new DefaultFileRenamePolicy());
		} catch (IOException e) {
			System.out.println(">> 파일 업로드 오류 >> ");
			e.printStackTrace();
		}
		String bname = req.getParameter("bname");
		String btitle = req.getParameter("btitle");
		String bcontent = req.getParameter("bcontent");
		String fname = req.getFilesystemName("file");
//		System.out.println("내용이 잘 들어오는지 : "+bcontent);
//		System.out.println("파일이 잘 들어오는지 : "+fname);
		if(fname==null) {
			fname="";
		}
		int flag = dao.write(bname,btitle,bcontent,fname);
		System.out.println("글작성 성공여부 : "+flag);
	}
}
