<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// pageContext 영역
	pageContext.setAttribute("msg", "page 영역에 등록");
	
	// request 영역
	request.setAttribute("msg", "request 영역에 등록");
	
	// JSP 표현식을 활용하기 위해 영역의 데이터를 가져와라
	String pageMsg = (String) pageContext.getAttribute("msg");
	String reqMsg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		EL 탐색 순서 (Scope를 지정하지 않았을 경우)
			pageContext -> request -> session -> application
	 -->
	empty msg : ${ empty msg } <br>
	empty request msg : ${ empty requestScope.msg } <br>	<!-- requestScope.msg : request 영역의 msg -->
	msg : ${ msg } <br>
	request msg : ${ requestScope.msg } <br>
	
	pageContext msg : <%= pageMsg %> <br>
	request msg : <%= reqMsg %> <br>
	
	<%--
		JSP 방법 : 해당 영역에 있는 Attribute를 간접적으로 가져온다
		EL  방법 : 해당 영역의 Attribute를 직접 가져온다
	--%>
</body>
</html>