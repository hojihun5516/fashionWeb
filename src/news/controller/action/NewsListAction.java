package news.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import member.controller.action.Action;
import news.dao.NewsDAO;

public class NewsListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = "news/newsList.jsp";
		
		List<BoardVO> list = NewsDAO.getInstance().selectAllBoards();
		
		request.setAttribute("newsList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}
}
