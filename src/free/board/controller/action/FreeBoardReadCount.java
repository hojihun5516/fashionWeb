package free.board.controller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;

public class FreeBoardReadCount implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");

		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.updateReadCount(num);
		request.setAttribute("ber", num);
		new FreeBoardListAction().execute(request, response);
		


	
	
	}

}
