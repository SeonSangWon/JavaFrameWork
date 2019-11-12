package yuhan.mvc.board.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.board.DAO.BoardDAO;

public class BoardModifyService implements IBoardService {

	//게시글 수정
	@Override
	public void execute(Model model) {

		//Map타입으로 변경
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		String b_name = request.getParameter("b_name");
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		
		BoardDAO dao = new BoardDAO();
		dao.modify(b_no, b_name, b_subject, b_content);
	}
}
