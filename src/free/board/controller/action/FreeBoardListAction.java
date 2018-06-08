package free.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;

public class FreeBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "free_board/freeBoardList.jsp";
		String ber = (String) request.getAttribute("ber");
		
		List<BoardVO> list = FreeBoardDAO.getInstance().selectAllBoards();
		request.setAttribute("freeBoardList", list);
		request.setAttribute("ber", ber);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
