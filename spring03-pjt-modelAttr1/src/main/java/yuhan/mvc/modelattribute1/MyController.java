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

	/* 일반적인 방법
	 * @RequestMapping("userInfo") 
	 * public String userInfo(UserInfomationuserInfomation) {
	 * 
	 * return "user/userInfo"; 
	 * }
	 */
	
	//ModelAttribute를 사용한 방법
	@RequestMapping("userInfo")
	public String userInfo(@ModelAttribute("userInfo") UserInfomation userInfomation) {
		
		return "user/userInfo";
	}
}
