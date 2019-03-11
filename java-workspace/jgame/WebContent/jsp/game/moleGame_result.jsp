<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jgame/css/gameResult.css"/>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	function checkLogin(){
		if(${empty userVO}){
			if(!confirm('로그인 하시겠습니까?')){
				alert('그럼 등록 못해요');
				return false;
			}
			window.open('/jgame/controller/member?a=popLogin', '' , 'top=100, left=100, width=200, height=500');
	  		$('#result-form').attr('action', '');
		}
		return true;
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp" />
	</div>
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>게임 결과</h2>
		<hr width="80%">
		<br>
		<form id="result-form" action="/jgame/controller/game?a=save_moleGame_result" method="POST" onsubmit="return checkLogin()">
			<table id="game-result-table">
				<tr>
					<th>아이템</th>
					<th>점수</th>
				</tr>
				<tr>
					<td><input type="text" value="${ type }" name="type" readonly></td>
					<td><input type="text" value="${ score }" name="score" readonly></td>
				</tr>
			</table>
			<br>
			<button type="submit" class="btn btn-default">순위 등록</button>
		</form>
	</div>
</body>
</html>