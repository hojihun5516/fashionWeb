package notice.board.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import notice.board.dao.NoticeBoardDAO;


public class NoticeBoardDeleteAction implements NoticeAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO vo = new BoardVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println("vo : "+vo.getNum());

		NoticeBoardDAO.getInstance().deleteBoard(vo);
		
	//수정이 완료되면 , 프론트를 거쳐서 리스트를 보지 말고
	//바로 리스트 서비스를 불러보자!
	//#90] boardList.jsp로간다
		new NoticeBoardListAction().execute(request, response);
		
	}

}
