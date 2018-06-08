package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class AdminFreeBoardDAO {
	private AdminFreeBoardDAO() {
	}

	private static AdminFreeBoardDAO instance = new AdminFreeBoardDAO();

	public static AdminFreeBoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards() {

		List<BoardVO> list = new ArrayList<BoardVO>();
		// num nick title content writedate good readcount category
		String sql = "select num,title,content,writedate,good,readcount,nick from board where board.category='freeBoard' order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement(); // conn.prepareStatement(sql);

			rs = stmt.executeQuery(sql); // pstmt.executeQuery();

			while (rs.next()) { // 행 단위 변화
				vo = new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setNick(rs.getString("nick"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setGood(rs.getInt("good"));
				vo.setReadcount(rs.getInt("readcount"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	public BoardVO selectOneBoard(String num) {
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
				// num nick title content writedate good readcount category
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
