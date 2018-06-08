package member.controller.action;

import java.io.IOException;
import java.lang.management.MemoryManagerMXBean;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import member.dto.MemberVO;
import util.DBManager;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setName(request.getParameter("name"));
		vo.setNick(request.getParameter("nick"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAge(Integer.parseInt(request.getParameter("age")));
		vo.setGender(request.getParameter("gender"));
		vo.setEmail(request.getParameter("email"));
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		
		MemberDAO.getInstance().updateMember(vo);
		
		
		new MainFormAction().execute(request, response);
	}

}
