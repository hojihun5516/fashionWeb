package user.frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dto.BoardVO;
import snap.controller.action.SnapAction;
import snap.frontController.SnapActionFactory;
import user.controller.action.UserAction;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		UserActionFactory af = UserActionFactory.getInstance();
		UserAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = "";
		String realPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;
		String enc = "utf-8";
		MultipartRequest multi = null;
		
		try{
			multi = new MultipartRequest(request, realPath, size, enc, new DefaultFileRenamePolicy());
			
			command = multi.getParameter("command");
			String title = multi.getParameter("title");
			String content = multi.getParameter("content");
			String category = multi.getParameter("category");
			String image = multi.getFilesystemName("image");
			String nick = multi.getParameter("nick");
			int age = Integer.parseInt(multi.getParameter("age"));
			int num = Integer.parseInt(multi.getParameter("num"));
			String link = multi.getParameter("link");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImage(image);
			vo.setCategory(category);
			vo.setNick(nick);
			vo.setAge(age);
			vo.setNum(num);
			vo.setLink(link);
			
			request.setAttribute("vo", vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		UserActionFactory af = UserActionFactory.getInstance();
		UserAction action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

}
