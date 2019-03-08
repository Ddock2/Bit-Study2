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
      <jsp:include page="/jsp/include/top.jsp"/>
    </div>
	
	<div id="contents" align="center" style="min-height: 15em;">
		<h1>My Page</h1>
		<hr width="80%">
		<img src="/jgame/profile_img/${ userVO.profile_img_save_name }">
	</div>
</body>
</html>