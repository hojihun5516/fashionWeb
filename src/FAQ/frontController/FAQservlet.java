package FAQ.frontController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FAQ.controller.action.FAQAction;

@WebServlet("/FAQservlet")
public class FAQservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FAQservlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 2. FAQIndex.jsp 에서 처음 목록가져오기 위해 왔다. : FAQ_list
		// 15. FAQ_write_form 들고 작성하기 위해 넘어옴
		// 26. FAQ_write_form 의 항목을 request 에 담아 왔다.
		// 39. FAQ_view 글 한건 보기
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		// 3. 서비스 클래스 만들어 오기 : FAQ_list
		//		-> FAQactionFactory.java
		// 16. 글쓰기 서비스 만들어 오기 : FAQ_write_form
		//		-> FAQactionFactory.java
		// 27. 글쓰기 db 용 서비스 불러오기 
		//		-> FAQactionFactory.java
		
		FAQactionFactory af = FAQactionFactory.getInstance();

		FAQAction action = af.getAction(command);
		
		// 6. FAQlistAction의 execute하러 가기
		//		-> FAQlistAction.java 
		// 19. FAQwriteFormAction 의 execute 하러 가기
		//		->  FAQwriteFormAction.java
		// 30. write, db 처리하러 가기
		//		-> FAQwriteAction.java
		// 42. view 페이지 보러가기
		//		-> FAQviewAction.java
		
		if(action != null){
			action.execute(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
