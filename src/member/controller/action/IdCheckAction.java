package member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		int result = MemberDAO.getInstance().idCheck(id);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		request.getRequestDispatcher("member/idCheck.jsp").forward(request, response);
	}

}
