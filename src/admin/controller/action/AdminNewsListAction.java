package admin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import news.dao.NewsDAO;

public class AdminNewsListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String url = "admin/admin_news_list.jsp";
		
		List<BoardVO> list = NewsDAO.getInstance().selectAllBoards();
		
		request.setAttribute("newsList", list);
		
		request.getRequestDispatcher(url).forward(request, response);


	}

}
