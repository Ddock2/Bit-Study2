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
		<c:choose>
			<c:when test="${ not empty boardList }">
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
				
				<div id="page-buttons">
					<c:choose>
						<c:when test="${ empty searchType }">
							<a href="/mysite/controller/board?a=boardList&page=1" class="click" title="첫 페이지"> < </a>
							<a href="/mysite/controller/board?a=boardList&page=${ curPage - 1 }" class="click" title="이전 페이지"> < </a>
							<c:forEach var="pageNo" begin="${ curPage }" end="${ curPage + 4 }">
								<c:if test="${ (pageNo-2 >= 1) and (pageNo-2 <= lastPage) }">
									<a href="/mysite/controller/board?a=boardList&page=${ pageNo-2 }" class="click"> ${ pageNo-2 } </a>
								</c:if>
							</c:forEach>
							<a href="/mysite/controller/board?a=boardList&page=${ curPage + 1 }" class="click" title="다음 페이지"> > </a>
							<a href="/mysite/controller/board?a=boardList&page=${ lastPage }" class="click" title="끝 페이지"> > </a>
						</c:when>
						<c:otherwise>
							<a href="/mysite/controller/board?a=boardList&page=1&searchType=${searchType}&keyword=${keyword}" class="click" title="첫 페이지"> < </a>
							<a href="/mysite/controller/board?a=boardList&page=${ curPage - 1 }&searchType=${searchType}&keyword=${keyword}" class="click" title="이전 페이지"> < </a>
							<c:forEach var="pageNo" begin="${ curPage }" end="${ curPage + 4 }">
								<c:if test="${ (pageNo-2 >= 1) and (pageNo-2 <= lastPage) }">
									<a href="/mysite/controller/board?a=boardList&page=${ pageNo-2 }&searchType=${searchType}&keyword=${keyword}" class="click"> ${ pageNo-2 } </a>
								</c:if>
							</c:forEach>
							<a href="/mysite/controller/board?a=boardList&page=${ curPage + 1 }&searchType=${searchType}&keyword=${keyword}" class="click" title="다음 페이지"> > </a>
							<a href="/mysite/controller/board?a=boardList&page=${ lastPage }&searchType=${searchType}&keyword=${keyword}" class="click" title="끝 페이지"> > </a>
						</c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:otherwise>
				<c:choose>
						<c:when test="${ empty searchType }">
							아직 입력된 게시글이 없습니다<br>
							로그인 후 글을 입력해 보아요
						</c:when>
						<c:otherwise>
							검색 결과가 없습니다
						</c:otherwise>
					</c:choose>
			</c:otherwise>
		</c:choose>
		
		<div style="width: 70%;">
			<c:if test="${ not empty userVO }">
				<input type="button" value="글 등록" onclick="writeBoard()" style="margin-bottom: 10px; float: right;"/>
			</c:if>
			<div style="clear: both;"></div>
		</div>
		
		<form action="/mysite/controller/board" method="get">
			<input type="hidden" name="a" value="boardList"/>
			<select name="searchType">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
				<option value="content">내용</option>
				<option value="title+content">제목+내용</option>
			</select>&nbsp;
			<input type="text" placeholder="아무것도 안쓰면 전체게시글" name="keyword" maxlength="20"/>&nbsp;
			<input type="submit" value="검색"/>
		</form>
		
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>