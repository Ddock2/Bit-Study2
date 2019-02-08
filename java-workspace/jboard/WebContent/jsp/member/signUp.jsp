<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bit.util.ConnectionFactory" %>
<%@ page import="com.bit.util.JDBCClose" %>
<%
	// DAO 코드 삽입
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email_id = request.getParameter("email_id");
	
	String email_domain = "";
	if((email_domain = request.getParameter("email_domain1")) == null){
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
	sql.append(" INSERT INTO j_member( ");
	sql.append(" 			id, name, password, email_id, email_domain, ");
	sql.append(" 			tel1, tel2, tel3, post, basic_addr, detail_addr ) ");
	sql.append(" 		VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	
	PreparedStatement pstmt = con.prepareStatement(sql.toString());
	pstmt.setString(1, id);
	pstmt.setString(2, name);
	pstmt.setString(3, password);
	pstmt.setString(4, email_id);
	pstmt.setString(5, email_domain);
	pstmt.setString(6, tel1);
	pstmt.setString(7, tel2);
	pstmt.setString(8, tel3);
	pstmt.setString(9, post);
	pstmt.setString(10, basic_addr);
	pstmt.setString(11, detail_addr);
	
	pstmt.executeUpdate();
	
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
		<h2>회원 가입에 성공하였습니다.</h2>
		<a href="/jboard/loginForm.do">로그인 하기</a>
	</div>
</body>
</html>