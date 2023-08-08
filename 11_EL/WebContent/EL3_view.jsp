<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>vo 정보 출력</h2>
	아이디 : ${vo.id}<br>
	이름 : ${vo.name}<br>
	주소 : ${vo.address}<br>
	${vo}
	
	<hr>
	<h2>list 정보 출력</h2>
	아이디 : ${list[0].id} <br>
	이름 : ${list[0].name} <br>
	주소 : ${list[0].address} <br>
	아이디2 : ${list[1].id} <br>
	이름2 : ${list[1].name} <br>
	주소2 : ${list[1].address} <br>
	

</body>
</html>