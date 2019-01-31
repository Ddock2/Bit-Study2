<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("UTF-8"); // 요청의 인코딩을 utf-8로
	String cName = request.getParameter("cName");
	String cValue = request.getParameter("cValue");
	
	//쿠키 생성
	Cookie cookie = new Cookie(cName, cValue);
	
	//클라이언트 접속
	response.addCookie(cookie);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 설정 완료</h2>
	<a href="get.jsp">설정된 쿠키 확인</a>
</body>
</html>