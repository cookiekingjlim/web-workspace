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
	<c:choose>
		<c:when test="${param.num == '1'}">
			안녕
		</c:when>
		<c:when test="${param.num == '2'}">
			집에 가도 돼
		</c:when>
		<c:otherwise>
			아냐 집에 가지마
		</c:otherwise>
	</c:choose>
</body>
</html>