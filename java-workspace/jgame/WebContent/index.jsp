<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 사용자 CSS -->
<link rel="stylesheet" href="/jgame/css/layout.css"/>
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	$(document).ready(function(){
		$('#play').mouseenter(function(){
			$(this).animate({
				height: '250px',
				width: '250px'
			});
		});
		$('#play').mouseleave(function(){
			$(this).animate({
				height: '225px',
				width: '225px'
			})
		});
	});
	
	function doAction(target){
		location.href =  target;
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/jsp/include/top.jsp" />
	</div>
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<div style="height:50px;"></div>
			<a href="javascript:doAction('/jgame/game/moleGameIntro')">
				<img id="play" src="/jgame/image/digda.png" style="border-style: dashed; width: 225px; height:225px;"/>
			</a>
		</div>
	</div>
</body>
</html>