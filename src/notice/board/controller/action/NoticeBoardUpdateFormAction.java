package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardUpdateFormAction implements NoticeAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println("업데이트폼");
		NoticeBoardDAO dao = NoticeBoardDAO.getInstance();
		//#76]-수정할 때 글 조회수를 1 증가시키자
		//dao.updateReadCount(num); 이거때문에 수정해도 증가한다
		//#79]-조회수가 1증가된 db내용을 가져오자
		BoardVO vo = dao.selectOneBoard(num);
		
		request.setAttribute("notice_board", vo);
		
		request.getRequestDispatcher("/notice/noticeBoardUpdate.jsp").forward(request, response);
	}

}
