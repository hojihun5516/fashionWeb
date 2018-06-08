package free.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;

public class FreeBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardVO vo = new BoardVO();

		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		FreeBoardDAO.getInstance().updateBoard(vo);
			
		new FreeBoardListAction().execute(request, response);
	
	}

}
