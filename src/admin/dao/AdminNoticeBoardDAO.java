package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardVO;
import util.DBManager;

public class AdminNoticeBoardDAO {

	private AdminNoticeBoardDAO() {

	}

	private static AdminNoticeBoardDAO instance = new AdminNoticeBoardDAO();

	public static AdminNoticeBoardDAO getInstance() {
		return instance;
	}

	public List<BoardVO> selectAllBoards(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String sql="select num, nick, category, title, content, readcount, writedate from BOARD where category='notice' order by num desc";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try{
			conn=DBManager.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				vo=new BoardVO();
				vo.setNum(rs.getInt("num"));
				vo.setNick(rs.getString("nick"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				list.add(vo);
			}
			System.out.println("noticeBoard list : "+list);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	public void insertBoard(BoardVO vo) {
		String sql="insert into board(num, title, content, nick, category) values("
				+ "board_SEq.nextval,?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());	//문장완성
			pstmt.setString(3, vo.getNick());	
			pstmt.setString(4, vo.getCategory());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
			
		}
	}


	public BoardVO selectOneBoard(String num) {
		String sql="select * from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			rs =  pstmt.executeQuery();
			
			if(rs.next()){  //글 한건!
				vo=new BoardVO();
				vo.setNum(rs.getInt("NuM"));
				vo.setNick(rs.getString("nick"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
			
			
		}
		//#46] BoardViewAction으로 돌아가자
		return vo;

	}

	public void updateBoard(BoardVO vo) {
		String sql = "update board set nick=?, title=?, content=? where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNick());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getNum()); // 문장 완성됐다~
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		//#89] 리턴!
	}


	public void deleteBoard(BoardVO vo) {
		String sql="delete from board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
			//익스큐트 쿼리는 예를들어 셀렉트처럼 보여줘
			// 업데이트는 변경이 조금이라도있단다
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
