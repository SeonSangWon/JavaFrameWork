package com.spring.boot.Service;

import java.util.List;

import com.spring.boot.DTO.AuthenticationDTO;

public interface IAuthenticatonService {

	public List<AuthenticationDTO> selectUser();
}
