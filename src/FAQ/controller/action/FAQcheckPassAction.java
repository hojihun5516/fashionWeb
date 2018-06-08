package FAQ.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import FAQ.dao.FAQ_DAO;
import board.dto.BoardVO;
import member.dto.MemberVO;

public class FAQcheckPassAction implements FAQAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String num = request.getParameter("num");
		System.out.println("num : "+num);
		/*HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		String pwd = member.getPwd();*/
		System.out.println("pwd : ");
		FAQ_DAO dao = FAQ_DAO.getInstance();
	
		
	}

}
