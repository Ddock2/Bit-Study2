<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
	HTTP의 특징
		Connection-less
			: 클라이언트의 request를 서버에 보내고,
			    서버는 클라이언트에게 response를 보내면,
			    연결이 끊김
		State-less
			: 접속을 끊는 순간 서버와의 통신 유지가 사라지는 특징
			
	쿠키 (Cookie)
		1. HTTP의 일종으로 클라이언트에 데이터를 저장하는 파일
		2. Login, HOST 정보 등을 저장
--%>
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