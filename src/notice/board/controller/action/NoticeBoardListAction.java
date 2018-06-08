package notice.board.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardListAction implements NoticeAction{

	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "notice/noticeBoardList.jsp";
		List<BoardVO> list = NoticeBoardDAO.getInstance().selectAllBoards();
		
		request.setAttribute("noticeBoardList", list);
		System.out.println("list"+list);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
