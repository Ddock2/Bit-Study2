<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
	String[] members = {"박신혜", "임시완", "손흥민", "한채영"};
	pageContext.setAttribute("members", members);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 배열 순회 --%>
	<c:forEach var="m" items="${pageScope.members}">	<%-- for(String m : member){ --%>
		${m} 
	</c:forEach>	<%--} --%>
	
	<br><br>
	
	<%-- 구분자 넣기 --%>
	<c:forEach var="m" items="${pageScope.members}" varStatus="loop">	<%-- for(String m : member){ --%>
		<c:if test="${not loop.first}">
			,
		</c:if>
		${m}
	</c:forEach>	<%--} --%>
	
	<br><br>
	
	<%-- for 반복문처럼 사용 --%>
	1 ~ 10까지의 정수 출력 <br>
	<c:forEach var="i" begin="1" end="10">	<%-- for(int i=1; i<=10; i++){ --%>
		${i} 
	</c:forEach>	<%--} --%>
	<br><br>
	
	1 ~ 100까지의 정수 합계 출력<br>
	<c:set var="result" value="0" />
	<c:forEach var="i" begin="1" end="100">
		<c:set var="result" value="${result + i}" />
	</c:forEach>
	${ result }
	<br><br>
	
	연도 선택 : 
	<select>
		<c:forEach var="year" begin="1970" end="2019">
			<option>${year}</option>
		</c:forEach>
	</select>
</body>
</html>