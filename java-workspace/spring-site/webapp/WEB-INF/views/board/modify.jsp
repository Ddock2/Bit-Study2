<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
				action="${pageContext.request.contextPath}/board/modify">
				<input type="hidden" name="no" value="${boardVO.no}">
				<input type="hidden" name="p" value="${page}">
				<input type="hidden" name="kwd" value="${keyword}">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글수정</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td><input type="text" name="title" value="${boardVO.title}"></td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td><textarea id="content" name="content">${boardVO.content}</textarea></td>
					</tr>
				</table>
				<div class="bottom">
					<a href="javascript:history.go(-1)">취소</a>
					<input type="submit" value="수정">
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