package free.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;
import news.controller.action.NewsListAction;

public class FreeBoardGoodAction implements Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		FreeBoardDAO dao = FreeBoardDAO.getInstance(); 
		dao.updateGoodCount(num); 
		BoardVO vo = dao.selectOneBoard(num);
		request.setAttribute("board", vo);

		new FreeBoardListAction().execute(request, response);
	}
}
