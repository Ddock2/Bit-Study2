<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<form class="board-form" method="post"
				action="${pageContext.request.contextPath}/board/write">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글쓰기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><input type="text" name="title" value=""></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td><textarea id="content" name="content"></textarea></td>
					</tr>
				</table>
				<spring:hasBindErrors name="boardVO">
					<c:if test="${errors.hasFieldErrors('title')}">
						<p style="text-align:center; color:red;">
						<spring:message
							code="${errors.getFieldError('title').codes[0]}"
							text="${errors.getFieldError('title').defaultMessage}"/>
					</c:if>
					<c:if test="${errors.hasFieldErrors('content')}">
						<p style="text-align:center; color:red;">
						<spring:message
							code="${errors.getFieldError('content').codes[0]}"
							text="${errors.getFieldError('content').defaultMessage}"/>
					</c:if>
				</spring:hasBindErrors>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/board">취소</a>
					<input type="submit" value="등록">
				</div>
			</form>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>