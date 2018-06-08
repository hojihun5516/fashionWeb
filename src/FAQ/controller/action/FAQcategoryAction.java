package FAQ.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.dao.FAQ_DAO;
import board.dto.BoardVO;

public class FAQcategoryAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FAQ_DAO dao = FAQ_DAO.getInstance();
		List<BoardVO> list = dao.selectCategory(request.getParameter("f_category")); 
		
		request.setAttribute("FAQList", list);
		
		request.getRequestDispatcher("FAQ/FAQList.jsp").forward(request, response);
		
	}

}
