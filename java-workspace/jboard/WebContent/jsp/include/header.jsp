<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	table { 
		width: 100%;
	}
	
	img {
		boarder: 1px;
		width: 70px;
		height: 70px;
	}
</style>

<table border="1">
	<tr>
		<td rowspan="2" style="width:200px; height:20px;" align="center">
			<a href="/jboard">
				<img src="/jboard/image/good.png"/>
			</a>
		</td>
	</tr>
	<tr align="center">
		<!-- 
			로그인 전 : 자유 게시판 || 회원가입 || 로그인
			슈퍼 유저 : 회원관리 || 자유 게시판 || 로그아웃
			일반 유저 : 자유 게시판 || 마이페이지 || 로그아웃
		-->
		<th>
			<!-- 사용자가 관리자 일때 -->
			<c:if test="${ userVO.type == 'S'}">
				<a href="/jboard/jsp/member/userList.jsp">회원관리</a> ||
			</c:if>
			
			<!-- 조건에 상관없이 -->
			<a href="/jboard/list.do">자유 게시판</a> ||
			
			<c:choose>
				<%-- userVO 세션 정보가 없다면 --%>
				<c:when test="${ empty userVO }">
					<a href="/jboard/jsp/member/signUpForm.jsp">회원가입</a> ||
					<a href="/jboard/loginForm.do">로그인</a>
				</c:when>
				<c:otherwise>
					<c:if test="${ userVO.type == 'U' }">
						<a href="/jboard/jsp/member/myPage.jsp">마이페이지</a> ||
					</c:if>
					<a href="/jboard/logout.do">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</th>
	</tr>
</table>