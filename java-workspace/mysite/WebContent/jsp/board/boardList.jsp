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
		width: 70%;
		border: 1px solid;
		margin-bottom: 10px;
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
		<table id="board-list">
			<tr height>
				<th width="15%" height="40">번호</th>
				<th width="50%">제목</th>
				<th width="20%">작성자</th>
				<th width="15%">조회수</th>
			</tr>
			<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.no }</td>
					<td align="left" style="padding-left: 10px;">
						<a href="/mysite/controller/board?a=boardDetail&no=${ board.no }" class="click">
							<c:out value="${ board.title }"/>
						</a>
					</td>
					<td>${ board.writer }</td>
					<td>${ board.view_cnt }</td>
				</tr>
			</c:forEach>
		</table>
		
		<c:if test="${ not empty userVO }">
			<input type="button" value="글 등록" onclick="writeBoard()" style="margin-bottom: 10px;"/>
		</c:if>
		
		<br>
		<form action="/mysite/controller/board" method="get">
			<input type="hidden" name="a" value="boardList"/>
			<select name="searchType">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="content">내용</option>
				<option value="title+content">제목+내용</option>
			</select>&nbsp;
			<input type="text" name="keyword" maxlength="20"/>&nbsp;
			<input type="submit" value="검색"/>
		</form>
		
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>