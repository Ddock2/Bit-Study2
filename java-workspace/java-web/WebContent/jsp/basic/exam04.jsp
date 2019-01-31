<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 파라미터의 이름과 값을 확인
		Enumeration<String> headerEnum = request.getHeaderNames();
		while(headerEnum.hasMoreElements()){
			String headerName = headerEnum.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
		<%= headerName %> = <%= headerValue %>
	<%		
		}
	%>
</body>
</html>