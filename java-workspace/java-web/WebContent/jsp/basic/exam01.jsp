<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		JSP : HTML문서 내에 부분적으로 Java 코드를 작성,
			  Java 코드를 작성하기 위한 Scriptlet 사용
	 -->
	 <h3>1 ~ 10까지의 정수 출력</h3>
	 <%
	 	// 스크립틀릿 작성
	 	for(int i=1; i<=10; i++){
	 		out.print(i + "<br>");	// 문서에 출력
	 	}
	 %>
</body>
</html>