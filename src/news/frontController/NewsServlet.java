package news.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dto.BoardVO;
import member.controller.action.Action;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		NewsActionFactory af = NewsActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String command = "";
		
		String title = "";
		String content = "";
		String category = "";
		String image = "";
		
		String realPath = request.getServletContext().getRealPath("upload");
		int size = 10*1024*1024;
		String enc = "utf-8";
		MultipartRequest multi = null;
		
		try{
			multi = new MultipartRequest(request, realPath, size, enc, new DefaultFileRenamePolicy());
			
			command = multi.getParameter("command");
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			category = multi.getParameter("category");
			image = multi.getFilesystemName("image");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setImage(image);
			vo.setCategory(category);
			
			request.setAttribute("vo", vo);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		NewsActionFactory af = NewsActionFactory.getInstance();
		Action action = af.getAction(command);
		
		if(action != null){
			action.execute(request, response);
		}
	}

}
