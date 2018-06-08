package FAQ.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FAQwriteFormAction implements FAQAction {

	// 20.FAQservlet.java 에 들렀다가 왔다.
	//		-> FAQWrite.java
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("FAQ/FAQWrite.jsp").forward(request, response);
	}

}
