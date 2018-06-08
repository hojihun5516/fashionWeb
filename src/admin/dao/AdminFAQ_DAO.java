package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class AdminFAQ_DAO {
	private AdminFAQ_DAO() {}
	private static AdminFAQ_DAO instance = new AdminFAQ_DAO();
	public static AdminFAQ_DAO getInstance(){
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
				System.out.println("dao vo : "+vo);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
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
}
