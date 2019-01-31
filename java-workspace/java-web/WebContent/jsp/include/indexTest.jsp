<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		다른 파일을 삽입하여,
		JSP를 Java로 변환 후 컴파일 동작
		include directive
	--%>
	<%@ include file="common.jsp" %>
	<h2>정적인 include</h2>
	<%= msg %><br>
	
	<%--
		include 요청 시 실행흐름을 옮김으로,
		해당 파일의 결과를 현 위치에 포험
		include action
	--%>
	<h2>동적인 include</h2>
	<h3>parameter 설정 전</h3>
	<jsp:include page="dynamic.jsp" />
	<h3>parameter 설정 후</h3>
	<jsp:include page="dynamic.jsp">
		<jsp:param value="Hello!!!" name="id"/>
	</jsp:include>
	<%-- include 시 parameter를 dynamic.jsp에 전달 --%>
	<%--
		<jsp:include> 내부에 주석을 사용할 수 없다
			->Jasper 엔진 버그
		Jasper Engine
			: 웹 클라이언트가 페이지를 요청했을 때,
			    해당 페이지를 찾아 서블릿으로 변환하는 역할
	--%>
</body>
</html>