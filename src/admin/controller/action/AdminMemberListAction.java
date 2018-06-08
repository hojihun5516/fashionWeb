package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.MemberDAO;
import member.dto.MemberVO;


public class AdminMemberListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/admin_member_list.jsp";

		List<MemberVO> allMember = MemberDAO.getInstance().AllListMember();
		request.setAttribute("allMember", allMember);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
