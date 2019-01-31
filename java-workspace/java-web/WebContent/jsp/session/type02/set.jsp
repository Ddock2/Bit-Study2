<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 세션 등록
	session.setAttribute("id", id);
	session.setAttribute("password", password);
%>
<h2>세션 등록 완료</h2>
<a href="get.jsp">세션 설정 확인 </a>