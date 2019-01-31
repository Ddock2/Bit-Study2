<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>1 ~ 10까지의 합계</h3>
	<%
		int sum = 0;
		for(int i=1; i<=10; i++){
			sum += i;
			
	%>
	<%= i %><br>
	<%
		}
		out.print("1~10까지의 총합 : " + sum);
	%>
	<br>
	결과 : <%=sum %>
</body>
</html>