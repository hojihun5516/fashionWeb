package member.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sendRedirect로 보내면 경로가 재설정된다.(엉킨다)
		//response.sendRedirect("member/memberInsert.jsp");
		request.getRequestDispatcher("member/memberInsert.jsp").forward(request, response);
	}

}
