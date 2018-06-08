package snap.controller.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import board.dto.BoardVO;
import snap.dao.SnapDAO;

public class SnapInsertAction implements SnapAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		BoardVO vo = (BoardVO)request.getAttribute("vo");
		vo.setImage(request.getContextPath()+"/upload/"+vo.getImage());
		int num = vo.getNum();
		
		SnapDAO dao = SnapDAO.getInstance();
		dao.insertSnap(vo);
		dao.updatePoint(num);
		
		new SnapListAction().execute(request, response);
		
	}

}
