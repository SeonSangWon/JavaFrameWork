  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- c태그를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- fmt를 사용하기위한 태그 라이브러리 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MySQL Connection Test</title>
</head>
<body>

	<h1 style="text-align: center; margin-top: 10px;">Spring Boot - MySQL Connection Test!!!</h1>
	<br/>
	<br/>
	
	<div style="margin-left: 30px;">
		<c:forEach items="${authentication}" var="auth">
			${auth.id} <br/>
			${auth.password} <br/>
			${auth.enabled} <br/>
			${auth.authority} <br/>
		</c:forEach>
	</div>
</body>
</html>