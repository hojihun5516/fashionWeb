package FAQ.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.dao.FAQ_DAO;
import answer.dao.AnswerDAO;
import answer.dto.AnswerVO;
import board.dto.BoardVO;

public class FAQanswerAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AnswerVO vo = new AnswerVO();
		vo.setFr_num(Integer.parseInt(request.getParameter("fr_num")));
		vo.setContent(request.getParameter("content"));
		vo.setNick(request.getParameter("nick"));
		System.out.println("vo nick : "+vo);
		AnswerDAO dao = AnswerDAO.getInstance();
		dao.insertAnswer(vo);
		List<AnswerVO> list = dao.selectAnswer(vo.getFr_num());
		
		BoardVO board = FAQ_DAO.getInstance().selectOneBoard(request.getParameter("fr_num"));
		System.out.println("board vo :"+board);
		request.setAttribute("board", board);
		request.setAttribute("answer", list);
		System.out.println("answer list : "+list);
		request.getRequestDispatcher("FAQ/FAQView.jsp").forward(request, response);
		

	}

}
