package FAQ.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.dao.FAQ_DAO;
import board.dto.BoardVO;

public class FAQwriteAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 31. request 에 담긴 내용을 꺼내서 db 에 사용하기(작성자, 제목, 분류, 내용)
		//String fr_num = request.getParameter("fr_num");
		BoardVO vo = new BoardVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setNick(request.getParameter("nick"));
		vo.setF_category(request.getParameter("f_category"));
		vo.setContent(request.getParameter("content"));
		vo.setCategory(request.getParameter("category"));
		//vo.setFr_num(Integer.parseInt(request.getParameter("fr_num")));
		System.out.println("write vo : "+vo);
		// 32. 글 삽입하러 가기! 
		//		-> FAQ_DAO.java
		FAQ_DAO.getInstance().insertBoard(vo);
		
		new FAQlistAction().execute(request, response);
		
		// 35. insert 하고 온상태, insert 한 뒤에 글 목록으로 가기
		// 36. 목록으로 가되, 프론트 거치지 않고 직행하는 방법
		//		-> FAQList.jsp
		
	}

}
