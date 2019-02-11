<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function doList(){
		location.href="/jboard/list.do";
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="content" align="center">
		<hr width="80%">
		<h2>글 등록</h2>
		<hr width="80%">
		<br>
		
		<form name="wForm" action="/jboard/write.do" method="post" enctype="multipart/form-data">
			<table style="width: 80%;" border="1">
				<tr>
					<th width="25%">제목</th>
					<td>
						<input type="text" size="80" name="title" />
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
						<textarea rows="8" cols="80" name="content"></textarea>
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
			<input type="submit" value="등록"/>
			<input type="button" value="목록" onclick="doList()"/>
		</form>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>