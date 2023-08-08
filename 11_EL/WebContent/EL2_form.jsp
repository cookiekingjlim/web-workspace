<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Form 값을 EL로 받아오기</h2>
	<form action="EL2_view.jsp" method="post">
		<p>ID: <input type="text" name="id"></p>
		<h3>좋아하는 메뉴</h3>
		<input type="checkbox" name="menu" value="pasta">파스타
		<input type="checkbox" name="menu" value="curry">카페
		<input type="checkbox" name="menu" value="noodle">국수
		<p><input type="submit" value="데이터전송"></p>
	</form>
</body>
</html>