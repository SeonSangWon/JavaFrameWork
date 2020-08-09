package yuhan.mvc.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.board.dao.BoardDAO;

public class BoardDeleteService implements IBoardService {

	//게시글 삭제
	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int b_no = Integer.parseInt(request.getParameter("b_no"));
		
		BoardDAO dao = new BoardDAO();
		dao.delete(b_no);
	}
}
