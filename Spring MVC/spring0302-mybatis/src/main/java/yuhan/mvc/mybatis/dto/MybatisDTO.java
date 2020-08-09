package yuhan.mvc.mybatis.dto;

public class MybatisDTO {

	private int m_id;
	private String m_name;
	private String m_content;
	
	public MybatisDTO() {
		
	}
	
	public MybatisDTO(int m_id, String m_name, String m_content) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_content = m_content;
	}
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_content() {
		return m_content;
	}
	public void setM_content(String m_content) {
		this.m_content = m_content;
	}
	
}
