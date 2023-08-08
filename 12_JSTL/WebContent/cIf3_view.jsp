<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${param.num eq '1'}">
		<h2>1값이 들어왔습니다</h2>
	</c:if>
	<c:if test="${param.num eq '2'}">
		<h2>2값이 들어왔습니다</h2>
	</c:if>
</body>
</html>