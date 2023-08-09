package com.tech.sprj09.dao;

import java.util.ArrayList;

import com.tech.sprj09.dto.BoardDto;
import com.tech.sprj09.dto.JobDto;
import com.tech.sprj09.dto.StudentDto;

public interface IDao {
//	public ArrayList<BoardDto> list();
//	페이징 처리를 위한 매개변수 값 추가
	public ArrayList<BoardDto> list(int rowStart, int rowEnd);
	
	// emp 테이블의 직업별 급여 메소드 생성
	public ArrayList<JobDto> sumByJob();
	//학년별 키의 합계를 json 으로 전달하고 받기 
	public ArrayList<StudentDto> sumByStudent();
	public BoardDto contentView(int bid);
	public int write(String bname, String btitle, String bcontent,String fname);
	public int modify(int bid,String bname, String btitle, String bcontent);
	public void upHit(int bid);
	public boolean delete(int bid);
	public BoardDto replyView(int bid);
	public void replyShape(String bgroup, String bstep);
	public boolean reply(int bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent);
	
// 페이징 처리를 위한 메소드
//	public int selectBoardTotCount();
//	검색처리를 위해 메소드에 파라미터 값 추가
	public int selectBoardTotCount1(String searchKeyword);//타이틀 값만
	public int selectBoardTotCount2(String searchKeyword);//콘텐츠 값만
	public int selectBoardTotCount3(String searchKeyword);//둘 다 존재
	public int selectBoardTotCount4(String searchKeyword);// 둘 다 없음
	public ArrayList<BoardDto> list(int rowStart, int rowEnd, String searchKeyword, String setNum);
	
}