<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<div id="user">
					<form id="login-form" name=loginform " method="post"
						action="${pageContext.request.contextPath}/user/login">
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="" />
						<label class="block-label" for="password">비밀번호</label>
						<input id="password" name="password" type="password" value="" />
						<c:if test="${'fail' == param.result }">
							<p>로그인이 실패 했습니다</p>
						</c:if>
						<input type="submit" value="Login">
					</form>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>