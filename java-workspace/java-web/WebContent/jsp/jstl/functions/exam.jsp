<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		functions
			- prefix : fn
			- EL에서 사용할 수 있는 함수 제공
				length, toUpperCase, toLowerCase,
				subString, trim, indexOf, contains, ... 등
	--%>
	<c:set var="str" value="Hello JSTL"/>
	fn:length{"Hello JSTL"} : ${fn:length(str)}<br>
	fn:substring{ ("hello JSTL", 1, 4)) :
	${fn:substring(str, 1, 4)}<br>
</body>
</html>