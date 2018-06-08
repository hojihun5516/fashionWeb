package snap.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import snap.dao.SnapDAO;

public class SnapGoodAction implements SnapAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		
		SnapDAO dao = SnapDAO.getInstance();
		dao.updateGoodCount(num);
		BoardVO vo = dao.selectOneBoard(num);
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher("snap/snapView.jsp").forward(request, response);
		
	}

}
