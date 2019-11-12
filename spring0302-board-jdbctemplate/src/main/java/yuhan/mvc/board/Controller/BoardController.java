package yuhan.mvc.board.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import yuhan.mvc.board.Service.BoardContentService;
import yuhan.mvc.board.Service.BoardDeleteService;
import yuhan.mvc.board.Service.BoardListService;
import yuhan.mvc.board.Service.BoardModifyService;
import yuhan.mvc.board.Service.BoardWriteService;
import yuhan.mvc.board.Service.IBoardService;

@Controller
public class BoardController {

	private IBoardService service;
	
	//게시글 목록
	@RequestMapping("/")
	public String list(Model model) {
		
		//BoardListService의 기본 틀만 생성
		service = new BoardListService();
		service.execute(model);
		
		return "list";
	}
	
	//게시글 확인
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardContentService();
		service.execute(model);
		
		return "Content_view";
	}
	
	//게시글 작성
	@RequestMapping("write_view")
	public String write_view() {
		
		return "write_view";
	}
	
	//게시글 작성 Action
	@RequestMapping("write")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardWriteService();
		service.execute(model);
		
		return "redirect:/";
	}
	
	
	//게시글 변경 Action
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardModifyService();
		service.execute(model);
		
		return "redirect:/";
	}
	
	@RequestMapping("delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		service = new BoardDeleteService();
		service.execute(model);
		
		return "redirect:/";
	}
	
}
