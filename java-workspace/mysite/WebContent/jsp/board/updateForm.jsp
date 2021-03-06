<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#write-table {
		width: 60%;
		border: 1px solid;
	}

	#write-table th, td {
		border: 1px solid;
	}
	
	#write-table td {
		padding: 0 5px;
	}
</style>
<script>
	function goToBack(){
		location.href = '/mysite/controller/board?a=boardDetail&no=' + ${ param.no }
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
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h2>글 수정</h2>
		<hr width="80%">
		<br>
		
		<form action="/mysite/controller/board?a=updateProcess" method="post" onsubmit="return checkForm()" enctype="multipart/form-data">
			<table id="write-table">
				<input type="hidden" name="no" value="${ boardVO.no }"/>
				<tr>
					<th width="25%">제목</th>
					<td>
						<input type="text" size="80" name="title" id="title" value="${ boardVO.title }"/>
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
						<textarea rows="8" cols="80" name="content" id="content">${ boardVO.content }</textarea>
					</td>
				</tr>
				<tr>
					<th rowspan="2">첨부파일</th>
					<td>
						<input type="file" name="attachFile1" size="40"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="file" name="attachFile2" size="40"/>
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="수정"/>&nbsp;&nbsp;
			<input type="button" value="취소" onclick="goToBack()"/>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>