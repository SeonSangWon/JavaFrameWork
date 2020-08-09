<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserInfo Page</title>
</head>
<body>
   <div align="center">
   <h2>${msg}</h2>
   <hr/>
   
  <form action="userView" method="post">
<table border="1" cellpadding="2" cellspacing="0">
        
        <tr>
          <td>이름</td>
          <td>${userVo.userName}</td>
        </tr>
        
        <tr>
          <td>주소</td>
          <td>${userVo.address}</td>
         </tr>
         
         <tr>
        <td>자동차회사명</td>
        <td>${userVo.car}</td>
         </tr>
           
     <tr>
           <td>자동차</td>
           <td>
             <c:forEach  var="car" items="${hitCar}">
               ${car}, &nbsp;
             </c:forEach>
           </td>
         </tr>
                    
        </table>
        <input type="submit"  value="뷰로이동"/> 
    </form> 
            
  </div> 
</body>
</html>