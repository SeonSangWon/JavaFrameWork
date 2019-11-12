package yuhan.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import yuhan.mvc.board.dto.BoardDTO;

public class BoardDAO {

	DataSource datasource;
	
	public BoardDAO() {
		
		try {
			//Try, Catch
			Context context = new InitialContext();
			
			//데이터소스의 Path를 찾는 메소드 (Oracle연결)
			datasource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//게시글 목록 확인
	public ArrayList<BoardDTO> list() {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			//Connection객체 생성 = getConnection()
			connection = datasource.getConnection();
			
			String query = "SELECT * FROM yuhan_board";
			
			preparedStatement = connection.prepareStatement(query);
			//Select문 = executeQuery()
			//Insert/Update/Delete = executeUpdate();
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int b_no = resultSet.getInt("b_no");
				String b_name = resultSet.getString("b_name");
				String b_subject = resultSet.getString("b_subject");
				String b_content = resultSet.getString("b_content");
				Timestamp b_date = resultSet.getTimestamp("b_date");
				
				BoardDTO dto = new BoardDTO(b_no, b_name, b_subject, b_content, b_date);
				list.add(dto);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
	//게시글 보기
	public BoardDTO contentView(int b_no) {
		
		BoardDTO dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = datasource.getConnection();
			
			String query = "SELECT * FROM yuhan_board WHERE b_no=?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, b_no);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				int Getb_no = resultSet.getInt("b_no");
				String Getb_name = resultSet.getString("b_name");
				String Getb_subject = resultSet.getString("b_subject");
				String Getb_content = resultSet.getString("b_content");
				Timestamp Getb_date = resultSet.getTimestamp("b_date");
				
				//DTO객체에 담아 전달
				dto = new BoardDTO(Getb_no, Getb_name, Getb_subject, Getb_content, Getb_date);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	}

	
	//게시글 작성
	public void write(String b_name, String b_subject, String b_content) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = datasource.getConnection();
			
			//seq넣어주기
			String query = "INSERT INTO yuhan_board(b_no, b_name, b_subject, b_content) "
					+ "VALUES(yuhan_board_seq.nextval, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, b_name);
			preparedStatement.setString(2, b_subject);
			preparedStatement.setString(3, b_content);
			
			//잘 수행되었는지 확인
			int count = preparedStatement.executeUpdate();
			if(count > 0)
				System.out.println("게시글이 정상적으로 등록되었습니다.");
			else
				System.out.println("게시글 등록에 실패했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 수정
	public void modify(int b_no, String b_name, String b_subject, String b_content) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = datasource.getConnection();
			
			//seq넣어주기
			
			String query = "UPDATE yuhan_board SET b_name=?, b_subject=?, b_content=?"
					+ "WHERE b_no=?";
			
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, b_name);
			preparedStatement.setString(2, b_subject);
			preparedStatement.setString(3, b_content);
			preparedStatement.setInt(4, b_no);
			
			//잘 수행되었는지 확인
			int count = preparedStatement.executeUpdate();
			if(count > 0)
				System.out.println("게시글이 정상적으로 등록되었습니다.");
			else
				System.out.println("게시글 등록에 실패했습니다.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제
	public void delete(int b_no) {
			
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = datasource.getConnection();
				
			//seq넣어주기
				
			String query = "DELETE FROM yuhan_board WHERE b_no=?";
				
			preparedStatement = connection.prepareStatement(query);
				
			preparedStatement.setInt(1, b_no);
				
			//잘 수행되었는지 확인
			int count = preparedStatement.executeUpdate();
			if(count > 0)
				System.out.println("게시글이 정상적으로 등록되었습니다.");
			else
				System.out.println("게시글 등록에 실패했습니다.");
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
