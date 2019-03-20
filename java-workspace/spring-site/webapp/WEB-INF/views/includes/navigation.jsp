<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test="${ param.menu == 'main' }">
				<li class="selected"><a href="${pageContext.request.contextPath}">BIT</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 1</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 2</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 3</a></li>
				<li><a href="${pageContext.request.contextPath}">Menu 4</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}">?</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>