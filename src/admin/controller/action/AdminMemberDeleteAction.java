package admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.MemberDAO;
import member.dto.MemberVO;

public class AdminMemberDeleteAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(request.getParameter("num")));
		System.out.println("vo : "+vo.getNum());

		MemberDAO.getInstance().deleteBoard(vo);
		
		new AdminMemberListAction().execute(request, response);
	}
}
