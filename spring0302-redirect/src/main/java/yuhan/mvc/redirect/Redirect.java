package yuhan.mvc.redirect;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Redirect {
	
	//view폴더 자체가 root의 개념
	@RequestMapping("/loginForm")
	public String loginForm() {
		
		return "loginId";
	}
	
	@RequestMapping("/memberConfirm")
	public String memberConfirm(HttpServletRequest request, Model model) {
		
		String id = request.getParameter("id");
		
		if(id.equals("sangwon"))
			return "member/MemberOK";
		else
			//redirect를 사용해 RequestMapping("/memberFail")을 호출
			return "redirect:/memberFail";
	}
	
	//redirect:/memberFail
	//redirect:/ 사용 할 경우 /을 따라 home.jsp를 호출 
	@RequestMapping("/memberFail")
	public String memberFail() {
			
		return "member/MemberFail";
	}
	
	/*
	@RequestMapping("/memberConfirm")
	public String memberConfirm(@RequestParam String id) {
		
		String url = "";
		
		if(id.equals("sangwon"))
			url = "member/MemberOK";
		else
			url = "member/MemberFail";
		
		return url;
	}
	*/
}
