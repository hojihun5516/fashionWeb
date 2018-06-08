package admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import member.dto.MemberVO;
import util.DBManager;

public class MemberDAO {
	private MemberDAO() {

	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public void deleteBoard(MemberVO vo) {
		String sql = "delete from member where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public MemberVO getMember(String nick) {
		String sql = "select * from member where nick=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nick);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setNick(rs.getString("nick"));
				vo.setPhone(rs.getString("phone"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				vo.setAdmin(rs.getInt("admin"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}

	public void updateMember(MemberVO vo) {
		String sql = "update member set pwd=?, name=?, nick=?, phone=?, age=?, gender=?, email=?, admin=? where num=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getAge());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getEmail());
			pstmt.setInt(8, vo.getAdmin());
			pstmt.setInt(9, vo.getNum());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<MemberVO> AllListMember() {
		String sql = "select * from member";
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setNum(rs.getInt("num"));
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setNick(rs.getString("nick"));
				vo.setPhone(rs.getString("phone"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setEmail(rs.getString("email"));
				vo.setPoints(rs.getInt("points"));
				vo.setAdmin(rs.getInt("admin"));
				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

}
