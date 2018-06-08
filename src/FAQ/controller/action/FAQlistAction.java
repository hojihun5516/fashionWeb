package FAQ.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.dao.FAQ_DAO;
import board.dto.BoardVO;

public class FAQlistAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 7. 목록 보여주기
		String url="FAQ/FAQList.jsp";
		
		// 8. 목록을 보여주기 위해 FAQ_DAO 의 db 에 있는 모든 글 가져오기
		//		-> FAQ_DAO.java 
		List<BoardVO> list= FAQ_DAO.getInstance().selectAllBoards();
		
		// 11. FAQ_DAO 에서 list에 글을 담아서 온 상태
		request.setAttribute("FAQList", list);
		// 12. setAttribute 를 해준 뒤, FAQList.jsp 로 이동!
		//		-> FAQList.jsp
		System.out.println("FAQ List ::: "+list);
		request.getRequestDispatcher(url).forward(request, response);
		}
	}

