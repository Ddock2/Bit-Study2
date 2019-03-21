<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp"/>
		<div id="content">
			<div id="user">
				<!-- form:form : 데이터 바인딩 및 에러처리 관련 스프링 프레임워크 태그 제공 -->
				<form:form modelAttribute="userVO" id="join-form" name="joinform"
					method="post" action="${pageContext.request.contextPath}/user/join">
					<label class="block-label" for="name">이름</label>
					<form:input path="name"/>
					<p style="text-align:left; color:red">
						<form:errors path="name"/>
					</p>
					
					<label class="block-label" for="email">이메일</label>
					<form:input path="email"/>
					<!-- 이메일 중복체크 (img, input) -->
					<p style="text-align:left; color:red">
						<form:errors path="email"/>
					</p>
					
					<label class="block-label" for="password">비밀번호</label>
					<form:input path="password"/>
					<spring:hasBindErrors name="userVO">
						<c:if test="${errors.hasFieldErrors('password')}">
							<p style="text-align:left; color:red;">
							<spring:message
								code="${errors.getFieldError('password').codes[0]}"
								text="${errors.getFieldError('password').defaultMessage}"/>
						</c:if>
					</spring:hasBindErrors>
					
					<fieldset>
						<legend>성별</legend>
						<label>남</label> <input type="radio" name="gender" value="male" checked="checked">
						<label>여</label> <input type="radio" name="gender" value="female">
					</fieldset>
					
					<fieldset>
						<legend>약관동의</legend>
						<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
						<label>서비스 약관에 동의합니다.</label>
					</fieldset>
					
					<input type="submit" value="가입하기">
				</form:form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp"/>
		<c:import url="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>