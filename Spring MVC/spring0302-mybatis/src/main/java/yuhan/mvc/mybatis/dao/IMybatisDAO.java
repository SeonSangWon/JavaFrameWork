package yuhan.mvc.mybatis.dao;

import java.util.ArrayList;

import yuhan.mvc.mybatis.dto.MybatisDTO;

public interface IMybatisDAO {

	//게시글 목록 전체 조회
	public ArrayList<MybatisDTO> list();
	
	//게시글 작성
	public void writeOK(String m_name, String m_content);
	
	//게시글 삭제
	public void delete(int m_id);
}
