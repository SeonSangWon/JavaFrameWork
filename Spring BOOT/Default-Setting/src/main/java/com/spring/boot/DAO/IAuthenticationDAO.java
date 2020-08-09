package com.spring.boot.DAO;

import java.util.List;

import com.spring.boot.DTO.AuthenticationDTO;

public interface IAuthenticationDAO {

	public List<AuthenticationDTO> selectUser();
}
