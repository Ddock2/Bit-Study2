<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bit.util.ConnectionFactory" %>
<%@ page import="com.bit.util.JDBCClose" %>
<%
	// DAO 코드 삽입
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String oldPassword = request.getParameter("oldPassword");
	String newPassword = request.getParameter("newPassword");
	String email_id = request.getParameter("email_id");
	
	String email_domain = "";
	if((email_domain = request.getParameter("email_domain1")).isEmpty()){
		email_domain = request.getParameter("email_domain2");
	}
	
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	
	String post = request.getParameter("post");
	String basic_addr = request.getParameter("basic_addr");
	String detail_addr = request.getParameter("detail_addr");
	
	Connection con = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append(" UPDATE j_member ");
	sql.append("    SET name= ?, password = ?, email_id = ?, email_domain = ? ");
	sql.append("        , tel1 = ?, tel2 = ?, tel3 = ?, post = ?, basic_addr = ?, detail_addr = ? ");
	sql.append(" 	WHERE id = ? AND password = ? ");
	
	PreparedStatement pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, name);
	pstmt.setString(2, newPassword);
	pstmt.setString(3, email_id);
	pstmt.setString(4, email_domain);
	pstmt.setString(5, tel1);
	pstmt.setString(6, tel2);
	pstmt.setString(7, tel3);
	pstmt.setString(8, post);
	pstmt.setString(9, basic_addr);
	pstmt.setString(10, detail_addr);
	pstmt.setString(11, id);
	pstmt.setString(12, oldPassword);
	
	int check = pstmt.executeUpdate();
	request.setAttribute("check", check);
	
	JDBCClose.close(con, pstmt);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<br><br>
		<c:if test="${check == 0}">
			<h2>입력한 현재 비밀번호가 일치하지 않습니다.</h2>
		</c:if>
		<c:if test="${check == 1}">
			<h2>정보 수정에 성공하였습니다.</h2>
		</c:if>
		
		<a href="/jboard">메인으로 가기</a>
	</div>
</body>
</html>