package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.MemberDAO;
import member.dto.MemberVO;

public class AdminMemberUpdateForm implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MemberVO member = MemberDAO.getInstance().getMember(request.getParameter("nick"));
		request.setAttribute("member", member);
		request.getRequestDispatcher("admin/admin_member_update.jsp").forward(request, response);
	}

}
