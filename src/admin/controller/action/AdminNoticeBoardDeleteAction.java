package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNoticeBoardDAO;
import board.dto.BoardVO;


public class AdminNoticeBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		AdminNoticeBoardDAO.getInstance().deleteBoard(vo);
		
		new AdminNoticeBoardListAction().execute(request, response);

	}

}
