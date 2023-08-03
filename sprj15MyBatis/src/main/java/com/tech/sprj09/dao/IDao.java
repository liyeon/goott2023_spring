package com.tech.sprj09.dao;

import java.util.ArrayList;

import com.tech.sprj09.dto.BoardDto;

public interface IDao {
//	public ArrayList<BoardDto> list();
//	페이징 처리를 위한 매개변수 값 추가
	public ArrayList<BoardDto> list(int rowStart, int rowEnd);
	public BoardDto contentView(int bid);
	public int write(String bname, String btitle, String bcontent);
	public int modify(int bid,String bname, String btitle, String bcontent);
	public void upHit(int bid);
	public boolean delete(int bid);
	public BoardDto replyView(int bid);
	public void replyShape(String bgroup, String bstep);
	public boolean reply(int bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent);
	
// 페이징 처리를 위한 메소드
	public int selectBoardTotCount();
}