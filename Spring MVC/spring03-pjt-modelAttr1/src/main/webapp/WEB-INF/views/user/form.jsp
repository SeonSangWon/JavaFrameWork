<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form Page</title>
</head>
<body>

<%
	String context = request.getContextPath();
%>
<form action="<%=context%>/userInfo" method="POST">
<table>
	<tr>
		<td>
			이름 :
		</td>
		<td>
			<input type="text" name="name" />
		</td>
	</tr>
	<tr>
		<td>
			나이 : 
		</td>
		<td>
			<input type="text" name="age" />
		</td>
	</tr>
	<tr>
		<td>
		 	성별 : 
		</td>
		<td>
			<input type="text" name="gender" />
		</td>
	</tr>
	<tr>
		<td>
			키 :
		</td>
		<td>
			<input type="text" name="height" />
		</td>
	</tr>
	<tr>
		<td>
			몸무게 :
		</td>
		<td>
			<input type="text" name="weight" />
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="전송하기" />
		</td>
	</tr>

</table>
</form>

</body>
</html>