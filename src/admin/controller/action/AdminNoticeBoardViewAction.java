package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNoticeBoardDAO;
import board.dto.BoardVO;

public class AdminNoticeBoardViewAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");

		
		BoardVO vo = AdminNoticeBoardDAO.getInstance().selectOneBoard(num);
		request.setAttribute("notice_board", vo);
		request.getRequestDispatcher("admin/admin_notice_board_view.jsp").forward(request, response);
		
	}
}
