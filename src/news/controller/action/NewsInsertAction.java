package news.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dto.BoardVO;
import member.controller.action.Action;
import news.dao.NewsDAO;

public class NewsInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardVO vo = (BoardVO)request.getAttribute("vo");
		vo.setImage(request.getContextPath()+"/upload/"+vo.getImage());
		
		NewsDAO.getInstance().insertNews(vo);
		
		new NewsListAction().execute(request, response);

	}

}
