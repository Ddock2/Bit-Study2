<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 30em;
	}
</style>
</head>
<body>
	<h2>게시판 목록</h2>
	<br><br>
	<table border="1">
		<tr align="center">
			<th>제목</th>
			<th>작성자</th>
		</tr>
		
		<c:forEach var="l" items="${list}">		
			<tr align="center">
				<td width="75%"><c:out value="${l.title}"/></td>
				<td width="25%"><c:out value="${l.writer}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>