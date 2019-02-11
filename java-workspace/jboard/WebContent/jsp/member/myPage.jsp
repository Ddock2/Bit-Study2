<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<h2>마이페이지</h2>
		<hr width="80%">
		<br>
		
		<table style="width: 50%;" border="1">
			<tr>
				<th colspan="3">메뉴</th>
			</tr>
			<tr>
				<td width="33%" align="center">
					<a href="/jboard/jsp/member/userDetail.jsp?id=${ userVO.id }">내 정보 보기</a>
				</td>
				<td width="33%" align="center">?</td>
				<td width="33%" align="center">?</td>
			</tr>
		</table>
	</div>

	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>