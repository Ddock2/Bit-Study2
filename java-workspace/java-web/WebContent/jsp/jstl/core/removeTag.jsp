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
	pageContext 영역에 data 설정 :
	<c:set var="data" value="1"/>
	${ data } 
	<br>
	request 영역에 data 설정 :
	<c:set var="data" value="${ data + 1 }" scope="request" />
	${ requestScope.data }
	<br>
	

<%-- 	<c:remove var="data" /> --%>
	<%-- 생략 시 pageContext와 request 모두 삭제 --%>

	<c:remove var="data" scope="page"/>
<%-- 	<c:remove var="data" scope="request"/> --%>
	pageContext : ${ pageScope.data }<br>
	request : ${ requestScope.data }<br>
</body>
</html>

<%-- 
	자바는 문자열끼리의 + 연산이 가능했지만,
	EL식에서는 +연산은 숫자만 가능
--%>