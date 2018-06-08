package snap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class SnapDAO {

	private SnapDAO() {
	
	}
	private static SnapDAO instance = new SnapDAO();
	public static SnapDAO getInstance(){
		return instance;
	}
	
	public void insertSnap(BoardVO vo){
		String sql = "insert into board(num, title, content, image, category, nick, age, link) values"
				+ "(board_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImage());
			pstmt.setString(4, vo.getCategory());
			pstmt.setString(5, vo.getNick());
			pstmt.setInt(6, vo.getAge());
			pstmt.setString(7, vo.getLink());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	public List<BoardVO> bestSnapSelect(){
		String sql = "select * from (select * from BOARD where category='snap' order by readcount desc ) where rownum <= 6";
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
				vo.setNick(rs.getString("nick"));
				vo.setAge(rs.getInt("age"));
				vo.setTitle(rs.getString("title"));
				vo.setImage(rs.getString("image"));
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
		
		String sql = "select image, title, nick, age, num from BOARD where category='snap' order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				vo = new BoardVO();
				vo.setImage(rs.getString("image"));
				vo.setTitle(rs.getString("title"));
				vo.setNick(rs.getString("nick"));
				vo.setAge(rs.getInt("age"));
				vo.setNum(rs.getInt("num"));
				list.add(vo);
				System.out.println("vo : "+vo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return list;
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
	
	public void updateReadCount(String num){
		String sql = "update board set readcount = readcount+1 where num=?";
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
	
	public BoardVO selectOneBoard(String num){
		String sql = "select * from board where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setAge(rs.getInt("age"));
				vo.setNick(rs.getString("nick"));
				vo.setContent(rs.getString("content"));
				vo.setGood(rs.getInt("good"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setImage(rs.getString("image"));
				vo.setLink(rs.getString("link"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		
		return vo;
	}
	
	public void deleteBoard(String num) {
		String sql = "delete from board where num=?";
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
		String sql = "update MEMBER set points=10+(select points from member where num= ?) where num = ?";
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
