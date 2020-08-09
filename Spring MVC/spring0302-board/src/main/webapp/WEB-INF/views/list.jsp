<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board-List</title>
</head>
<style>
	table {
    	border: 1px solid #444444;
    	border-collapse: collapse;
  }
  th, td {
    	border: 1px solid #444444;
  }
</style>
<body>
	<div align="center" style="magin-top: 80px;">
		<table cellpadding="1" cellspacing="1" border="2">
			<tr>
				<td width="40">번호</td>
				<td width="70">이름</td>
				<td width="200">제목</td>
				<td width="100">날짜</td>
			</tr>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4" align="center">
						게시글이 존재하지 않습니다.
					</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.b_no}</td>
						<td>${dto.b_name}</td>
						<td>
							<a href="content_view?b_no=${dto.b_no}">${dto.b_subject}</a>
						</td>
						<td>
							<fmt:formatDate value="${dto.b_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="7" align="left">
					<a href="write_view">글작성</a>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>