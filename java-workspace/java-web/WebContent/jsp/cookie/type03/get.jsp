<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<%
	Cookie[] cookies = request.getCookies();

	StringBuilder sb = new StringBuilder();
	if(cookies != null){
		for(Cookie c : cookies){
			String cName = c.getName();
			cName = URLDecoder.decode(cName, "utf-8");
			String cValue = c.getValue();
			cValue = URLDecoder.decode(cValue, "utf-8");
			
			// encode된 데이터를 텍스트화 하기 위한, decode
			
			sb.append("쿠키 이름 : " + cName + ", ");
			sb.append("쿠키 값 : " + cValue + "<br>");
		}
	}else{
		sb.append("설정된 쿠키정보가 없습니다");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설정된 쿠키 정보</h2>
	<%= sb.toString() %>
	<a href="indexForm.jsp">쿠키 설정 화면</a>
</body>
</html>