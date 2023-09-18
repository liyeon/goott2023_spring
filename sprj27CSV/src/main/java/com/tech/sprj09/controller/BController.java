package com.tech.sprj09.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.System.Logger;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tech.sprj09.dao.IDao;
import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.dto.Emp;
import com.tech.sprj09.dto.JobDto;
import com.tech.sprj09.dto.SimDto;
import com.tech.sprj09.service.BContentViewService;
import com.tech.sprj09.service.BDeleteService;
import com.tech.sprj09.service.BListService;
import com.tech.sprj09.service.BModifyService;
import com.tech.sprj09.service.BReplyService;
import com.tech.sprj09.service.BReplyViewService;
import com.tech.sprj09.service.BServiceInter;
import com.tech.sprj09.service.BWriteService;
import com.tech.sprj09.vopage.SearchVO;

@Controller
public class BController {

	BServiceInter bServiceInter;
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/empsum")
	public String empsum(Model model) {
		System.out.println("====empsum()====");
		IDao dao=sqlSession.getMapper(IDao.class);
		JSONArray arr=new JSONArray();
		ArrayList<JobDto> jobnsum=dao.sumByjob();
		for (JobDto job : jobnsum) {
			//System.out.println(job.getJob()+":"+job.getSalsum());
			JSONObject obj=new JSONObject();
			obj.put("job",job.getJob());
			obj.put("selsum",job.getSalsum());
			if(obj!=null)
				arr.add(obj);
		}
		
		model.addAttribute("arr",arr);
		
		return "chart/jobgraph";
	}
	
	
	@RequestMapping("/list")
	public String list(HttpServletRequest request,
			SearchVO searchVO, Model model) {
		System.out.println("====list()====");
//		데이터 가져오기 작업
//		bServiceInter=new BListService();
//		bServiceInter.execute(model);
		
		IDao dao=sqlSession.getMapper(IDao.class);
//		searching
		String btitle="";
		String bcontent="";
		
		String[] brdtitle=request.getParameterValues("searchType");
		System.out.println("brdtitle:"+brdtitle);
		if (brdtitle!=null) {//null이 아닐때만 돌아라
			for (int i = 0; i < brdtitle.length; i++) {
				System.out.println("brdtitle:"+brdtitle[i]);				
			}
		}
//		변수에 저장
		if (brdtitle!=null) {//null이 아닐때만 돌아라
			for (String var : brdtitle) {
				if(var.equals("btitle")) {
					btitle="btitle";
					model.addAttribute("btitle","true");
				}else if(var.equals("bcontent")) {
					bcontent="bcontent";
					model.addAttribute("bcontent","true");
				}
			}
		}
		//검색결과유지
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
		
		
		
//		sk값가져오기		
		String searchKeyword=request.getParameter("sk");
		if (searchKeyword==null) {
			searchKeyword="";
		}
		model.addAttribute("resk",searchKeyword);
		System.out.println("skkkkk:"+searchKeyword);
	
//		paging
		String strPage=request.getParameter("page");
//		처음 null처리
		if(strPage==null)
			strPage="1";
		System.out.println("pagggg:"+strPage);
		int page=Integer.parseInt(strPage);
		searchVO.setPage(page);
		
//		글의 총갯수 구하기
//		int total=dao.selectBoardTotCount();
		
//		검색에 따른 총갯수 변형
		int total=0;
//		4개의 경우의 수로 총갯수 구하기
		if(btitle.equals("btitle")&& bcontent.equals("")) {
			total=dao.selectBoardTotCount1(searchKeyword);
		}else if(btitle.equals("")&& bcontent.equals("bcontent")) {
			total=dao.selectBoardTotCount2(searchKeyword);
		}else if(btitle.equals("btitle")&& bcontent.equals("bcontent")) {
			total=dao.selectBoardTotCount3(searchKeyword);
		}else if(btitle.equals("")&& bcontent.equals("")) {
			total=dao.selectBoardTotCount4(searchKeyword);
		}
		

		System.out.println("totcnt : "+total);
		searchVO.pageCalculate(total);
		//계산결과들 출력
		System.out.println("totrow:"+total);
		System.out.println("clickpage:"+searchVO.getPage());
		System.out.println("pageStart:"+searchVO.getPageStart());
		System.out.println("pageEnd:"+searchVO.getPageEnd());
		System.out.println("pageTot:"+searchVO.getTotPage());
		System.out.println("rowStart:"+searchVO.getRowStart());
		System.out.println("rowEnd:"+searchVO.getRowEnd());
		
		//패이징 글 번호전달
		int rowStart=searchVO.getRowStart();
		int rowEnd=searchVO.getRowEnd();
		
//		ArrayList<BoardDto> dtos=dao.list(rowStart,rowEnd);
//		ArrayList<BoardDto> list=null;
		if(btitle.equals("btitle")&& bcontent.equals("")) {
//			list=dao.list(rowStart,rowEnd,searchKeyword,"1");
			model.addAttribute("list",dao.list(rowStart,rowEnd,searchKeyword,"1"));
		}else if(btitle.equals("")&& bcontent.equals("bcontent")) {
//			list=dao.list(rowStart,rowEnd,searchKeyword,"2");
			model.addAttribute("list",dao.list(rowStart,rowEnd,searchKeyword,"2"));
		}else if(btitle.equals("btitle")&& bcontent.equals("bcontent")) {
//			list=dao.list(rowStart,rowEnd,searchKeyword,"3");
			model.addAttribute("list",dao.list(rowStart,rowEnd,searchKeyword,"3"));
		}else if(btitle.equals("")&& bcontent.equals("")) {
//			list=dao.list(rowStart,rowEnd,searchKeyword,"4");
			model.addAttribute("list",dao.list(rowStart,rowEnd,searchKeyword,"4"));
		}
		
		
//		ArrayList<BoardDto> dtos=dao.list();
//		model.addAttribute("list",list);
		model.addAttribute("totRowcnt",total);
		model.addAttribute("searchVO",searchVO);
		
		return "list";
	}
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("====write_view()====");
		return "write_view";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) throws Exception {
		System.out.println("====write()====");
//		글쓰기진행
//		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BWriteService();
//		bServiceInter.execute(model);
//		multipart에서 변형
//		String bname=request.getParameter("bname");
//		String btitle=request.getParameter("btitle");
//		String bcontent=request.getParameter("bcontent");
		
//		경로 만들기
//		String attachPath="resources\\upload\\";
//		String uploadPath=request.getSession().getServletContext().getRealPath("/");
//		System.out.println("uploadPath:"+uploadPath);
//		String path=uploadPath+attachPath;
//		System.out.println("pathhhh: "+path);
		String path="/Users/klyeon/git/goott2023_spring/sprj27CSV/src/main/webapp/resources/upload";
		MultipartRequest req=
				new MultipartRequest(request, path, 1024*1024*20, "utf-8",
						new DefaultFileRenamePolicy());
		String bname=req.getParameter("bname");
		String btitle=req.getParameter("btitle");
		String bcontent=req.getParameter("bcontent");
		String fname=req.getFilesystemName("file");
		
//		System.out.println("bcontent : "+bcontent);
//		System.out.println("fname : "+fname);
		
		if (fname==null) {
			fname="";
		}
		
		
		IDao dao=sqlSession.getMapper(IDao.class);
		dao.write(bname,btitle,bcontent,fname);
		
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("====content_view()====");
//		글조회
//		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BContentViewService();
//		bServiceInter.execute(model);
		String bid=request.getParameter("bid");
		IDao dao=sqlSession.getMapper(IDao.class);
		
		dao.upHit(bid);
		
		BoardDto dto=dao.contentView(bid);
		model.addAttribute("content_view",dto);
		
		return "content_view";
	}
	@RequestMapping("/download")
	public String download(HttpServletRequest request,HttpServletResponse response,
			Model model) throws Exception {
		System.out.println("====download()====");
		String path=request.getParameter("p");
		String fname=request.getParameter("f");
		String bid=request.getParameter("bid");
		
		//down처리
		response.setHeader("Content-Disposition",
				"Attachment;filename="+URLEncoder.encode(fname,"utf-8"));
		String attachPath="resources\\upload\\";
		String realPath=request.getSession().getServletContext().getRealPath(attachPath)+"\\"+fname;
		System.out.println("realpath: "+realPath);
		
//		stream연결
		FileInputStream fin=new FileInputStream(realPath);
		ServletOutputStream sout=response.getOutputStream();
		
		
		byte[] buf=new byte[1024];
		int size=0;
		while ((size=fin.read(buf,0,1024))!=-1) {
			sout.write(buf,0,size);
		}
		fin.close();
		sout.close();
		
		
		return "content_view?bid="+bid;
	}
	
	
	
	
	
	@RequestMapping("/content_update")
	public String content_update(HttpServletRequest request,Model model) {
		System.out.println("====content_update()====");
//		글수정form
//		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BContentViewService();
//		bServiceInter.execute(model);
		
		String bid=request.getParameter("bid");
		IDao dao=sqlSession.getMapper(IDao.class);
		BoardDto dto=dao.contentView(bid);
		model.addAttribute("content_view",dto);
		
		return "content_update";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/modify")
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("====modify()====");
//		글수정update
//		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BModifyService();
//		bServiceInter.execute(model);
		IDao dao=sqlSession.getMapper(IDao.class);
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		dao.modify(bid,bname,btitle,bcontent);
		
		return "redirect:list";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,
			Model model) {
		System.out.println("======delete()======");
//		db에 데이터 삭제
		//toss
//		model.addAttribute("request",request);
//		bServiceInter=new BDeleteService();
//		bServiceInter.execute(model);
		String bid=request.getParameter("bid");
		IDao dao=sqlSession.getMapper(IDao.class);
		dao.delete(bid);
		
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,
			Model model) {
		System.out.println("======reply_view()======");
//		db에 데이터 조회
		//toss
//		model.addAttribute("request",request);
//		bServiceInter=new BReplyViewService();
//		bServiceInter.execute(model);
		String bid=request.getParameter("bid");
		IDao dao=sqlSession.getMapper(IDao.class);
		BoardDto dto=dao.replyView(bid);
		model.addAttribute("reply_view",dto);
		
		return "reply_view";
	}
	@RequestMapping(method = RequestMethod.POST,value = "/reply")
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("====reply()====");
//		댓글달기
//		toss
//		model.addAttribute("request",request);
//		bServiceInter=new BReplyService();
//		bServiceInter.execute(model);
		String bid=request.getParameter("bid");
		String bgroup=request.getParameter("bgroup");
		String bstep=request.getParameter("bstep");
		String bindent=request.getParameter("bindent");
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		IDao dao=sqlSession.getMapper(IDao.class);
		dao.replyShape(bgroup,bstep);
		dao.reply(bid,bname,btitle,bcontent,bgroup,bstep,bindent);
			
		return "redirect:list";
	}
	
	@RequestMapping("/savecsv")
	public String savecsv(HttpServletRequest request,Model model) throws Exception {
		
		IDao dao=sqlSession.getMapper(IDao.class);
		ArrayList<Emp> emps=dao.savecsv();
		
		
		FileReader fr=null;
		FileWriter fw=null;
		
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		
		String path="/Users/klyeon/git/goott2023_spring/sprj27CSV/src/main/webapp/resources/upload";
		
		
		try {
			//출력도구
			fw=new FileWriter(path+"empdata.csv",false);
			bw=new BufferedWriter(fw);
			
			
			for (Emp emp : emps) {
				String empval=emp.getEmpno()+","+emp.getEname()+"\n";
				System.out.println(empval);
				bw.write(empval);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			//자원회수
			if(br!=null) {	try {	br.close();	} catch (IOException e) {		}}
			if(fr!=null) {	try {	fr.close();	} catch (IOException e) {		}}
			if(bw!=null) {	try {	bw.close();	} catch (IOException e) {		}}
			if(fw!=null) {	try {	fw.close();	} catch (IOException e) {		}}
			
		}
		
		
		
		return "list";
	}
	@RequestMapping("/execpy")
	public String execpy(HttpServletRequest request,Model model) throws Exception {
//		참고 : https://bsssss.tistory.com/830
		  System.out.println("pythonbuilder ");
	        String arg1;
	        ProcessBuilder builder;
	        BufferedReader br;

	        arg1 = "/Users/klyeon/git/goott2023_spring/sprj27CSV/src/main/webapp/resources/pycode/trafficcossim.py";

	        builder = new ProcessBuilder("python3",arg1,"업무의 잔머리 "); //python3 error

	        builder.redirectErrorStream(true);
	        Process process = builder.start();

	        // 자식 프로세스가 종료될 때까지 기다림
	        int exitval = process.waitFor();

	        //// 서브 프로세스가 출력하는 내용을 받기 위해
	        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));

	        ArrayList<SimDto> simlist=new ArrayList<SimDto>();
	        String line;
	        while ((line = br.readLine()) != null) {
	            System.out.println(">>>  " + line); // 표준출력에 쓴다
	            SimDto simDto=new SimDto();
//	            System.out.println(line.indexOf(" ", 1));
//	            int cnt=line.indexOf(" ", 1);
//	            line=line.substring(cnt);
	            simDto.setSimtitle(line);
	            simlist.add(simDto);
	        }
	        model.addAttribute("simlist",simlist);
	        
	        if(exitval !=0){
	            //비정상종료
	            System.out.println("비정상종료");
	        }
	        
		return "list";
		
	}
	@RequestMapping("/booklist")
	public String booklist(HttpServletRequest request,Model model) throws Exception {
//		참고 : https://bsssss.tistory.com/830
		  System.out.println("booklist @Controller ");
		  return "booklist";
	}
}
