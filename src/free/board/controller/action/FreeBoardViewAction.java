package free.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;

public class FreeBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.updateReadCount(num);
		BoardVO vo = dao.selectOneBoard(num);
		
		request.setAttribute("freeBoard", vo);
		request.getRequestDispatcher("free_board/freeboardView.jsp").forward(request, response);

	}

}
