package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardUpdateAction implements NoticeAction {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정 내용은 request에 들어있다.
		//vo에 담아서 updateBoard()에 넣어주자
			System.out.println("test");
			BoardVO vo = new BoardVO();
			vo.setNum(Integer.parseInt(request.getParameter("num")));
			vo.setNick(request.getParameter("nick"));
			vo.setTitle(request.getParameter("title"));
			vo.setContent(request.getParameter("content"));
			
			System.out.println("vo : "+vo);
			//#87]db에 쓰러가자
			NoticeBoardDAO.getInstance().updateBoard(vo);
			
		//수정이 완료되면 , 프론트를 거쳐서 리스트를 보지 말고
		//바로 리스트 서비스를 불러보자!
		//#90] boardList.jsp로간다
			new NoticeBoardListAction().execute(request, response);
	}

}
