package free.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;
import member.dto.MemberVO;

public class FreeBoardNickListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "free_board/freeBoardList.jsp";
		
		BoardVO vo = new BoardVO();
		vo.setNick(request.getParameter("nick"));
		vo.setCategory(request.getParameter("category"));
		String nick = request.getParameter("nick");
		System.out.println(nick);
		List<BoardVO> list = FreeBoardDAO.getInstance().selectnickBoards(vo);

		request.setAttribute("freeBoardList", list);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
