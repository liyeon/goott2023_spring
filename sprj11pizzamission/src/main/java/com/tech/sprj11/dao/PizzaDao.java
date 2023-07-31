package com.tech.sprj11.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tech.sprj11.dto.PizzaDto;

public class PizzaDao {
	DataSource dataSource;

	public PizzaDao() {
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

	public ArrayList<PizzaDto> list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<PizzaDto> dtos = new ArrayList<PizzaDto>();
		try {
			conn = dataSource.getConnection();
			String sql = "select *from pz_board order by pzgroup desc,pzstep asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// dto에 글전체 담아주기
			while (rs.next()) {
				int pzid = rs.getInt("pzid");
				String pzname = rs.getString("pzname");
				String pzsubj = rs.getString("pzsubj");
				String pzcontent = rs.getString("pzcontent");
				Date pzdate = rs.getDate("pzdate");
				int pzhit = rs.getInt("pzhit");
				int pzgroup = rs.getInt("pzgroup");
				int pzstep = rs.getInt("pzstep");
				int pzintent = rs.getInt("pzintent");
				PizzaDto dto = new PizzaDto(pzid, pzname, pzsubj, pzcontent, pzdate, pzhit, pzgroup, pzstep, pzintent);
				// 리스트에 담기
				dtos.add(dto);
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
	public int write(String pzname, String pzsubj, String pzcontent) {
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into pz_board values(pz_board_seq.nextval,?,?,?,sysdate,0,pz_board_seq.currval,0,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pzname);
			pstmt.setString(2, pzsubj);
			pstmt.setString(3, pzcontent);
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

	public PizzaDto contentView(String spzid) {
		// 조회수 증가
		upHit(spzid);
		// bid를 조건으로 db에서 해당글 조회
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PizzaDto dto = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select *from pz_board where pzid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(spzid));
			rs = pstmt.executeQuery();
			// dto에 글전체 담아주기
			while (rs.next()) {
				int pzid = rs.getInt("pzid");
				String pzname = rs.getString("pzname");
				String pzsubj = rs.getString("pzsubj");
				String pzcontent = rs.getString("pzcontent");
				Date pzdate = rs.getDate("pzdate");
				int pzhit = rs.getInt("pzhit");
				int pzgroup = rs.getInt("pzgroup");
				int pzstep = rs.getInt("pzstep");
				int pzintent = rs.getInt("pzintent");
				dto = new PizzaDto(pzid, pzname, pzsubj, pzcontent, pzdate, pzhit, pzgroup, pzstep, pzintent);
				// 리스트에 담기
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
	public void upHit(String spzid) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "update pz_board set pzhit=pzhit+1 " + "where pzid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(spzid));
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

	public int modify(String spzid, String pzname, String pzsubj, String pzcontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = dataSource.getConnection();
			String sql = "update pz_board set pzname=?,pzsubj=?,pzcontent=? where pzid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pzname);
			pstmt.setString(2, pzsubj);
			pstmt.setString(3, pzcontent);
			int pzid = Integer.parseInt(spzid);
			pstmt.setInt(4, pzid);
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

	public boolean delete(int pzid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "delete from pz_board where pzid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pzid);
			int s = pstmt.executeUpdate();
			if (s == 0) {
				flag = false;
			} else {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("글삭제 오류 >> ");
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

	public PizzaDto replyView(int spzid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PizzaDto dto = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select *from pz_board where pzid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, spzid);
			rs = pstmt.executeQuery();
			// dto에 글전체 담아주기
			while (rs.next()) {
				int pzid = rs.getInt("pzid");
				String pzname = rs.getString("pzname");
				String pzsubj = rs.getString("pzsubj");
				String pzcontent = rs.getString("pzcontent");
				Date pzdate = rs.getDate("pzdate");
				int pzhit = rs.getInt("pzhit");
				int pzgroup = rs.getInt("pzgroup");
				int pzstep = rs.getInt("pzstep");
				int pzintent = rs.getInt("pzintent");
				dto = new PizzaDto(pzid, pzname, pzsubj, pzcontent, pzdate, pzhit, pzgroup, pzstep, pzintent);
				// 리스트에 담기
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

	public boolean reply(int pzid, String pzname, String pzsubj, String pzcontent, String pzgroup, String pzstep,
			String pzindent) {
		// 댓글을 달려는 원글의 스텝번호보다 큰 스텝이 있다면 1을 더해준다.
		replyShape(pzgroup, pzstep);
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into pz_board(pzid,pzname,pzsubj,pzcontent,pzgroup,pzstep,pzintent)"
					+ "values(pz_board_seq.nextval,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pzname);
			pstmt.setString(2, pzsubj);
			pstmt.setString(3, pzcontent);
			pstmt.setInt(4, Integer.parseInt(pzgroup)); // 원글의 번호
			pstmt.setInt(5, Integer.parseInt(pzstep) + 1); // 순서 원래 글의 step 의 +1
			pstmt.setInt(6, Integer.parseInt(pzindent) + 1);// 들여쓰기 원래 글의 indent 의 +1
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

	private void replyShape(String pzgroup, String pzstep) {
		// db 연결 후 insert 쿼리 실행
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			conn = dataSource.getConnection();
			String sql = "update pz_board set pzstep=pzstep+1 where pzgroup=? and pzstep>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pzgroup)); // 원글의 번호
			pstmt.setInt(2, Integer.parseInt(pzstep)); // 순서 원래 글의 step 의 +1
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