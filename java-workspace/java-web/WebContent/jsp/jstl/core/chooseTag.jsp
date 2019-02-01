<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		<c:choose>
			: if~else 혹은 switch~case와 비슷하다
			
			<c:when>
				: else if 혹은 case와 유사, 내부조건을 비교
			<c:otherwise>
				: default와 유사, 조건이 만족하지 않은 경우
	--%>
	<c:choose>
		<c:when test="${ param.type eq 'S' }">
			<h4>관리자 입니다</h4>
		</c:when>
		<c:when test="${ param.type eq 'U' }">
			<h4>일반 사용자 입니다</h4>
		</c:when>
		<c:otherwise>
			<h4>type parameter가 전송되지 않았습니다</h4>		
		</c:otherwise>
	</c:choose>
</body>
</html>