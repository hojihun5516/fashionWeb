package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.dto.MemberVO;
import util.DBManager;

public class MemberDAO {
	private MemberDAO(){
		
	}
	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance(){
		return instance;
	}
	
	public void insertMember(MemberVO vo){
		String sql ="insert into member(num,id,pwd,name,nick,phone,age,gender,email) values"
				+ "(member_seq.nextval, ?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getNick());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAge());
			pstmt.setString(7, vo.getGender());
			pstmt.setString(8, vo.getEmail());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public int idCheck(String id){
		String sql ="select id from member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("id").equals(id)){
					result = 1;
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public int memberCheck(MemberVO vo){
		String sql ="select pwd from member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("pwd").equals(vo.getPwd())){
					result = 1;
				} else{
					result = 0;
				}
			}else{
				result = -1;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}
	
	public MemberVO getMember(String id){
		String sql ="select * from member where id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO vo = null;
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
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
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt, rs);
		}
		return vo;
	}
	public void updateMember(MemberVO vo){
		String sql = "update member set pwd=?, name=?, nick=?, phone=?, age=?, gender=?, email=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getAge());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getEmail());
			pstmt.setInt(8, vo.getNum());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	public void updatePoints(MemberVO vo){
		String sql = "update member set points=? where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getPoints());
			pstmt.setInt(2, vo.getNum());
			
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateAdmin(String id){
		String sql = "update member set admin = case "
				+ "when points >= 0 and points < 20 then 0"
				+ "when points >= 20 and points < 40 then 1"
				+ "when points >= 40 and points < 100 then 2 "
				+ "when points >= 100 then 3"
				+ "when id = '' then 4"
				+ "end where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.close(conn, pstmt);
		}
	}
}
