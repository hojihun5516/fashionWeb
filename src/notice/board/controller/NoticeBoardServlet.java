package notice.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.board.controller.action.NoticeAction;


@WebServlet("/NoticeBoardServlet")
public class NoticeBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoticeBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//디렉토리패턴 -커맨드
		// /insert /... 이런패턴
		
		//#2]index.jsp 에서 왔다.(첨.. 목록을보여줘)	- board_list
		//#15]board_write_form을 들고 글쓰기 하러 왔다.
		//#26]board_write 5개 항목을 request에 담아왔다.
		//#39]board_view 글 한건 보기 하러 왔다.
		//#52]자바스크립트 -수정하러 왔다 . board_check_pass_form
		//#61]수정 - board_check_pass
		//#71]수정- form 하러 왔다 글번호도 들고 왔다
		//#82]수정완료 후 db에 쓰러 가자
		String command = request.getParameter("command");
		System.out.println("command : " +command);
		
		NoticeBoardActionFactory af = NoticeBoardActionFactory.getInstance();

		//#3] 서비스 클래스 만들어 오자!
		//#16] 글쓰기 서비스 만들어 오자
		//#27] 글쓰기 db용 서비스를 불러오자
		//#40] 글 한건보기
		//#53] 글 수정 - 서비스 만들기
		//#62] 수정- 비번 체크
		//#72] 수정 - 뷰페이지보기
		//#83]수정완료 db 작성
		NoticeAction action = af.getAction(command);
		
		if(action!=null){
			//#6] BoardListACtion 의 execute하러가자
			//#19]BoardWriteFormAction의 execute 하러 가자
			//#30] write , db 하러가자
			//#42] view , 페이지보러가자
			//#56] 스크립트 창에 뷰페이지 넣어주러 가자
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
