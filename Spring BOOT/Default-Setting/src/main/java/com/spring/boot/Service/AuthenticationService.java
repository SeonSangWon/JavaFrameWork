package com.spring.boot.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.DAO.IAuthenticationDAO;
import com.spring.boot.DTO.AuthenticationDTO;

@Service
public class AuthenticationService implements IAuthenticatonService {
	
	@Autowired
	private IAuthenticationDAO authenticationDAO;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<AuthenticationDTO> selectUser() {
		
		log.debug("########################################");
		log.debug("AuthenticationService : selectUser()");
		log.debug("########################################");
		
		return authenticationDAO.selectUser();
	}

}
