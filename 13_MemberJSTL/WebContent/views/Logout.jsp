<%@page import="servlet.model.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%-- 로그아웃에서 가장 필요한,,invalidate --%>
<% 
MemberDTO dto = (MemberDTO)session.getAttribute("dto");
if(dto!=null){
	session.invalidate();
	
%>
<body onload="return logout()">
	<script>
		function logout(){
			alert('Logout!');
			location.href="../index.jsp";
		}
	</script>
</body>
<% } %>

</html>