<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test="${ param.menu == 'main' }">
				<li class="selected"><a href="${pageContext.request.contextPath}">BIT</a></li>
				<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 3</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 4</a></li>
			</c:when>
			<c:when test="${ param.menu == 'board' }">
				<li><a href="${pageContext.request.contextPath}">BIT</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 3</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 4</a></li>
			</c:when>
			<c:when test="${ param.menu == 'gallery' }">
				<li><a href="${pageContext.request.contextPath}">BIT</a></li>
				<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 3</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 4</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}">BIT</a></li>
				<li><a href="${pageContext.request.contextPath}/board">게시판</a></li>
				<li><a href="${pageContext.request.contextPath}/gallery">갤러리</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 3</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 4</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>