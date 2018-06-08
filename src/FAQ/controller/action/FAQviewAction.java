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

public class FAQviewAction implements FAQAction {

	// 43. view 페이지로 이동하고, 보여줄 글 한 건! 내용 들고 view 페이지로 가야한다.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FAQ_DAO dao= FAQ_DAO.getInstance();
		String num=request.getParameter("num");
		System.out.println("num : "+num);
		// 44. db 에서 그 글 한 건 가지러 가기
		BoardVO vo=dao.selectOneBoard(num);
		
		List<AnswerVO> list = AnswerDAO.getInstance().selectAnswer(Integer.parseInt(num));
		
		// 47. 그 글 한건 갖고 오기
		request.setAttribute("board", vo);
		request.setAttribute("answer", list);
		System.out.println("view answer list : "+list);
		// FAQView 페이지로 보내기
		request.getRequestDispatcher("FAQ/FAQView.jsp").forward(request, response);
		
	}

}
