package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.MemberDAO;
import member.dto.MemberVO;

public class AdminMemberUpdateAction implements Action {

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
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO.getInstance().updateMember(vo);
		
		
		new AdminMemberListAction().execute(request, response);
	}
}
