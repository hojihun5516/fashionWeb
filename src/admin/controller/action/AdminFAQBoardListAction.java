package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminFAQ_DAO;
import board.dto.BoardVO;

public class AdminFAQBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/admin_faq_board_list.jsp";

		List<BoardVO> list = AdminFAQ_DAO.getInstance().selectAllBoards();

		request.setAttribute("FAQList", list);
		System.out.println(list);
		request.getRequestDispatcher(url).forward(request, response);
	}
}