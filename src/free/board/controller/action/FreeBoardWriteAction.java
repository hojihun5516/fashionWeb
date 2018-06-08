package free.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.controller.action.Action;
import member.dto.MemberVO;

public class FreeBoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO) session.getAttribute("member");
		String nick = vo2.getNick();
		int num = vo2.getNum();
			
		BoardVO vo = new BoardVO();
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setTitlecolor(request.getParameter("titlecolor"));
		vo.setCategory("freeBoard");
		vo.setNick(nick);
		
		FreeBoardDAO dao = FreeBoardDAO.getInstance();
		dao.insertBoard(vo);
		dao.updatePoint(num);
		
		
		new FreeBoardListAction().execute(request, response);
		
	}

}
