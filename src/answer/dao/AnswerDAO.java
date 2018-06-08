package answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import answer.dto.AnswerVO;
import board.dto.BoardVO;
import util.DBManager;

public class AnswerDAO {
	private AnswerDAO(){}
	
	private static AnswerDAO instance = new AnswerDAO();
	
	public static AnswerDAO getInstance(){
		return instance;
	}
	
	public void insertAnswer(AnswerVO vo){
		String sql = "insert into ANSWER(num, fr_num, content, nick) values (answer_seq.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getFr_num());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNick());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
	
	public List<AnswerVO> selectAnswer(int num){
		List<AnswerVO> list = new ArrayList<AnswerVO>();
		
		String sql = "select num, fr_num, content, writedate, nick from answer where fr_num=? order by num desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AnswerVO vo = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				vo = new AnswerVO();
				vo.setNum(rs.getInt("num"));
				vo.setFr_num(rs.getInt("fr_num"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setNick(rs.getString("nick"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public void deleteAnswer(int num){
		String sql="delete from answer where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
