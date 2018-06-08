package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNewsDAO;


public class AdminNewsDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		AdminNewsDAO.getInstance().deleteBoard(num);
		
		new AdminNewsListAction().execute(request, response);

	}

}
