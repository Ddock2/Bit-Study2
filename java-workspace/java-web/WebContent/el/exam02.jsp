<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%
	String[] members = {"박신혜", "박효신", "한채영", "임시완"};
	
	// pageContext 영역에 등록
	pageContext.setAttribute("members", members);
	
	
	Map<String, String> employees = new HashMap<>();
	employees.put("e1001", "Steven");
	employees.put("e1002", "Smith");
	
	pageContext.setAttribute("employees", employees);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	JSP 표현식 활용<br>
	첫째 회원 : <%= members[0] %> <br>
	둘째 회원 : <%= members[1] %> <br>
	셋째 회원 : <%= members[2] %> <br>
	넷째 회원 : <%= members[3] %> <br><br>
	
	EL 표현식 활용<br>	<!-- 데이터가 null이라면 출력되지 않음 -->
	첫째 회원 : ${ members[0] } <br>
	둘째 회원 : ${ members[1] } <br>
	셋째 회원 : ${ members[2] } <br>
	넷째 회원 : ${ members[3] } <br><br>
	
	Map 객체 표현<br>
	직원(e1001) : <%= employees.get("e1001") %><br>
	직원(e1002) : <%= employees.get("e1002") %><br>
	직원(e1001) : ${ employees.e1001 }<br>
	직원(e1002) : ${ employees.e1002 }<br>
	
</body>
</html>