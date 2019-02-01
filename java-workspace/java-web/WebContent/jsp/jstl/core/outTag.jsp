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
	value 속성만 지정 :
		<c:out value="JSTL" /> <br>
	value 속성값이 없는 경우 :
		<c:out value="${msg}" default="msg가 영역내에 존재하지 않습니다"/> <br>
	태그를 포함하는 경우 :
		<c:out value="<hr>"/><br>
	태그를 포함하는 경우 (속성: escapeXml = false) :
		<c:out value="<hr>" escapeXml="false" /><br>
		<%-- 
			기본적으로 태그를 포함하는 경우 기능을 탈출한 상태
			HTML태그의 기능을 사용하려면 탈출을 false 설정
		--%>
		<%--
			XML (Extensible Markup Language)
				: 데이터 처리를 위해 확장된 마크업 언어
				    문서를 표현하는데 주로 사용되지만, 자료구조로도 활용
		--%>
</body>
</html>