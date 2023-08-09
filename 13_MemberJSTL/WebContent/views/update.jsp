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
	
	<%-- EL 구문 사용으로 필요없어
	<% MemberDTO dto = (MemberDTO) session.getAttribute("dto");
	 if(dto != null){
	%>
	--%>
		<form action="/UpdateServlet" method="post">
		아이디 : <input type="text" name="id" value="${dto.id}" readonly><br>
		비밀번호 : <input type="password" name="password" value="${dto.password}" required><br>
		이름 : <input type="text" name="name" value="${dto.name}" required ><br>
		주소 : <input type="text" name="address" value="${dto.address}" required><br>
		<input type="submit" value="변경하기">
		</form>
		<a href="/index.jsp">첫 페이지로 돌아가기</a>

	<%--<% } --%>
</body>
</html>