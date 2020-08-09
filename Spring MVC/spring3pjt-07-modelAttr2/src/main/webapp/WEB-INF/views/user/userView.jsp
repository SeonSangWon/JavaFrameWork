<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>UserView Page</title>
</head>
<body>
<h2>${msg}</h2>

<c:forEach var="car" items="${hitCar}">
	${car},&nbsp;
</c:forEach>

</body>
</html>