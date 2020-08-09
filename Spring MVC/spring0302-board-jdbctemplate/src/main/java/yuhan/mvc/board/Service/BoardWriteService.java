package yuhan.mvc.board.Service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import yuhan.mvc.board.DAO.BoardDAO;

public class BoardWriteService implements IBoardService {

	//게시글 등록
	@Override
	public void execute(Model model) {

		Map<String, Object>map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String b_name = request.getParameter("b_name");
		String b_subject = request.getParameter("b_subject");
		String b_content = request.getParameter("b_content");
		
		BoardDAO dao = new BoardDAO();
		dao.write(b_name, b_subject, b_content);
	}
}
