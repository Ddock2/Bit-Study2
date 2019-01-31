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
	
	String cAge = request.getParameter("cAge");
	
	Cookie cookie = new Cookie(cName, cValue);
	
	// setMaxAge() : 쿠키 유효시간 설정
	if(cAge != null && cAge.length() > 0){
		cookie.setMaxAge(Integer.parseInt(cAge) * 60);
	}
	
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