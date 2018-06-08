package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminFAQ_DAO;


public class AdminFAQBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		AdminFAQ_DAO.getInstance().deleteBoard(num);
		
		new AdminFAQBoardListAction().execute(request, response);

	}

}
