package yuhan.mvc.mybatis.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yuhan.mvc.mybatis.dto.MybatisDTO;

@Repository
public class MybatisDAO implements IMybatisDAO {
	
	//JDBC 사용 환경 설정 완료
	JdbcTemplate template;
	
	@Autowired
	public void settemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//게시글 목록 전체 조회
	@Override
	public ArrayList<MybatisDTO> list() {
		
		String query = "SELECT * FROM mybatis_board ORDER BY m_id DESC";
		
		//SQL문을 실행시킨 후, 조회된 레코드를 List에 담아 반환
		ArrayList<MybatisDTO> dtos = (ArrayList<MybatisDTO>)template.query(query, new BeanPropertyRowMapper<MybatisDTO>(MybatisDTO.class));
		
		return dtos;
	}

	//게시글 작성
	@Override
	public void writeOK(String m_name, String m_content) {
		// TODO Auto-generated method stub

	}

	//게시글 삭제
	@Override
	public void delete(int m_id) {
		// TODO Auto-generated method stub

	}

}
