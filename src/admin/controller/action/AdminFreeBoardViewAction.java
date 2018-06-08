package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminFreeBoardDAO;
import board.dto.BoardVO;

public class AdminFreeBoardViewAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");

		
		BoardVO vo = AdminFreeBoardDAO.getInstance().selectOneBoard(num);
		request.setAttribute("freeBoard", vo);
		request.getRequestDispatcher("admin/admin_free_board_view.jsp").forward(request, response);
		
	}
}
