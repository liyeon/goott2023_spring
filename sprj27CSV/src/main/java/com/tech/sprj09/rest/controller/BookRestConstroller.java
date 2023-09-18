package com.tech.sprj09.rest.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.sprj09.dto.SimDto;

@RestController
@RequestMapping("/book/*")
public class BookRestConstroller {
	
	@RequestMapping("/simbook")
	public List<SimDto> simbook(HttpServletRequest request) throws Exception {
		System.out.println("simbook @RestController ");
		System.out.println("simbook()");
		String bt=request.getParameter("bt");
		System.out.println("simbook() : "+bt);
		
 
		 System.out.println("pythonbuilder ");
	        String arg1;
	        ProcessBuilder builder;
	        BufferedReader br;
	        List<SimDto> simlist=new ArrayList<SimDto>();

	        arg1 = "/Users/klyeon/git/goott2023_spring/sprj27CSV/src/main/webapp/resources/pycode/dbcon.py";

//	        builder = new ProcessBuilder("python",arg1,"업무의 잔머리 "); //python3 error
	        builder = new ProcessBuilder("python3",arg1,bt); //python3 error
	        

	        builder.redirectErrorStream(true);
	        Process process = builder.start();

	        // 자식 프로세스가 종료될 때까지 기다림
	        int exitval = process.waitFor();

	        //// 서브 프로세스가 출력하는 내용을 받기 위해
	        br = new BufferedReader(new InputStreamReader(process.getInputStream(),"UTF-8"));

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
//	        model.addAttribute("simlist",simlist);	        
	        if(exitval !=0){//비정상종료      
	            System.out.println("비정상종료");
	        }
//	        request.getSession().setAttribute("book", "bookkkkkk");
	        return simlist;
	}	

}
