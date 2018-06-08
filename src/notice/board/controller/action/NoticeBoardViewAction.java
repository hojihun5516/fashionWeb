package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;

public class NoticeBoardViewAction implements NoticeAction{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String num = request.getParameter("num");

		
		
		NoticeBoardDAO.getInstance().updateReadCount(num);
		//#44] 번호에 해당하는 글 한건 가지러 가자
		 BoardVO vo = NoticeBoardDAO.getInstance().selectOneBoard(num);
		//#47] 글 한건 갖고왔다.	=>boardView.jsp로가자
		request.setAttribute("notice_board", vo);
		request.getRequestDispatcher("notice/noticeBoardView.jsp").forward(request, response);
		

	}

}
