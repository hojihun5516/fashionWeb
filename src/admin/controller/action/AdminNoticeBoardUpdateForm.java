package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNoticeBoardDAO;
import board.dto.BoardVO;


public class AdminNoticeBoardUpdateForm implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("업데이트폼");
		AdminNoticeBoardDAO dao = AdminNoticeBoardDAO.getInstance();
		BoardVO vo = dao.selectOneBoard(num);
		
		request.setAttribute("notice_board", vo);
		
		request.getRequestDispatcher("/admin/admin_notice_board_update.jsp").forward(request, response);
	}

}
