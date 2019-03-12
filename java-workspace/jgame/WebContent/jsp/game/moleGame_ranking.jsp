<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 사용자 CSS -->
<link rel="stylesheet" href="/jgame/css/gameRanking.css"/>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(document).ready(function(){
		for(var i=0; i<=2; i++){
			if($('.rank').eq(i).text() <= 3){
				$('.rank').eq(i).parent().addClass('ranker');
			}
		}
	});
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>게임 순위</h2>
		<hr width="60%">
		<table class="select">
			<tr>
				<th>전체 랭킹</th>
				<th>주먹 랭킹</th>
				<th>망치 랭킹</th>
			</tr>
		</table>
		<c:choose>
			<c:when test="${ not empty recordList }">
				<table id="board-list" class="table">
					<thead class="thead-light">
						<tr>
							<th width="15%" height="40" scope="col">등수</th>
							<th width="50%" scope="col">아이디</th>
							<th width="20%" scope="col">아이템</th>
							<th width="15%" scope="col">점수</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="record" items="${ recordList }">
						<tr>
							<td scope="row" class="rank">${ record.no }</td>
							<td>
								<img src="/jgame/profile_img/${ record.profile_img_save_name }" class="rank-img"/><c:out value="${ record.id }"/>
							</td>
							<td>${ record.item }</td>
							<td>${ record.score }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				
				<div id="page-buttons">
					<c:choose>
						<c:when test="${ empty searchType }">
							<a href="/jgame/controller/board?a=boardList&page=1" class="click" title="첫 페이지"> < </a>
							<a href="/jgame/controller/board?a=boardList&page=${ curPage - 1 }" class="click" title="이전 페이지"> < </a>
							<c:forEach var="pageNo" begin="${ curPage }" end="${ curPage + 4 }">
								<c:if test="${ (pageNo-2 >= 1) and (pageNo-2 <= lastPage) }">
									<a href="/jgame/controller/board?a=boardList&page=${ pageNo-2 }" class="click"> ${ pageNo-2 } </a>
								</c:if>
							</c:forEach>
							<a href="/jgame/controller/board?a=boardList&page=${ curPage + 1 }" class="click" title="다음 페이지"> > </a>
							<a href="/jgame/controller/board?a=boardList&page=${ lastPage }" class="click" title="끝 페이지"> > </a>
						</c:when>
						<c:otherwise>
							<a href="/jgame/controller/board?a=boardList&page=1&searchType=${searchType}&keyword=${keyword}" class="click" title="첫 페이지"> < </a>
							<a href="/jgamae/controller/board?a=boardList&page=${ curPage - 1 }&searchType=${searchType}&keyword=${keyword}" class="click" title="이전 페이지"> < </a>
							<c:forEach var="pageNo" begin="${ curPage }" end="${ curPage + 4 }">
								<c:if test="${ (pageNo-2 >= 1) and (pageNo-2 <= lastPage) }">
									<a href="/jgame/controller/board?a=boardList&page=${ pageNo-2 }&searchType=${searchType}&keyword=${keyword}" class="click"> ${ pageNo-2 } </a>
								</c:if>
							</c:forEach>
							<a href="/jgame/controller/board?a=boardList&page=${ curPage + 1 }&searchType=${searchType}&keyword=${keyword}" class="click" title="다음 페이지"> > </a>
							<a href="/jgame/controller/board?a=boardList&page=${ lastPage }&searchType=${searchType}&keyword=${keyword}" class="click" title="끝 페이지"> > </a>
						</c:otherwise>
					</c:choose>
				</div>
			</c:when>
			<c:otherwise>
				아직 입력된 기록이 없습니다
			</c:otherwise>
		</c:choose>
		
	</div>
	
</body>
</html>