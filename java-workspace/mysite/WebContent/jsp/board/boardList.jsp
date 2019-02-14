<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#board-list {
		text-align: center;
	}
	
	#board-list th, td {
		border: 1px solid;
	}
</style>
<script>
	function writeBoard(){
		location.href = "/mysite/controller/board?a=write";
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>게시판</h2>
		<hr width="80%">
		<br>
		<table style="width: 70%; border: 1px solid;" id="board-list">
			<tr>
				<th width="15%">번호</th>
				<th width="50%">제목</th>
				<th width="20%">작성자</th>
				<th width="15%">조회수</th>
			</tr>
			<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.no }</td>
					<td>
						<a href="/mysite/controller/board?a=boardDetail&no=${ board.no }">
							<c:out value="${ board.title }"/>
						</a>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.view_cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
		<br>
		<c:if test="${ not empty userVO }">
			<input type="button" value="글 등록" onclick="writeBoard()"/>
		</c:if>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>