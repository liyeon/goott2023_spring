package com.tech.sprj09.rest.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.sprj09.dto.DeptDto;
import com.tech.sprj09.dto.EmpDto;
import com.tech.sprj09.dto.MemberDto;

@RestController
//@ResponseBody
//@Controller
@RequestMapping("/test/*")
public class RestTestController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello Rest";
	}
	
	@RequestMapping("/member")
	public MemberDto member() {
		MemberDto dto = new MemberDto();
		dto.setId("hob");
		dto.setPwd("1234");
		dto.setName("홍동동");
		dto.setEmail("a@go.com");
		return dto;
	}
	@RequestMapping("/members")
	public Map<Integer, MemberDto> members() {
		Map<Integer, MemberDto> map=
				new HashMap<Integer, MemberDto>();
		for (int i = 0; i < 10; i++) {
			MemberDto dto = new MemberDto();
			dto.setId("hob");
			dto.setPwd("1234");
			dto.setName("홍동동");
			dto.setEmail("a@go.com");
			map.put(i, dto);
		}
		return map;
	}
	
	// 디비에서 데이터를 조회 리스트에 담아 결과를 뷰에 출력하기
		@RequestMapping("/deptlist")
		public List<DeptDto> deptlist() throws Exception {
			System.out.println("deptlist");
//			Map<Integer, MemberDto> map=
//					new HashMap<Integer, MemberDto>();
			
			// 데이터를 가져와보자
			String sql = "select * from dept";
			List<DeptDto> list = new ArrayList<DeptDto>();
			
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pw = "123456";
			Connection conn = DriverManager.getConnection(url,user,pw);
			//실행
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				DeptDto d = new DeptDto();
				d.setDeptno(rs.getInt("deptno"));
				d.setDname(rs.getString("dname"));
				d.setLoc(rs.getString("loc"));
				list.add(d);
			}
			return list;
		}
		
		//미션
		@RequestMapping("/emplist")
		public List<EmpDto> emplist() throws Exception {
			System.out.println("emplist");
//			Map<Integer, MemberDto> map=
//					new HashMap<Integer, MemberDto>();
			
			// 데이터를 가져와보자
			String sql = "select * from emp";
			List<EmpDto> list = new ArrayList<EmpDto>();
			
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="hr";
			String pw = "123456";
			Connection conn = DriverManager.getConnection(url,user,pw);
			//실행
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDto dto = new EmpDto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getTimestamp("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				list.add(dto);
			}
			return list;
		}
}//class