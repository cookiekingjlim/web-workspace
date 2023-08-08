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
	<h1>회원 검색 결과</h1>
	<% MemberDTO dto = (MemberDTO) request.getAttribute("dto"); %>
	<ul>
		<li>아이디 : <%= dto.getId() %></li>
		<li>이름 : <%= dto.getName() %></li>
		<li>주소 : <%= dto.getAddress() %></li>
	</ul>
</body>
</html>