package yuhan.mvc.board.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.board.dao.BoardDAO;
import yuhan.mvc.board.dto.BoardDTO;

public class BoardContentService implements IBoardService {

	//내용 보기
	@Override
	public void execute(Model model) {
		
		//Map타입으로 변경
		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int b_no = Integer.parseInt(request.getParameter("b_no"));

		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.contentView(b_no);
		
		model.addAttribute("content_view", dto);
	}
}
