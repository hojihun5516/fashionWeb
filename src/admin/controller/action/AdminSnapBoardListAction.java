package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminSnapDAO;
import board.dto.BoardVO;

public class AdminSnapBoardListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/admin_snap_board_list.jsp";
		List<BoardVO> list = AdminSnapDAO.getInstance().selectAllBoards();

		request.setAttribute("snapList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}
}
