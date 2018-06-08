package user.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import snap.dao.SnapDAO;

public class UserListAction implements UserAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "user/userList.jsp";
		
		List<BoardVO> list = SnapDAO.getInstance().selectAllBoards();
		
		request.setAttribute("UserList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
