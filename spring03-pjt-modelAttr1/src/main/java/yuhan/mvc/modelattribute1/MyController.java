package yuhan.mvc.modelattribute1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	
	@RequestMapping("/form")
	public String userForm() {
		
		return "user/form";
	}

	/*
	 * @RequestMapping("userInfo") public String userInfo(UserInfomation
	 * userInfomation) {
	 * 
	 * return "user/userInfo"; }
	 * 
	 */
	@RequestMapping("userInfo")
	public String userInfo(@ModelAttribute("userInfo") UserInfomation userInfomation) {
		
		return "user/userInfo";
	}
}
