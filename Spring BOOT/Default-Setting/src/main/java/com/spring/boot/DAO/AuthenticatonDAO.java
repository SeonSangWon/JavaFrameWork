package com.spring.boot.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.boot.DTO.AuthenticationDTO;

@Repository
public class AuthenticatonDAO implements IAuthenticationDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String Namespace = "com.spring.boot.mapper.Authentication";
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<AuthenticationDTO> selectUser() {
		
		log.debug("########################################");
		log.debug("AuthenticatonDAO : selectUser()");
		log.debug("########################################");
		
		return sqlSession.selectList(Namespace+".selectUser");
	}

}
