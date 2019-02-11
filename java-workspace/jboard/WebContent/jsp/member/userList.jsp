<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.bit.member.db.MemberDAO" %>
<%@ page import="com.bit.member.db.MemberVO" %>
<!DOCTYPE html>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.selectAllMember();
	pageContext.setAttribute("list", list);	// EL을 위한 pageContext 영역 등록
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp" />
	</div>

	<div id="content" align="center">
		<hr width="80%">
		<h2>회원 목록</h2>
		<hr width="80%">
		<br>
		
		<table style="width: 80%;" border="1">
			<tr>
				<th width="15%">아이디</th>
				<th width="10%">이름</th>
				<th width="15%">비밀번호</th>
				<th width="20%">전화번호</th>
				<th width="5%">등급</th>
				<th width="15%">가입일</th>
			</tr>
			<c:forEach var="member" items="${ list }">
				<tr>
					<td align="center">${ member.id }</td>
<%-- 					<td align="center">${ member.name }</td> --%>
					<td align="center">
						<a href="/jboard/jsp/member/userDetail.jsp?id=${ member.id }">
							<c:out value="${ member.name }"/>
						</a>
					</td>
					<td align="center">${ member.password }</td>
					<td align="center">${ member.tel1 }-${ member.tel2 }-${ member.tel3 }</td>
					<td align="center">${ member.type }</td>
					<td align="center">${ member.reg_date }</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>