<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/signUp.do" method="POST">
		GET 호출...
		<!-- signUp.do 요청을 POST 방식으로! -->
		<input type="submit" value="POST 호출">
	</form>
</body>
</html>