package snap.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.dto.BoardVO;
import snap.dao.SnapDAO;

public class SnapViewAction implements SnapAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		SnapDAO dao = SnapDAO.getInstance();
		dao.updateReadCount(num);
		BoardVO vo = dao.selectOneBoard(num);
		String age = Integer.toString(vo.getAge());
		
		age = age.charAt(0)+"0대";
		
		request.setAttribute("age", age);
		
		request.setAttribute("board", vo);
		request.getRequestDispatcher("snap/snapView.jsp").forward(request, response);
		
	}

}
