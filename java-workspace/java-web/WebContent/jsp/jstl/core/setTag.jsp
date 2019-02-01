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
		JSTL (Jsp Standard Tag Library)
			- JSP 표준 태그 제공
			- JSP만의 기능을 가진 태그를추가하여 사용 가능
		
		Core (prefix : c, uri : http://java.sun.com/jsp/jstl/core)
			- 이반 프로그래밍에서 사용하는 기능 제공
			- 변수, 실행흐름의 컨트롤, 페이지 이동 등의 기능 제공
	--%>

	<%--
		EL의 Scope 인식 범위
		pageContext -> request -> session -> application
	--%>
	10 값을 가지는 변수 cnt를 pageContext에 설정 : 
	<c:set var="cnt" value="10" />
	${ cnt } <%-- EL 출력 --%>
	<br>
	
	cnt 값 1증가 후  request에 등록 후 출력 : 
	<c:set var="cnt" value="${cnt+1}" scope="request" />
	${ requestScope.cnt }<br>
	
	pageContext cnt 값 : ${ cnt }
</body>
</html>