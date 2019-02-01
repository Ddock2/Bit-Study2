<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라미터 전달</h2>
	<jsp:include page="ifTag.jsp">
		<jsp:param name="type" value="U"/>
	</jsp:include>
	
	<jsp:include page="chooseTag.jsp">
		<jsp:param name="type" value="S"/>
	</jsp:include>
	<jsp:include page="chooseTag.jsp">
		<jsp:param name="type" value="U"/>
	</jsp:include>
	<jsp:include page="chooseTag.jsp" />
</body>
</html>