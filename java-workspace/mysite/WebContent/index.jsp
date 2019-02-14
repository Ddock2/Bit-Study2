<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function hiBoardList(){
		location.href = "/mysite/controller/board?a=boardList"
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"></jsp:include>
	</div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<a style="font-size: 2em;">메인인데 아무것도 없쥬</a>
		<br>
		<img src="/mysite/image/void.png" style="width: 200px; height: 200px;"/>
		<br>
		<button type="button" onclick="hiBoardList()">게시판으로</button>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>