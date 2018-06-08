package free.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import board.dto.BoardVO;
import util.DBManager;


public class FreeBoardDAO {
	private FreeBoardDAO(){}
	private static FreeBoardDAO instance = new FreeBoardDAO();
	public static FreeBoardDAO getInstance(){
		return instance;
	}
	public void updateGoodCount(String num){
		String sql = "update board set good = good+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			pstmt.executeUpdate();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	public List<BoardVO> bestFreeBoard(){
		String sql = "select * from (select * from BOARD where category='freeBoard' order by readcount desc ) where rownum <= 7";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setReadcount(rs.getInt("readcount"));
				list.add(vo);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
		
	}
	public List<BoardVO> selectAllBoards(){
		
		List<BoardVO> list = new ArrayList<BoardVO>();
			//num nick title content writedate good readcount category
		String sql="select num,title,content,writedate,good,readcount,nick,titlecolor from board where board.category='freeBoard' order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			stmt = conn.createStatement();   //conn.prepareStatement(sql);
			
			rs =  stmt.executeQuery(sql);			 // pstmt.executeQuery();
			
			while(rs.next()){  //행 단위 변화
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNick(rs.getString("nick"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setGood(rs.getInt("good"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setTitlecolor(rs.getString("titlecolor"));
	
				list.add(vo);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
public List<BoardVO> selectnickBoards(BoardVO vo){
	List<BoardVO> list = new ArrayList<BoardVO>();
	//System.out.println("nick : "+nick);
	//and where board.category='freeBoard' 
	String sql = "select num, nick, title, content, writedate, good, readcount from board where nick=? and category=? order by num desc";
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getNick());
		pstmt.setString(2, vo.getCategory());
		rs = pstmt.executeQuery();

		while(rs.next()) {
			vo = new BoardVO();
			//num, nick, title, content, writedate, good, readcount, category
			vo.setNum(rs.getInt("num"));
			vo.setTitle(rs.getString("title"));
			vo.setNick(rs.getString("nick"));
			vo.setContent(rs.getString("content"));
			vo.setWritedate(rs.getTimestamp("writedate"));
			vo.setGood(rs.getInt("good"));
			vo.setReadcount(rs.getInt("readcount"));
			
			list.add(vo);
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	return list;
	
}

	public void insertBoard(BoardVO vo){
		//num nick title content writedate good readcount category
		String sql = "insert into board(num, title, content,nick,category,titlecolor) values("
				+ "board_SEq.nextval, ?, ?, ?, ?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getCategory());
			pstmt.setString(5, vo.getTitlecolor());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public BoardVO selectOneBoard(String num){
		String sql = "select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BoardVO();
				//num nick title content writedate good readcount category
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setNick(rs.getString("nick"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setGood(rs.getInt("good"));
				vo.setReadcount(rs.getInt("readcount"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	public void updateBoard(BoardVO vo) {
		String sql = "update board set title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getNum()); 			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	public void deleteBoard(String num){
		String sql="delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void updateReadCount(String num) {
		String sql = "update board set readcount = readcount+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}	
	
	}
	
	public void updatePoint(int num){
		String sql = "update MEMBER set points=5+(select points from member where num= ?) where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}	
	
	}
}
