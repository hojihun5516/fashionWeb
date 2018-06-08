package member.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.BoardVO;
import free.board.dao.FreeBoardDAO;
import member.dao.MemberDAO;
import member.dto.MemberVO;
import news.dao.NewsDAO;
import notice.board.dao.NoticeBoardDAO;
import snap.dao.SnapDAO;

public class MainFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPwd(request.getParameter("pwd"));
		
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.memberCheck(vo);
		
		if(result == 1){
			dao.updateAdmin(vo.getId());
			vo = dao.getMember(vo.getId()); 
			
			HttpSession session = request.getSession();
			session.setAttribute("member", vo);
			url="main.jsp";
			
			List<BoardVO> list = SnapDAO.getInstance().bestSnapSelect();
			request.setAttribute("bestSnap", list);
						
			list = NoticeBoardDAO.getInstance().newestNotice();
			request.setAttribute("newestNotice", list);
			
			list = FreeBoardDAO.getInstance().bestFreeBoard();
			request.setAttribute("bestFreeBoard", list);
			
			list = NewsDAO.getInstance().selectOneBoard();
			request.setAttribute("news", list);
			
		}else if(result == 0){
			request.setAttribute("message1", "가 틀렸어요.");
		}else if(result == -1){
			request.setAttribute("message2", "가 존재하지 않습니다.");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
