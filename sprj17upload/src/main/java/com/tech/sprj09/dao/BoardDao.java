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
//		System.out.println("BoardDao 생성자");
//		// 디비 접속
//		try {
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/springxe");
//			System.out.println("디비 썩쎄ㅔㅔㅔ쓰ㅡㅡ");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
	}// 기본 생성자

	public ArrayList<BoardDto> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>();
		try {
			conn = dataSource.getConnection();
//			String sql = "select bid,bname,btitle,bcontent,bdate,"
//					+ "bhit,bgroup,bstep,bindent from replyboard order by bid desc";
			String sql = "select bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent from replyboard order by bgroup desc,bstep asc";
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
//				BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
//				// 리스트에 담기
//				dtos.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("리스트 오류>>");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
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
			String sql = "insert into replyboard " + "values(replyboard_seq.nextval,?,?,?,"
					+ "sysdate,0,replyboard_seq.currval,0,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("글작성 오류 >> ");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally

		return flag;
	}

	public BoardDto contentView(String sbid) {
		// 조회수 증가
		upHit(sbid);
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
//				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (SQLException e) {
			System.out.println("리스트 오류>>");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return dto;
	}

	// 조회수 증가
	public void upHit(String sbid) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "update replyboard " + "set bhit=bhit+1 " + "where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("조회수 업데이트 오류>>");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
	}

	public int modify(String sbid, String bname, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "update replyboard set bname=?, btitle=?, bcontent=? where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			int bid = Integer.parseInt(sbid);
			pstmt.setInt(4, bid);
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("글수정 오류 >> ");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return flag;
	}

	public boolean delete(int bid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from replyboard where bid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bid);

			int s = pstmt.executeUpdate();
			if (s == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("글수정 오류 >> ");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return flag;
	}

	public BoardDto replyView(int sbid) {
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
			pstmt.setInt(1, sbid);
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
//				dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (SQLException e) {
			System.out.println("리스트 오류>>");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return dto;
	}

	public boolean reply(int bid, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) {
		// 댓글을 달려는 원글의 스텝번호보다 큰 스텝이 있다면 1을 더해준다.
		replyShape(bgroup, bstep);
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into replyboard(bid,bname,btitle,bcontent,bgroup,bstep,bindent)"
					+ "values(replyboard_seq.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.parseInt(bgroup)); // 원글의 번호
			pstmt.setInt(5, Integer.parseInt(bstep) + 1); // 순서 원래 글의 step 의 +1
			pstmt.setInt(6, Integer.parseInt(bindent) + 1);// 들여쓰기 원래 글의 indent 의 +1
			int s = pstmt.executeUpdate();
			if (s == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("글작성 오류 >> ");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally

		return flag;
	}

	public void replyShape(String bgroup, String bstep) {
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "update replyboard set bstep=bstep+1 where bgroup=? and bstep>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bgroup)); // 원글의 번호
			pstmt.setInt(2, Integer.parseInt(bstep)); // 순서 원래 글의 step 의 +1
			int s = pstmt.executeUpdate();
			if (s == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("글작성 오류 >> ");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally

	}
}// class