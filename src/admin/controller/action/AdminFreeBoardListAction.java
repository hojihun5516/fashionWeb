package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminFreeBoardDAO;
import board.dto.BoardVO;


public class AdminFreeBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/admin_free_board_list.jsp";
		

		List<BoardVO> list = AdminFreeBoardDAO.getInstance().selectAllBoards();

		request.setAttribute("freeBoardList", list);


		request.getRequestDispatcher(url).forward(request, response);

	}

}
