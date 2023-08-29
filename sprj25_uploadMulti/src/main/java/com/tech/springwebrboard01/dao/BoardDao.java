package com.tech.springwebrboard01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tech.springwebrboard01.dto.BoardDto;

public class BoardDao {
	DataSource dataSource;
	
	public BoardDao() {
//		db접속
		try {
			Context context=new InitialContext();
			dataSource=(DataSource) context.lookup("java:comp/env/jdbc/springxe");	
			System.out.println("dataSource 생성성공----------");		
//			Connection con=dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("dataSource 생성오류");
		}	
	}
	public ArrayList<BoardDto> list() {
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
//		
//		
//		try {
//			con=dataSource.getConnection();
////			String sql="select bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent "
////					+ "from replyboard"; 
//			
//			String sql="select bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent "
//					+ "from replyboard order by bgroup desc,bstep asc"; 
//			
//			pstmt=con.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			
//			while(rs.next()) {
//				int bid=rs.getInt("bid");
//				String bname=rs.getString("bname");
//				String btitle=rs.getString("btitle");
//				String bcontent=rs.getString("bcontent");
//				
//				Timestamp bdate=rs.getTimestamp("bdate");
//				
//				int bhit=rs.getInt("bhit");
//				int bgroup=rs.getInt("bgroup");
//				int bstep=rs.getInt("bstep");
//				int bindent=rs.getInt("bindent");
//				
//				//생성자주입
//				BoardDto dto=new BoardDto(bid, bname, btitle, bcontent,
//						bdate, bhit, bgroup, bstep, bindent);
//				//리스트에 추가
//				dtos.add(dto);	
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();	
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		return dtos;
		return null;
	}
	public void write(String bName, String bTitle, String bContent) {
		// insert 작업
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try {
//			con=dataSource.getConnection();
//			String sql="insert into replyboard " + 
//					"values(replyboard_seq.nextval,?,?,?,"+
//					"sysdate,0,replyboard_seq.currval,0,0)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, bName);
//			pstmt.setString(2, bTitle);
//			pstmt.setString(3, bContent);
//			int rn=pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();	
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
		
	}
	public void upHit(String sbid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update replyboard " + 
					"set bhit=bhit+1 where bid=?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public BoardDto contentView(String sbid) {
		
//		upHit(sbid);//조회수 증가
//		BoardDto dto=null;
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		ResultSet rs=null;
//		
//		try {
//			con=dataSource.getConnection();
//			String sql="select bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent "
//					+ "from replyboard where bid=?"; 
//			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(sbid));
//			rs=pstmt.executeQuery();
//			
//			rs.next();
//			int bid=rs.getInt("bid");
//			String bname=rs.getString("bname");
//			String btitle=rs.getString("btitle");
//			String bcontent=rs.getString("bcontent");
//			
//			Timestamp bdate=rs.getTimestamp("bdate");
//			
//			int bhit=rs.getInt("bhit");
//			int bgroup=rs.getInt("bgroup");
//			int bstep=rs.getInt("bstep");
//			int bindent=rs.getInt("bindent");
//			
//			//생성자주입
//			dto=new BoardDto(bid, bname, btitle, bcontent,
//					bdate, bhit, bgroup, bstep, bindent);	
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			try {
//				if(rs!=null) rs.close();
//				if(pstmt!=null) pstmt.close();
//				if(con!=null) con.close();	
//			} catch (Exception e2) {
//				// TODO: handle exception
//			}
//		}
//		
//		return dto;
		return null;
	}
	public void modify(String bid, String bName,
			String bTitle, String bContent) {
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			String sql="update replyboard " + 
					"set bname=?,btitle=?,bcontent=? " + 
					"where bid=?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bid));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
	}
	public void delete(String bid) {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="delete from replyboard where bid=?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bid));
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public BoardDto replyView(String sbid) {
		
		BoardDto dto=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			String sql="select bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent "
					+ "from replyboard where bid=?"; 
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sbid));
			rs=pstmt.executeQuery();
			
			rs.next();
			int bid=rs.getInt("bid");
			String bname=rs.getString("bname");
			String btitle=rs.getString("btitle");
			String bcontent=rs.getString("bcontent");
			
			Timestamp bdate=rs.getTimestamp("bdate");
			
			int bhit=rs.getInt("bhit");
			int bgroup=rs.getInt("bgroup");
			int bstep=rs.getInt("bstep");
			int bindent=rs.getInt("bindent");
			
			//생성자주입
			dto=new BoardDto(bid, bname, btitle, bcontent,
					bdate, bhit, bgroup, bstep, bindent);	
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dto;
	}
	
	public void replyShape(String bgroup,String bstep) {
		//현재글의 댓글이 있다면 그 댓글의 step번호 1증가
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update replyboard set bstep=bstep+1 " + 
					"where bgroup=? and bstep>?";			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,Integer.parseInt(bgroup));
			pstmt.setInt(2,Integer.parseInt(bstep));
			pstmt.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}	
	}
	public void reply(String bid, String bName,
			String bTitle, String bContent,
			String bgroup, String bstep,
			String bindent) {
		
		replyShape(bgroup,bstep);
				
		Connection con=null;
		PreparedStatement pstmt=null;	
		try {
			con=dataSource.getConnection();
			String sql="insert into replyboard(bid,bname,btitle,bcontent,bgroup,bstep,bindent) " + 
					"values(replyboard_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,bName);
			pstmt.setString(2,bTitle);
			pstmt.setString(3,bContent);
			pstmt.setInt(4,Integer.parseInt(bgroup));
			pstmt.setInt(5,Integer.parseInt(bstep)+1);
			pstmt.setInt(6,Integer.parseInt(bindent)+1);
			
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	
}
