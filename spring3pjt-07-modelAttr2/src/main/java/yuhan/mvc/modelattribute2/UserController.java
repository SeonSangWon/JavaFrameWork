package yuhan.mvc.modelattribute2;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	//ModelAttribute은 View에 Model을 전달 (배열데이터를 전달해서 사용)
	@ModelAttribute("hitCar")
	public String[] refHitcar() {
		
		return new String[] {"현대차", "대우차", "쌍용차", "기아차"};
	}
	
	@RequestMapping("userForm")
	public String userForm() {
		
		System.out.println("----------userForm----------");
		return "user/userForm2";
	}
	
	@RequestMapping(value = "userSave", method = RequestMethod.POST)
	public ModelAndView userInfo(UserVO userVO, Model model) {
		
		model.addAttribute("msg", "자동차 정보 출력 성공");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/user/userInfo2");
		mav.addObject("userVo", userVO);
		
		return mav;
	}
	
	@RequestMapping("userView")
	public Model userView() {
		
		//Ȯ��� Model
		Model model = new ExtendedModelMap();
		model.addAttribute("msg", "자동차 회사 출력 정보");
		
		return null;
	}
	
	@ModelAttribute("userVo")
	public UserVO init(HttpServletRequest request) {
		
		if(request.getMethod().equalsIgnoreCase("GET"))
		{
			UserVO vo = new UserVO();
			
			vo.setUserName("유한대 이름을 입력하세요..");
			vo.setAddress("주소를 입력하세요..");
			vo.setCar("자동차 이름을 입력하세요..");
			
			return vo;
		}
		else
		{
			System.out.println("@ModelAttribute : POST..");
			return new UserVO();
		}
	}
}
