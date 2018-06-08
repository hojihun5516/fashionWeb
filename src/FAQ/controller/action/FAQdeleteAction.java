package FAQ.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.dao.FAQ_DAO;

public class FAQdeleteAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FAQ_DAO.getInstance().deleteFAQ(request.getParameter("num"));
	
		request.getRequestDispatcher("FAQDelete.jsp").forward(request, response);
	}

}
