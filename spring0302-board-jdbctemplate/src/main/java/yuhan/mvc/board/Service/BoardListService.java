package yuhan.mvc.board.Service;

import java.util.ArrayList;

import org.springframework.ui.Model;

import yuhan.mvc.board.DAO.BoardDAO;
import yuhan.mvc.board.DTO.BoardDTO;

public class BoardListService implements IBoardService {
	
	//게시글 목록
	@Override
	public void execute(Model model) {

		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos = dao.list();
		
		model.addAttribute("list", dtos);
	}
}
