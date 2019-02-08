<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="/mysite/user?a=joinProcess" method="post">
		<div>
			<span>아이디</span>
			<input type="text" name="id"/>
		</div>
		<div>
			<span>비밀번호</span>
			<input type="password" name="password"/>
		</div>
		<div>
			<span>이름</span>
			<input type="text" name="name"/>
		</div>
		<input type="submit" value="가입"/>
	</form>
</body>
</html>