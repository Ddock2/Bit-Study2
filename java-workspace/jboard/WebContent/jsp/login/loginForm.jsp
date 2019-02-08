<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	// 동작 맛보기 (JavaScript)
	// 		- JSP 스크립틀릿을 활용하면 단순 동작도 서버를 거치게 된다.
	//		- 로그인 시 입력하지 않은 input 태그의 처리를 클라이언트에서 하겠다.
	//		- 클라이언트에서 동작하는 JavaScript 활용!
	
	// 요소와 메세지를 전달받아 공백임을 판단하고, 메세지를 출력하는 함수
	function isNull(obj, msg) {
		if(obj.value == ''){
			alert(msg);
			obj.focus();	// 해당 요소에 입력
			return true
		}
		return false;
	}
	
	function doAction(){
		var form = document.lForm;	// form 변수에 문서 요소인 lForm을 대입
		
		// lForm 내부의 id, password에 대한 예외 처리
		if(isNull(form.id, '아이디를 입력해주세요!')){return false}
		if(isNull(form.password, '비밀번호를 입력해주세요!')){return false};
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"/>
	</div>
	
	<div id="content" align="center">
		<hr width="80%">
		<h2>로그인</h2>
		<hr width="80%">
		<br>
		
		<form action="/jboard/login.do" method="post" name="lForm" onsubmit="return doAction()">
			<table style="width: 40%;">
				<tr>
					<th width="50%">아이디</th>
					<td>
						<input type="text" name="id" size="20"/>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="password" size="20"/>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="로그인"/>
		</form>
	</div>
		
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>