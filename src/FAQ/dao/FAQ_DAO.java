package FAQ.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class FAQ_DAO {
	private FAQ_DAO() {}
	private static FAQ_DAO instance = new FAQ_DAO();
	public static FAQ_DAO getInstance(){
		return instance;
	}
	
	// 9. 글 목록을 모두 가져오기 위한 작업(FAQlistAction 에서 넘어옴)
	public List<BoardVO> selectAllBoards(){
		List<BoardVO> list= new ArrayList<BoardVO>();

		String sql="select num, f_category, title, writedate, readcount, nick from board where category='FAQ' order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try{
			conn = DBManager.getConnection(); 
			stmt = conn.createStatement();
			
			rs =  stmt.executeQuery(sql);	
			
			while(rs.next()){
				vo=new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setF_category(rs.getString("f_category"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setNick(rs.getString("nick"));
				
				list.add(vo);
			}
			System.out.println("list : "+list);
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			DBManager.close(conn, stmt, rs);
			
		}
		
		// 10. FAQlistAction.java 로 이동
		return list;
	}
	
	// 33. 글 삽입 메서드
	public void insertBoard(BoardVO vo){
		String sql="insert into board(num, title, f_category, content, category, nick) values (board_seq.nextval,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt = null;

		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getF_category());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getCategory());
			pstmt.setString(5, vo.getNick());
			/*pstmt.setInt(6, vo.getFr_num());*/
			
			pstmt.executeUpdate();
			System.out.println("완료");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
		// 34. 33번 마치고, 이동
		//		-> FAQwriteAction.java
	}
	
	
	public BoardVO selectOneBoard(String num){
		String sql="select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs =  pstmt.executeQuery();	
			
			if(rs.next()){
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setF_category(rs.getString("f_category"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setNick(rs.getString("nick"));
				vo.setContent(rs.getString("content"));
				System.out.println("dao vo : "+vo);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			DBManager.close(conn, pstmt, rs);
			
		}
		return vo;
		
	}
	
	public void deleteFAQ(String num){
		String sql="delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public List<BoardVO> selectCategory(String f_category	){
		String sql="select num, f_category, title, nick, writedate from board where f_category = ? order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, f_category);
			rs =  pstmt.executeQuery();	
			
			while(rs.next()){
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setF_category(rs.getString("f_category"));
				vo.setTitle(rs.getString("title"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setNick(rs.getString("nick"));
				
				list.add(vo);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			DBManager.close(conn, pstmt, rs);
			
		}
		return list;
	}
		
}
