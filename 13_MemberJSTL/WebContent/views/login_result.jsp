<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	MemberDTO dto = (MemberDTO) session.getAttribute("dto"); 
	if(dto!=null) {
	%>
	<h1>로그인 정보</h1>
	<ul>
	<li>아이디 : <%=dto.getId() %></li>
	<li>이름 : <%=dto.getName() %></li>
	<li>주소 : <%=dto.getAddress() %></li>
	</ul>
		<a href="/index.jsp">첫 페이지로 이동></a>
	
	<% } else { %>
		<h3>로그인 실패..! 로그인하고 오십시오.</h3>
		<a href="Login.html">login.html></a>
	<% } %>
</body>
</html>