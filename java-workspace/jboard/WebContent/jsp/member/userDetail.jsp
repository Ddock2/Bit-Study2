<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page import="com.bit.member.db.MemberDAO" %>
<%@ page import="com.bit.member.db.MemberVO" %>
<%
	String id = request.getParameter("id");
	MemberDAO dao = new MemberDAO();
	MemberVO member = dao.selectById(id);
	pageContext.setAttribute("member", member);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function editData(){
		location.href = "/jboard/jsp/member/updateUserForm.jsp";
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp" />
	</div>

	<div id="content" align="center">
		<hr width="80%">
		<h2>회원 상세정보</h2>
		<hr width="80%">
		<br>
		
		<table style="width: 50%;" border="1">
			<tr>
				<th width="25%">아이디</th>
				<td>
					<c:out value="${ member.id }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">이름</th>
				<td>
					<c:out value="${ member.name }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">비밀번호</th>
				<td>
					<c:out value="${ member.password }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">전화번호</th>
				<td>
					<c:out value="${ member.tel1 }-${ member.tel2 }-${ member.tel3 }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">이메일</th>
				<td>
					<c:out value="${ member.email_id }@${ member.email_domain }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">우편번호</th>
				<td>
					<c:out value="${ member.post }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">기본주소</th>
				<td>
					<c:out value="${ member.basic_addr }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">상세주소</th>
				<td>
					<c:out value="${ member.detail_addr }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">등급</th>
				<td>
					<c:out value="${ member.type }"/>
				</td>
			</tr>
			<tr>
				<th width="25%">가입일</th>
				<td>
					<c:out value="${ member.reg_date }"/>
				</td>
			</tr>
		</table>
		<br>
		<c:if test="${ userVO.id == member.id }">
			<input type="button" value="수정" onclick="editData()"/>
		</c:if>
	</div>

	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>