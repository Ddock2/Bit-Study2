<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<% response.sendRedirect("admin.jsp"); %> --%>
	
	<!-- 
		sendRedirectSet.jsp로 이동하면,
		스크립틀릿을 수행하기에 admin.jsp로 바로 이동!
	 -->
	
	<c:if test="${param.id eq 'admin' }">
		<% response.sendRedirect("admin.jsp"); %>
	</c:if>
	 <c:if test="${ param.id ne 'admin' }">
		<%	
			// URL에 파라미터를 포함하는 GET 방식을 흉내
			String path = "user.jsp?id=" + request.getParameter("id");
			response.sendRedirect(path);
		%>
	</c:if>
</body>
</html>