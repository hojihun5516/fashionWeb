package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class AdminNewsDAO {

	public AdminNewsDAO() {

	}
	private static AdminNewsDAO instance = new AdminNewsDAO();
	public static AdminNewsDAO getInstance(){
		return instance;
	}
	
	public List<BoardVO> selectAllBoards(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		String sql = "select * from BOARD where category='news' order by num desc";
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
				vo.setNum(rs.getInt("num"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
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
	
	public void insertNews(BoardVO vo){
		String sql = "insert into board(num, title, content, image, category) values"
				+ "(board_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getImage());
			pstmt.setString(4, vo.getCategory());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
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
