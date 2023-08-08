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
	<h2>회원 정보 수정</h2>
	<hr>
	<% MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	 if(dto != null){
	%>
		<form action="/UpdateServlet" method="post">
		<input type="hidden" name="id" value="<%= dto.getId() %>">
		이름 : <input type="text" name="name" value="<%= dto.getName() %>" required ><br>
		비밀번호 : <input type="password" name="password" value="<%= dto.getPassword() %>" required><br>
		주소 : <input type="text" name="address" value="<%= dto.getAddress() %>" required><br>
		<input type="submit" value="변경하기">
		</form>
		<a href="/index.jsp">첫 페이지로 돌아가기</a>

	<% } %>
</body>
</html>