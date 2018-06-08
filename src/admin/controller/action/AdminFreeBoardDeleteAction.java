package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminFreeBoardDAO;


public class AdminFreeBoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminFreeBoardDAO.getInstance().deleteBoard(request.getParameter("num"));
		
		new AdminFreeBoardListAction().execute(request, response);

	}

}
