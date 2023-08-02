package com.tech.sprj09.dao;

import java.util.ArrayList;

import com.tech.sprj09.dto.BoardDto;

public interface IDao {
	public ArrayList<BoardDto> list();
	public BoardDto content_view(int bid);
	public int write(String bname, String btitle, String bcontent);
	public int modify(String bname, String btitle, String bcontent,int bid);
	public void upHit(int bid);
	public boolean delete(int bid);
}