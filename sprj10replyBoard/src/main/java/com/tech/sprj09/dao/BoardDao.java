package com.tech.sprj09.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tech.sprj09.dto.BoardDto;

public class BoardDao {
	DataSource dataSource;

	public BoardDao() {
		System.out.println("BoardDao 생성자");
		// 디비 접속
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/springxe");
			System.out.println("디비 썩쎄ㅔㅔㅔ쓰ㅡㅡ");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}// 기본 생성자

	public ArrayList<BoardDto> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		try {
			conn = dataSource.getConnection();
			String sql = "select bid,bname,btitle,bcontent,bdate," + "bhit,bgroup,bstep,bindent from replyboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// dto에 글전체 담아주기
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				// 생성자를 통해 BoardDto에 담아주기
				BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				// 리스트에 담기
				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("리스트 오류>>");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally
		return dtos;

	}// list

	// 글작성
	public int write(String bname, String btitle, String bcontent) {
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into replyboard "
					+ "values(replyboard_seq.nextval,?,?,?,"
					+ "sysdate,0,replyboard_seq.currval,0,0)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("글작성 오류 >> ");
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally

		return flag;
	}

	public BoardDto contentView(String sbid) {
		// bid를 조건으로 db에서 해당글 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto dto = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select bid,bname,btitle,bcontent,bdate," 
			+ "bhit,bgroup,bstep,bindent from replyboard where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs = pstmt.executeQuery();
			// dto에 글전체 담아주기
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				// 생성자를 통해 BoardDto에 담아주기
				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (SQLException e) {
			System.out.println("리스트 오류>>");
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally
		return dto;
	}
}// class