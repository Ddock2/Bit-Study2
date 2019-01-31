<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- cName, cValue의 파라미터 값이 post방식으로 set.jsp로 전송 -->
	<form action="set.jsp" method="post">
		쿠키 이름 : <input type="text" name="cName" size="20" /><br>
		쿠키 값 : <input type="text" name="cValue" size="20" /><br>
		<input type="submit" value="쿠키설정"/>
	</form>
</body>
</html>