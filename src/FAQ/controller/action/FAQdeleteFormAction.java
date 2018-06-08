package FAQ.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;

public class FAQdeleteFormAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setNick(request.getParameter("nick"));
		vo.setTitle(request.getParameter("title"));
		System.out.println("vo ::::: "+vo);
		request.setAttribute("vo", vo);
		
		request.getRequestDispatcher("FAQDelete.jsp").forward(request, response);

	}

}
