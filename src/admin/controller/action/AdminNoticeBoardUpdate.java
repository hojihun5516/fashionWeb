package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminNoticeBoardDAO;
import board.dto.BoardVO;


public class AdminNoticeBoardUpdate implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("test");
		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		vo.setNick(request.getParameter("nick"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		
		System.out.println("vo : "+vo);
		AdminNoticeBoardDAO.getInstance().updateBoard(vo);
		
		new AdminNoticeBoardListAction().execute(request, response);
	}

}
