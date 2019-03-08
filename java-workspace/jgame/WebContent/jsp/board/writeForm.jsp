<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 사용자 CSS -->
<link rel="stylesheet" href="/jgame/css/writeForm.css"/>
<script>
	function goTo(page){
		location.href = page;
	}
	
	function checkForm(){
		if(document.getElementById('title').value == ""){
			alert('제목도 입력 안하고??');
			document.getElementById('title').focus();
			return false;
		}
		
		if(document.getElementById('content').value == ""){
			alert('글도 입력 안하고??');
			document.getElementById('content').focus();
			return false;
		}
		
		return true;
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>글 등록</h2>
		<hr width="80%">
		<br>
		
		<form action="/jgame/controller/board?a=writeProcess" method="post" onsubmit="return checkForm()">
			<table id="write-table">
				<tr>
					<th width="25%">제목</th>
					<td>
						<input type="text" size="80" name="title" id="title"/>
					</td>
				</tr>
				<tr>
					<th width="25%">작성자</th>
					<input type="hidden" name="writer" value="${ userVO.id }"/>
					<td>${ userVO.id }</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>
						<textarea rows="8" cols="80" name="content" id="content"></textarea>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="등록"/>&nbsp;&nbsp;
			<input type="button" value="취소" onclick="goTo('/jgame/controller/board?a=boardList')"/>
		</form>
	</div>

</body>
</html>