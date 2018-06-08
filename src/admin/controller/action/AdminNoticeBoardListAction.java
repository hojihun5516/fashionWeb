package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNoticeBoardDAO;
import board.dto.BoardVO;

public class AdminNoticeBoardListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/admin_notice_board_list.jsp";
		List<BoardVO> list = AdminNoticeBoardDAO.getInstance().selectAllBoards();

		request.setAttribute("noticeBoardList", list);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
