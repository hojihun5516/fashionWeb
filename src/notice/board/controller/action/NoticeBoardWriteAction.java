package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardWriteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		vo.setNick(request.getParameter("nick"));
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setCategory(request.getParameter("category"));

		NoticeBoardDAO.getInstance().insertBoard(vo);
		
		
		new NoticeBoardListAction().execute(request, response);
		
		
	}

}
