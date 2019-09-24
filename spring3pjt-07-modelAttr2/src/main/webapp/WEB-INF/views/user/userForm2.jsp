<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자동차회원정보</title>
</head>
<body>
<div align="center">
     <h2>자동차회원정보입력</h2>
     <hr/>

     <form action="userSave" method="post">
        <table border="1" cellpadding="2" cellspacing="0">
    
           <tr>
             <td>이름</td>
             <td><input type="text" name="userName" value="${userVo.userName }"/></td>
           </tr>
           
           <tr>
             <td>주소</td>
             <td><input type="text" name="address" value="${userVo.address }"/></td>
           <tr>
           
           <tr>
             <td>자동차회사명</td>
             <td><input type="text" name="car" value="${userVo.car }"/></td>
           <tr>
           
  <%-- <tr>
  <td>자동차</td>
  <td><c:forEach var="car" items="${hitCar}">
  ${car}, &nbsp;
  </c:forEach>
  </td>
  </tr> 
  --%>
  
  </table>
         
       <input type="submit"  value="전송" />
     
     </form>
  </div>
</body>
</html>