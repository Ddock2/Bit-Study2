<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		많이 만나볼 대표적인 HTTP의 상태 코드
		4XX (요청 오류)
		400 : 요청을 인식하지 못한 상태
		404 : 요청한 페이지를 찾을 수 없는 상태
		405 : 해당 메소드 요청 방법을 사용할 수 없는 상태
				(POST 방식의 서버가 GET 방식 요청을 받았을 때
		
		5XX (서버 오류)
		500 : 서버에 오류가 발생해서 요청이 불가
		501 : 서버가 요청을 받았지만 해당 메소드를 찾지 못할 때
		503 : 서버(서비스)를 사용할 수 없는 상태(서버 오버로드, 다운 등의 상태)
		
		상태 코드 문서
		https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
	-->
	
	<div id="header">
		<jsp:include page="/jsp/include/header.jsp"/>
	</div>
	
	<div id="content">
		<jsp:include page="/jsp/include/content.jsp"/>
	</div>
	
	<div id="footer">
		<%@ include file="/jsp/include/footer.jsp" %>
	</div>
</body>
</html>