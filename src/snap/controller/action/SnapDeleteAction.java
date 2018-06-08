package snap.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import snap.dao.SnapDAO;

public class SnapDeleteAction implements SnapAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		SnapDAO.getInstance().deleteBoard(num);
		
		new SnapListAction().execute(request, response);

	}

}
