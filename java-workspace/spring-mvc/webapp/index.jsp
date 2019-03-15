<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/hello.do">Hello</a><br>
	<a href="<%= request.getContextPath() %>/signUp.do">Method</a><br>
	<a href="<%= request.getContextPath() %>/loginForm.do">Form (login)</a><br>
	<a href="<%= request.getContextPath() %>/resBody.do">문자열 응답</a><br>
	<a href="<%= request.getContextPath() %>/resBody.json">JSON 응답</a><br>
	<a href="<%= request.getContextPath() %>/resVOBody.json">JSON VO 응답</a><br>
	<a href="<%= request.getContextPath() %>/resStrListBody.json">JSON List 응답</a><br>
	<a href="<%= request.getContextPath() %>/resVOListBody.json">JSON List(VO) 응답</a><br>
	<a href="<%= request.getContextPath() %>/file/uploadForm.do">Form (upload file)</a><br>
</body>
</html>