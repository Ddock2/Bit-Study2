<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function hiMain(){
		location.href = "/mysite"
	}
</script>
</head>
<body>
	<div id="footer">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>회원가입</h2>
		<hr width="80%">
		<br>
		<form action="/mysite/controller/member?a=joinProcess" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="password" maxlength="20"/>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" maxlength="20"/>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="가입"/>
			<input type="button" value="메인으로" onclick="hiMain()"/>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>