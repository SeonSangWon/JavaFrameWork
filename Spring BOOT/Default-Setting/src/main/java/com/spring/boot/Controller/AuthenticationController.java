package com.spring.boot.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.boot.DTO.AuthenticationDTO;
import com.spring.boot.Service.IAuthenticatonService;

@Controller
public class AuthenticationController {

	@Autowired
	private IAuthenticatonService authenticationService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(path="/authentication")
	public String Authentication(AuthenticationDTO authenticationDTO, Model model) {
		
		log.info("########################################");
		log.info("AuthenticationController : Authentication()");
		log.info("########################################");
		
		model.addAttribute("authentication", authenticationService.selectUser());
		
		return "authentication";
	}
}
