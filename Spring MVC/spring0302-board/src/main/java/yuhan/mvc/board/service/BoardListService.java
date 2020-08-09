package yuhan.mvc.board.service;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.ui.Model;

import yuhan.mvc.board.dao.BoardDAO;
import yuhan.mvc.board.dto.BoardDTO;

public class BoardListService implements IBoardService {
	
	//게시글 목록
	@Override
	public void execute(Model model) {

		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> dtos = dao.list();
		
		model.addAttribute("list", dtos);
	}
}
