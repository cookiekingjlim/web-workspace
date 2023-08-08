<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1. jsp 기본 태그로 받아오기</h3>
	<%= request.getParameter("id") %>
	
	<h3>2. EL로 받아오기</h3>
	${param.id}
	
	<hr>
	
	<h3>1. jsp 기본 태그로 받아오기</h3>
	<%
		String[] menus = request.getParameterValues("menu");
		for(String menu : menus) {
	%>
		<%= menu %><br>
	<% } %>
	
	<h3>2. EL로 받아오기</h3>
	- ${paramValues.menu[0]}<br>
	- ${paramValues.menu[1]}<br>
	- ${paramValues.menu[2]}<br>
	
		
	
</body>
</html>