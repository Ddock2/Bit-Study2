<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 콘솔 출력으로 확인 (로그)
	String param = request.getParameter("id");
	System.out.println(param);
	
	// 영역을 공유하지 않으니, parameter를 받아 user 영역에 등록
	request.setAttribute("id", param);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		sendRedirect 전송은 영역을 공유하지 않기에, 출력되지 않는다.
		즉, 자기만의 영역을 새로 생성 (EL로 출력하기 위해)
	--%>
	<h2>${id}님이 입장하셨습니다</h2>
</body>
</html>