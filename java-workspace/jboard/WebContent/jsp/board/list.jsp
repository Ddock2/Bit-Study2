<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function doAction(boardNo){
		<c:choose>
			<c:when test="${ not empty userVO }">
				location.href= "/jboard/boardDetail.do?no=" + boardNo;
			</c:when>
			<c:otherwise>
				if(confirm('로그인 후 사용 가능합니다.\n로그인 페이지로 이동하시겠습니까?'));
				location.href= "/jboard/loginForm.do";
			</c:otherwise>
		</c:choose>
	}

	function moveWriteForm() {
		location.href = "/jboard/writeForm.do";
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="content" align="center">
		<hr width="80%">
		<h2>자유 게시판</h2>
		<hr width="80%">
		<br>
		
		<table style="width: 60%;" border="1">
			<tr>
				<th width="8%">번호</th>
				<th width="30%">제목</th>
				<th width="15%">작성자</th>
				<th width="20%">등록일</th>
				<th width="8%">조회수</th>
			</tr>
			<c:forEach var="board" items="${ list }" varStatus="loop">
				<tr>
					<td align="center">${ board.no }</td>
					<th align="center">
						<a href="javascript:doAction('${board.no}')">
							<c:out value="${ board.title }"/>
						</a>
					</th>
					<td align="center">${ board.writer }</td>
					<td align="center">${ board.reg_date }</td>
					<td align="center">${ board.view_cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
		<c:if test="${ not empty userVO }">
			<input type="button" value="글 등록" onclick="moveWriteForm()"/>
		</c:if>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>