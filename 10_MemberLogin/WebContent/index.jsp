<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 기능</h1>
	
	<ul>
	<%-- 로그인이 되어있지 않은 경우 -> 회원가입,로그인 --%>
	<li><a href="views/register.html">회원가입</a></li>
		<%-- 회원가입: 아이디, 비밀번호, 이름, 주소 입력 받아서
				-> RegisterServlet / post 방식으로 전달
				-> session에 데이터 바인딩 -> 회원가입과 함께 로그인된 상태로 넘김
				-> session에 값이 있는 경우 : AllMemberServlet으로
				-> 	 		값이 없는 경우 : index.jsp
		 --%>
	<li><a href="views/Login.html">로그인</a></li>
		<%-- 로그인: 아이디, 비밀번호 입력해서
				-> LoginServelt / post 방식으로 전달
				-> 해당하는 값들 받아서 session에 데이터 바인딩 : views/login_result.jsp(정보 출력)
		 --%>
	
	<%-- 로그인 되었을 때 -> 회원검색, 전체회원보기, 로그아웃 --%>
	<li><a href="views/search.html">회원검색</a></li>
		<%-- 회원검색: 검색할 아이디를 입력받아서
				-> FindMemberServlet // 검색 성공하면 views/find_ok.jsp(정보 출력)
											실패하면 views/find_faill.jsp
		
		 --%>
	<li><a href="AllMemberServlet">전체회원보기</a></li>
		<%-- 전체회원보기: views/allShow.jsp에 전체 리스트 출력 --%>
	<li><a href="view/Logout.jsp">로그아웃</a></li>
		<%-- 로그아웃: 로그아웃 하고 index.jsp로 오기--%>
	
	</ul>
</body>
</html>