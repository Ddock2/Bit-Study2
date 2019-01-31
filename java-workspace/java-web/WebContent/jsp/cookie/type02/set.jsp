<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<%
	request.setCharacterEncoding("utf-8");

	String cName = request.getParameter("cName");
	cName = URLEncoder.encode(cName, "utf-8"); // 파라미터 자체를 utf-8
	String cValue = request.getParameter("cValue");
	cValue = URLEncoder.encode(cValue, "utf-8");
	
	// cName, cValue
	// URLEncoder를 통해 인자 전달 (한글 전달)
	
	Cookie cookie = new Cookie(cName, cValue);
	
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