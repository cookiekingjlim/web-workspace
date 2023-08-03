<%--
JSP Element
1) 지시어 %@ % : 컨테이너에게 알려줄 내용 지정!
2) 스클릿틀릿 % % : 자바 코드는 이 안에 지정
3) 출력문 %= % : 출력하려는 내용 지정
 --%>
 
 <!--  주석의 차이 -->
 <%-- 브라우저 소스 보기에서 안 보임 --%> 
 <!-- 브라우저 소스 보기에서 보임-->  
 
 
 <%--import는 지시어 --%>
<%@ page import="servlet.model.MemberVO" %>	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <!--% % :: Scriptlet Element  -->
 <% 
 	MemberVO vo = (MemberVO) application.getAttribute("vo");
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<!-- %= % :: Expression Element -->
		<h2>회원님의 정보를 출력합니다..</h2>
		<p> 이름 : <%= vo.getName()%></p>
		<p> 나이 : <%= vo.getAge()%></p>
		<p> 주소 : <%= vo.getAddr()%></p>
</body>
</html>