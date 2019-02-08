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
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="content" align="center">
		<hr width="80%">
		<h2>회원 가입</h2>
		<hr width="80%">
		<br>
		
		<form action="signUp.jsp" method="post">
			<table style="width: 80%;" border="1">
				<tr>
					<th width="25%">아이디</td>
					<td>
						<input type="text" size="20" maxlength="20" name="id"/>
					</td>
				</tr>
				<tr>
					<th width="25%">이름</td>
					<td>
						<input type="text" size="10" maxlength="10" name="name"/>
					</td>
				</tr>
				<tr>
					<th width="25%">비밀번호</td>
					<td>
						<input type="password" size="20" maxlength="20" name="password"/>
					</td>
				</tr>
				<tr>
					<th width="25%">이메일</td>
					<td>
						<input type="text" size="20" maxlength="20" name="email_id"/>@
						<input type="text" size="20" maxlength="20" name="email_domain1"/>
						<select name="email_domain2" onchange="em">
							<option value="naver.com">naver.com</option>
							<option value="gmail.com">gmail.com</option>
							<option value="daum.net">daum.net</option>
							<option value="0" selected="selected">직접입력</option>
						</select>					
					</td>
				</tr>
				<tr>
					<th width="25%">핸드폰</td>
					<td>
						<select name="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="019">019</option>
						</select>-
						<input type="text" size="4" maxlength="4" name="tel2">-
						<input type="text" size="4" maxlength="4" name="tel3">
					</td>
				</tr>
				<tr>
					<th width="25%">우편번호</td>
					<td>(우)
						<input type="text" size="5" maxlength="5" name="post"/>
					</td>
				</tr>
				<tr>
					<th width="25%">기본 주소</td>
					<td>
						<textarea rows="2" cols="40" maxlength="60" name="basic_addr"></textarea>
					</td>
				</tr>
				<tr>
					<th width="25%">상세 주소</td>
					<td>
						<textarea rows="2" cols="40" maxlength="60" name="detail_addr"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="가입"/>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>