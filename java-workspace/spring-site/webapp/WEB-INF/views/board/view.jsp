<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% pageContext.setAttribute("newLine", "\n"); %>
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
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글정보</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${boardVO.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<!--
								replace 사용
									- 글 등록 시 입력된 데이터의 형태 (Enter로 인한 개행 문자)
									- HTML에 표현할 형태 (HTML의 개행은 <br>)
									- *문서 출력 시 개행이 안되니 <br>로 변환
									- *양 쪽 입장을 생각하세요! (가져올 데이터와 HTML 문서의 각 입장)
							-->
							${ fn:replace(boardVO.content, newLine, "<br>")}
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/board?p=${page}&kwd=${keyword}">글목록</a>
					<c:if test="${not empty authUser}">
						<a href="${pageContext.request.contextPath}/board/reply?
							no=${boardVO.no}&p=${page}&kwd=${keyword}">답글 달기</a>
						<c:if test="${authUser.no == boardVO.userNo}">
							<a href="${pageContext.request.contextPath}/board/modify?
								no=${boardVO.no}&p=${page}&kwd=${keyword}">글수정</a>
						</c:if>
					</c:if>
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board"/>
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>